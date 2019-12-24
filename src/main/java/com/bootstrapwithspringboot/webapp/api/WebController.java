package com.bootstrapwithspringboot.webapp.api;

import com.bootstrapwithspringboot.webapp.dto.ClasseDto;
import com.bootstrapwithspringboot.webapp.dto.EtudiantDto;
import com.bootstrapwithspringboot.webapp.dto.MatiereDto;
import com.bootstrapwithspringboot.webapp.model.Classe;
import com.bootstrapwithspringboot.webapp.model.Etudiant;
import com.bootstrapwithspringboot.webapp.model.Matiere;
import com.bootstrapwithspringboot.webapp.service.ClasseService;
import com.bootstrapwithspringboot.webapp.service.EtudiantService;
import com.bootstrapwithspringboot.webapp.service.MatiereService;
import com.bootstrapwithspringboot.webapp.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Date;

@Controller
public class WebController {
    Logger logger =  LoggerFactory.getLogger(this.getClass());

    private String appMode;

    @Autowired
    private ClasseService classeService;

    @Autowired
    private EtudiantService etudiantService;

    @Autowired
    private MatiereService matiereService;

    @Autowired
    public WebController(Environment environment){
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

    @RequestMapping("/classes")
    public String classePage(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "admin1");
        model.addAttribute("mode", appMode);

        model.addAttribute("classes", classeService.findAll());


        return "classe";
    }

    @RequestMapping("/matieres")
    public String index(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "admin1");
        model.addAttribute("mode", appMode);

        model.addAttribute("matieres",matiereService.findAll());

        return "matiere";
    }


    @RequestMapping("classe/{id}/show")
    public String getSpecificClasse(@PathVariable long id, Model model){
        model.addAttribute("classe", classeService.getOne(id));
        model.addAttribute("etudiants", etudiantService.findAllByClasse(id));
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



    @GetMapping("/classeNew")
    public String createNewClassePage(Model model){
        model.addAttribute("classe", new ClasseDto());
        return "classeNew";
    }

    @GetMapping("/matiereNew")
    public String createNewMatierePage(Model model){
        model.addAttribute("matiere", new MatiereDto());
        return "matiereNew";
    }




    @PostMapping("/addetudiant")
    public String addOneEtudiant(Model model, EtudiantDto etudiantDto){

//        etudiantService.save(new Etudiant("00027","zoubair" , "baya","ah@ah.com", LocalDate.now(),"+21622222222"),1);
        etudiantService.save(new Etudiant(etudiantDto.getMatricule(),etudiantDto.getNom() , etudiantDto.getPrenom(),etudiantDto.getEmail(), LocalDate.parse(etudiantDto.getDateDeNaissance()),etudiantDto.getPhoneNumber()));
        model.addAttribute("etudiants", etudiantService.findAll());
        return "etudiant";
    }

    @PostMapping("/addclasse")
    public String addOneClasse(Model model, ClasseDto classeDto){

//        etudiantService.save(new Etudiant("00027","zoubair" , "baya","ah@ah.com", LocalDate.now(),"+21622222222"),1);
        classeService.save(new Classe(classeDto.getId(),classeDto.getLibel(),classeDto.getNomComplet()));
        model.addAttribute("classes", classeService.findAll());
        return "classe";
    }

    @PostMapping("/addmatiere")
    public String addOneMatiere(Model model, MatiereDto matiereDto){

        matiereService.save(new Matiere(matiereDto.getId(),matiereDto.getLibel(),matiereDto.getNumberHours(),matiereDto.getPermit()));
        model.addAttribute("matieres", matiereService.findAll());
        return "matiere";
    }



    @RequestMapping("classe/{id}/matiere")
    public String getMatiereByClasse(@PathVariable long id, Model model){

        model.addAttribute("matieres", matiereService.findByClasse(id));
        model.addAttribute("classes", classeService.findAll());
        return "classeMatiere";
    }





    /* delete */
    @GetMapping("matiere/{matiereid}/delete")
    public String deleteMatiere(@PathVariable long matiereid, Model model){
        System.out.println(matiereid);
        logger.warn(matiereid+"");
        matiereService.delete(matiereService.getById(matiereid));
        model.addAttribute("matieres", matiereService.findAll());
        return "matiere";
    }

    @GetMapping("etudiant/{matricule}/delete")
    public String deleteEtudiant(@PathVariable String matricule, Model model){

        etudiantService.delete(matricule);
        model.addAttribute("etudiants", etudiantService.findAll());
        return "etudiant";
    }

    @GetMapping("classe/{classeid}/delete")
    public String deleteClasse(@PathVariable long classeid, Model model){

        classeService.delete(classeid);
        model.addAttribute("classes", classeService.findAll());
        return "classe";
    }



    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "welcomePage";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "adminPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {

        return "login";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }



    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // After user login successfully.
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "userInfoPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "403Page";
    }
}
