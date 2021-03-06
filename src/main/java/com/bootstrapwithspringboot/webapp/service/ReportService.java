package com.bootstrapwithspringboot.webapp.service;

import com.bootstrapwithspringboot.webapp.model.Suspect;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private SuspectService repository;


    public String exportReport(String city) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\aho\\Desktop\\report";
        List<Suspect> suspects= new ArrayList<>();
        if (city.equals("")) {
            suspects = repository.findAll();
            //load file and compile it
            File file = ResourceUtils.getFile("classpath:suspectReport.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(suspects);
            Map<String, Object> parameters = new HashMap<>();

            parameters.put("createdBy", "Java Techie");


            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
//        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\suspects.pdf");
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\suspcts.html");
        }
        else {
            suspects = repository.findByCity(city);
            //load file and compile it
            File file = ResourceUtils.getFile("classpath:suspectReport.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(suspects);
            Map<String, Object> parameters = new HashMap<>();

            parameters.put("createdBy", "Java Techie");


            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
//        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\suspects.pdf");
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\"+city+".html");
        }
        return "report generated in path : " + path;
    }
}
