package com.nhnacademy.edu.springframework.project;

import com.nhnacademy.edu.springframework.project.config.JavaConfig;
import com.nhnacademy.edu.springframework.project.report.ResultReport;
import com.nhnacademy.edu.springframework.project.service.WaterUsageBillService;
import com.nhnacademy.edu.springframework.project.storage.BillStorage;
import com.nhnacademy.edu.springframework.project.storage.WaterBill;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

public class BootStrap {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path = "src/main/resources/data/Tariff_20220331.json";

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        BillStorage billStorage = context.getBean(BillStorage.class);
        WaterUsageBillService waterUsageBillService = context.getBean(WaterUsageBillService.class);
        ResultReport resultReport = context.getBean(ResultReport.class);

        String extension = path.replace(".", " ").split(" ")[1];

        if (extension.equals("csv")) {
            billStorage.csvFileLoad(path);
        } else {
            billStorage.jsonFileLoad(path);
        }

        int usage;
        Collection<WaterBill> result;
        while(true) {
            System.out.print("> ");
            usage = scanner.nextInt();

            if(usage == -1) break;

            result = waterUsageBillService.calculateBill(usage);
            resultReport.report(result);
        }

    }
}
