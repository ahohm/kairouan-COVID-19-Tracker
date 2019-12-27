package com.bootstrapwithspringboot.webapp.batchBean;

import com.bootstrapwithspringboot.webapp.model.*;
import com.bootstrapwithspringboot.webapp.service.AbscenceService;
import com.bootstrapwithspringboot.webapp.service.EliminationService;
import com.bootstrapwithspringboot.webapp.service.EtudiantService;
import com.bootstrapwithspringboot.webapp.service.MatiereService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
@ConditionalOnProperty(name = "spring.enable.scheduling")
public class CalculateAbscenceBatchBean {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MatiereService matiereService;

    @Autowired
    private EtudiantService etudiantService;

    @Autowired
    private AbscenceService abscenceService;

    @Autowired
    private EliminationService eliminationService;

    @Autowired
    private MailConfig mailConfig;

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Autowired
    private com.bootstrapwithspringboot.webapp.batchBean.Service service;

    /*  check if internet available*/
    public static boolean isInternetAvailable() throws IOException {
        return isHostAvailable("google.com") || isHostAvailable("amazon.com")
                || isHostAvailable("facebook.com")|| isHostAvailable("apple.com");
//            return false;
    }
    private static boolean isHostAvailable(String hostName) throws IOException {
        try(Socket socket = new Socket())
        {
            int port = 80;
            InetSocketAddress socketAddress = new InetSocketAddress(hostName, port);
            socket.connect(socketAddress, 3000);

            return true;
        }
        catch(UnknownHostException unknownHost)
        {
            return false;
        }
    }

    /*@Scheduled(cron = "0 17 * * FRI")*/
    @Scheduled(cron = "0/30 * * * * *")
    public void calculateAbscence() throws IOException {

        /*JavaMailSenderImpl mailSender = new JavaMailSenderImpl();*/
        javaMailSender.setHost(this.mailConfig.getHost());
        javaMailSender.setPort(this.mailConfig.getPort());
        javaMailSender.setUsername(this.mailConfig.getUsername());
        javaMailSender.setPassword(this.mailConfig.getPassword());

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.debug", "true");

        /*we can set properties from here*/
        /*Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");*/

        javaMailSender.setJavaMailProperties(javaMailProperties);

        List<Etudiant> etudiants = etudiantService.findAll();

        for (Etudiant etudiant : etudiants){
            List<Matiere> matieres = matiereService.findByClasse(etudiant.getClasse().getId());
            List<Elimination> eliminations = eliminationService.findAllByEtudiant(etudiant.getMatricule());
            List<Matiere> eliminatedMatiere = new ArrayList<>();
            for (Elimination elimination : eliminations){
                eliminatedMatiere.add(elimination.getEliminationIdentity().getMatiere());
            }
            for (Matiere matiere : matieres){
                if (!(eliminatedMatiere.contains(matiere))){
                    logger.info("calcule : "+etudiant.getPrenom()+matiere.getLibel());

                    List<Abscence> abscences = abscenceService.findAllByMatiereAndEtudiant(matiere, etudiant);
                    if (abscences.size()*1.5> matiere.getPermit()){
                        logger.debug("eliminated ::: NAME :: /*"+etudiant.getPrenom()+"*/ MATIERE ::"+matiere.getLibel()+", abscence ::"+abscences.size()*1.5);

                        eliminationService.save(new Elimination(new EliminationIdentity(etudiant,matiere)));
                        SimpleMailMessage mailMessage = new SimpleMailMessage();
                        mailMessage.setFrom("noReply@no.replay");
                        mailMessage.setSubject("Elimination");
                        mailMessage.setCc(etudiant.getEmail());
                        String text = "mr."+etudiant.getNom()+" "+etudiant.getPrenom()+". \n " +
                                "you have been eliminated from the exam of "+matiere.getLibel()+", \n because " +
                                "you passed the permit number of abscence("+matiere.getPermit()+"), " +
                                "you've done "+abscences.size()*1.5+" hours of abscence. \n we are sorry for you";

                        mailMessage.setText(text);
                        SmsRequest smsRequest =new SmsRequest(etudiant.getPhoneNumber(),text);

                        if(isInternetAvailable()){
                            javaMailSender.send(mailMessage);
                            service.sendSms(smsRequest);
                        }
                    }
                }

            }



        }
    }
}
