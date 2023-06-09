package com.openclassrooms.mediscreenapidiabetesassessment.proxies;

import com.openclassrooms.mediscreenapidiabetesassessment.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Mediscreen", url="localhost:8081/apipatient", decode404 = true )
public interface MicroservicePatientsProxy {
    @GetMapping(value = "/patients")
    List<Patient> listDesPatients();

    @GetMapping("/patients/{id}")
    Patient recupererUnPatient(@PathVariable(name="id") Long id);
}
