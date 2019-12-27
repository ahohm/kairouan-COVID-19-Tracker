package com.bootstrapwithspringboot.webapp.webController;

import com.bootstrapwithspringboot.webapp.dto.ClasseDto;
import com.bootstrapwithspringboot.webapp.model.Classe;
import com.bootstrapwithspringboot.webapp.service.ClasseService;
import com.bootstrapwithspringboot.webapp.service.EtudiantService;
import com.bootstrapwithspringboot.webapp.service.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class ClasseWebController {

    private String appMode;

    @Autowired
    private ClasseService classeService;

    @Autowired
    private EtudiantService etudiantService;

    @Autowired
    private MatiereService matiereService;

    @Autowired
    public ClasseWebController(Environment environment){
        appMode = environment.getProperty("app-mode");
    }

    @RequestMapping("/classes")
    public String classePage(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "admin1");
        model.addAttribute("mode", appMode);

        model.addAttribute("classes", classeService.findAll());


        return "classe";
    }

    @RequestMapping("classe/{id}/show")
    public String getSpecificClasse(@PathVariable long id, Model model){
        model.addAttribute("classe", classeService.getOne(id));
        model.addAttribute("etudiants", etudiantService.findAllByClasse(id));
        return "etudiant";
    }

    @GetMapping("/classeNew")
    public String createNewClassePage(Model model){
        model.addAttribute("classe", new ClasseDto());
        return "classeNew";
    }

    @PostMapping("/addclasse")
    public String addOneClasse(Model model, ClasseDto classeDto){
        classeService.save(new Classe(classeDto.getId(),classeDto.getLibel(),classeDto.getNomComplet()));
        model.addAttribute("classes", classeService.findAll());
        return "classe";
    }

    @RequestMapping("classe/{id}/matiere")
    public String getMatiereByClasse(@PathVariable long id, Model model){
        model.addAttribute("matieres", matiereService.findByClasse(id));
        model.addAttribute("classes", classeService.findAll());
        return "classeMatiere";
    }

    @GetMapping("classe/{classeid}/delete")
    public String deleteClasse(@PathVariable long classeid, Model model){
        classeService.delete(classeid);
        model.addAttribute("classes", classeService.findAll());
        return "classe";
    }


}
