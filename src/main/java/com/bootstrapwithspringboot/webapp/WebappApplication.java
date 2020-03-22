package com.bootstrapwithspringboot.webapp;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableScheduling
public class WebappApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(WebappApplication.class, args);

        FileInputStream file = new FileInputStream(new File("C:\\Users\\aho\\Desktop\\Book1.xlsx"));
        Workbook workbook = new XSSFWorkbook(file);

        Sheet sheet = workbook.getSheetAt(1);

        Map<Integer, List<String>> data = new HashMap<>();
        int i = 0;
        for (Row row : sheet) {
            data.put(i, new ArrayList<>());
            for (Cell cell : row) {
                System.out.println(cell.getStringCellValue());
//                switch () {
//                    case STRING:
//                        System.out.println(cell.getStringCellValue()); break;
////                    case NUMERIC: ... break;
////                    case BOOLEAN: ... break;
////                    case FORMULA: ... break;
//                    default: data.get(new Integer(i)).add(" ");
//                }
            }
            i++;
        }
    }


}
