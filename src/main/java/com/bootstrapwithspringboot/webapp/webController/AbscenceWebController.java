package com.bootstrapwithspringboot.webapp.webController;

import com.bootstrapwithspringboot.webapp.dto.AbsStringDTO;
import com.bootstrapwithspringboot.webapp.dto.AbscenceDTO;
import com.bootstrapwithspringboot.webapp.model.Abscence;
import com.bootstrapwithspringboot.webapp.model.Etudiant;
import com.bootstrapwithspringboot.webapp.model.Matiere;
import com.bootstrapwithspringboot.webapp.service.AbscenceService;
import com.bootstrapwithspringboot.webapp.service.ClasseService;
import com.bootstrapwithspringboot.webapp.service.EtudiantService;
import com.bootstrapwithspringboot.webapp.service.MatiereService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;

@Controller
public class AbscenceWebController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String appMode;

    @Autowired
    private AbscenceService abscenceService;

    @Autowired
    private ClasseService classeService;

    @Autowired
    private MatiereService matiereService;

    @Autowired
    private EtudiantService etudiantService;

    @Autowired
    public AbscenceWebController(Environment environment){
        appMode = environment.getProperty("app-mode");
    }

    @GetMapping("/abscences")
    public String getAbscencePage(Model model){
        model.addAttribute("classes", classeService.findAll());
        return "abscence";
    }

    @GetMapping("/classe/{id}/getmatieres")
    public String getClasseMatierePage(@PathVariable long id, Model model){

        model.addAttribute("selectedClasse", classeService.getOneById(id).get());
        model.addAttribute("matieres", matiereService.findByClasse(id));
        model.addAttribute("classes", classeService.findAll());
        return "abscence";
    }

    @GetMapping("/classe/{Classeid}/getmatieres/{matiereid}")
    public String getListOfStudent(@PathVariable("Classeid") long classeid , @PathVariable("matiereid") long matiereid, Model model){

        model.addAttribute("selectedMatiere", matiereService.getById(matiereid));
        model.addAttribute("selectedClasse", classeService.getOneById(classeid).get());
        model.addAttribute("matieres", matiereService.findByClasse(classeid));
        model.addAttribute("classes", classeService.findAll());
        model.addAttribute("etudiants", etudiantService.findAllByClasse(classeid));

        model.addAttribute("absStringDTO", new AbsStringDTO());

        return "abscence";
    }

    @PostMapping("saveabs")
    public String saveAbs(Model model, AbsStringDTO absStringDTO){


        String [] tempArray = absStringDTO.getStudentString().split(",");

        if (!(Arrays.asList(tempArray).isEmpty())){

            for (int i=0; i<tempArray.length;i++) {
//                logger.info("saving abscence for"+tempArray[i]);
                Etudiant e= etudiantService.getOneById(tempArray[i]);
                Matiere m = matiereService.getById(absStringDTO.getMatiereid());
                AbscenceDTO a = new AbscenceDTO();

                abscenceService.save(new Abscence(a.getId(),e, m, LocalDate.now()));
            }
        }
        model.addAttribute("classes", classeService.findAll());
        return "abscence";
    }


}
