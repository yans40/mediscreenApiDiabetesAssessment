package com.openclassrooms.mediscreenapidiabetesassessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.openclassrooms.mediscreenapidiabetesassessment")
public class MediscreenApiDiabetesAssessmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediscreenApiDiabetesAssessmentApplication.class, args);
    }

}
