package com.bootstrapwithspringboot.webapp.webController;

import com.bootstrapwithspringboot.webapp.dto.EtudiantDto;
import com.bootstrapwithspringboot.webapp.model.Etudiant;
import com.bootstrapwithspringboot.webapp.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Date;

@Controller
public class EtudiantWebController {

    private String appMode;

    @Autowired
    private EtudiantService etudiantService;

    @Autowired
    public EtudiantWebController(Environment environment){
        appMode = environment.getProperty("app-mode");
    }

    @RequestMapping("/etudiants")
    public String etudiantPage(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "admin1");
        model.addAttribute("mode", appMode);

        model.addAttribute("etudiants", etudiantService.findAll());

        return "etudiant";
    }

    @GetMapping("/etudiantNew")
    public String createNewEtudiantPage(Model model){
        int matricule = Integer.parseInt(etudiantService.maxMatricule())+1;

        String s ="";
        if (matricule<10){
            s="0000";
            s=s+matricule;
        }
        else if (matricule<100){
            s="000";
            s=s+matricule;
        }
        else if (matricule<1000){
            s="00";
            s=s+matricule;
        }
        else if (matricule<10000){
            s="0";
            s=s+matricule;
        }
        else if (matricule<100000){
            s=s+matricule;
        }


        model.addAttribute("etudiant", new EtudiantDto());
        model.addAttribute("maxMatricule",s);
        return "etudiantNew";
    }

    @PostMapping("/addetudiant")
    public String addOneEtudiant(Model model, EtudiantDto etudiantDto){
        etudiantService.save(new Etudiant(etudiantDto.getMatricule(),etudiantDto.getNom() , etudiantDto.getPrenom(),etudiantDto.getEmail(), LocalDate.parse(etudiantDto.getDateDeNaissance()),etudiantDto.getPhoneNumber()));
        model.addAttribute("etudiants", etudiantService.findAll());
        return "etudiant";
    }

    @GetMapping("etudiant/{matricule}/update")
    public String updateEtudiant(@PathVariable String matricule, Model model){


        model.addAttribute("etudiant", etudiantService.getOneById(matricule));
        return "etudiantUpdate";
    }

    @PostMapping("/updateEtudiant")
    public String saveupdate(Model model, Etudiant etudiant){
        etudiantService.save(etudiant);
        model.addAttribute("etudiants", etudiantService.findAll());
        return "etudiant";
    }

    @GetMapping("etudiant/{matricule}/delete")
    public String deleteEtudiant(@PathVariable String matricule, Model model){

        etudiantService.delete(matricule);
        model.addAttribute("etudiants", etudiantService.findAll());
        return "etudiant";
    }


}
