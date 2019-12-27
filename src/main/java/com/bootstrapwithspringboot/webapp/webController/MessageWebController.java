package com.bootstrapwithspringboot.webapp.webController;

import com.bootstrapwithspringboot.webapp.batchBean.*;
import com.bootstrapwithspringboot.webapp.dto.MailDTO;
import com.bootstrapwithspringboot.webapp.dto.MatiereDto;
import com.bootstrapwithspringboot.webapp.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Properties;

@Controller
public class MessageWebController {

    @Autowired
    private EtudiantService etudiantService;


    @Autowired
    private Service service;


    @Autowired
    private MailConfig mailConfig;

    @Autowired
    private JavaMailSenderImpl javaMailSender;


    @GetMapping("/sms")
    public String getSmsPage(Model model){
        model.addAttribute("etudiants", etudiantService.findAll());
        return "pageSms";
    }

    @GetMapping("/sendsms/{matricule}")
    public String writeSms(Model model, @PathVariable String matricule){

        model.addAttribute("smsRequest", new SmsRequest());
        model.addAttribute("etudiant", etudiantService.getOneById(matricule));
        System.out.println(etudiantService.getOneById(matricule));
        return "pageSms";
    }

    @PostMapping("/sendsms")
    public String sendSms(Model model,SmsRequest smsRequest){
        try {

            service.sendSms(smsRequest);

            model.addAttribute("etudiants", etudiantService.findAll());
            return "pageSms";
        }
        catch (Exception e){
            model.addAttribute("etudiants", etudiantService.findAll());
            return "pageSms";
        }

    }



    @GetMapping("/email")
    public String getMailPage(Model model){
        model.addAttribute("etudiants", etudiantService.findAll());
        return "pageMail";
    }

    @GetMapping("/sendmail/{matricule}")
    public String writeMail(Model model, @PathVariable String matricule){

        model.addAttribute("mailDTO", new MailDTO());
        model.addAttribute("etudiant", etudiantService.getOneById(matricule));
        System.out.println(etudiantService.getOneById(matricule));
        return "pageMail";
    }

    @PostMapping("/sendmail")
    public String sendMail(Model model,MailDTO mailDTO){
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

        try {

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("noReply@no.replay");
            mailMessage.setSubject(mailDTO.getSubject());
            mailMessage.setCc(mailDTO.getMail());
            mailMessage.setText(mailDTO.getMessage());
            javaMailSender.send(mailMessage);



            model.addAttribute("etudiants", etudiantService.findAll());
            return "pageMail";
        }
        catch (Exception e){
            model.addAttribute("etudiants", etudiantService.findAll());
            return "pageMail";
        }

    }






}
