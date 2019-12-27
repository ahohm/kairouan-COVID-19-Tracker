package com.bootstrapwithspringboot.webapp.webController;

import com.bootstrapwithspringboot.webapp.dto.MatiereDto;
import com.bootstrapwithspringboot.webapp.model.Matiere;
import com.bootstrapwithspringboot.webapp.service.MatiereService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class MatiereWebController {

    Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MatiereService matiereService;

    private String appMode;

    @Autowired
    public MatiereWebController(Environment environment){
        appMode = environment.getProperty("app-mode");
    }

    @RequestMapping("/matieres")
    public String index(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "admin1");
        model.addAttribute("mode", appMode);

        model.addAttribute("matieres",matiereService.findAll());

        return "matiere";
    }

    @GetMapping("/matiereNew")
    public String createNewMatierePage(Model model){
        model.addAttribute("matiere", new MatiereDto());
        return "matiereNew";
    }

    @PostMapping("/addmatiere")
    public String addOneMatiere(Model model, MatiereDto matiereDto){
        matiereService.save(new Matiere(matiereDto.getId(),matiereDto.getLibel(),matiereDto.getNumberHours(),matiereDto.getPermit()));
        model.addAttribute("matieres", matiereService.findAll());
        return "matiere";
    }

    @GetMapping("matiere/{matiereid}/delete")
    public String deleteMatiere(@PathVariable long matiereid, Model model){
        System.out.println(matiereid);
        logger.warn(matiereid+"");
        matiereService.delete(matiereService.getById(matiereid));
        model.addAttribute("matieres", matiereService.findAll());
        return "matiere";
    }
}
