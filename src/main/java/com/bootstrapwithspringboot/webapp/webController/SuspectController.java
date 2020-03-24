package com.bootstrapwithspringboot.webapp.webController;

import com.bootstrapwithspringboot.webapp.dao.SuspectDao;
import com.bootstrapwithspringboot.webapp.dto.SuspectDto;
import com.bootstrapwithspringboot.webapp.dto.SuspectDtoNested;
import com.bootstrapwithspringboot.webapp.service.ReportService;
import com.bootstrapwithspringboot.webapp.service.SuspectService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;
import java.util.Date;

@Controller
public class SuspectController {

    private String appMode;

    @Autowired
    private SuspectService suspectService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private SuspectDao suspectDao;
    ;
    @Autowired
    public SuspectController(Environment environment){
        appMode = environment.getProperty("app-mode");
    }


    @RequestMapping("/suspects")
    public String etudiantPage(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "admin1");
        model.addAttribute("mode", appMode);

        model.addAttribute("suspects", suspectService.findAll());

        return "suspect";
    }


    @GetMapping("/quarentineNotFinish")
    public String notcomplete(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "admin1");
        model.addAttribute("mode", appMode);

        model.addAttribute("suspects", suspectService.notComplete());

        return "suspect";
    }


    @GetMapping("/quarentineFinish")
    public String complete(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "admin1");
        model.addAttribute("mode", appMode);

        model.addAttribute("suspects", suspectService.complete());

        return "suspect";
    }


    @GetMapping("/desciplines")
        public String noDescipline(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "admin1");
        model.addAttribute("mode", appMode);

        model.addAttribute("suspects", suspectService.findByDisciplin());

        return "suspect";
    }


    @GetMapping("/suspectNew")
    public String createNewEtudiantPage(Model model){
        model.addAttribute("suspect", new SuspectDto());
        //return "etudiantNew";
        return "suspectNew";
    }

    @PostMapping("/addsuspect")
    public String addOneEtudiant(Model model, SuspectDto suspectDto){
        try {

            suspectService.save(suspectDto);
            model.addAttribute("done", true);
            model.addAttribute("suspect", new SuspectDto());
        }catch (Exception e){
            model.addAttribute("done", false);
            model.addAttribute("suspect", suspectDto);
        }
        model.addAttribute("suspect", new SuspectDto());
        return "suspectNew";
    }


    @PostMapping("/addsuspect/{id}")
    public String addOneSuspect(Model model, @PathVariable long id ){
            model.addAttribute("suspect", new SuspectDto());
            model.addAttribute("parentSuspect", suspectService.getOneById(id).get());
        return "suspectNew1";
    }

    @GetMapping("/suspect/{id}/nondesciplin")
    public String displined(Model model, @PathVariable long id ){
        suspectService.setDesciplin(id);
        model.addAttribute("suspects", suspectService.findAll());
        return "suspect";
    }
    @GetMapping("/addNestedsuspect/{id}")
    public String nestedSuspect(Model model, @PathVariable long id ){
        SuspectDto dtoNested = new SuspectDto();
        dtoNested.setParentSuspect(id);
        model.addAttribute("suspect", dtoNested);
        return "suspectNew";
    }

    @RequestMapping("/city/{city}")
    public String sbikha(Model model, @PathVariable String city){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "admin1");
        model.addAttribute("mode", appMode);

        model.addAttribute("suspects", suspectService.findByCity(city));

        return "suspect";
    }



    @GetMapping("/printAll")
    public String printAll(Model model) throws FileNotFoundException, JRException {
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "admin1");
        model.addAttribute("mode", appMode);
        reportService.exportReport();
        model.addAttribute("suspects", suspectService.findAll());

        return "suspect";
    }

}
