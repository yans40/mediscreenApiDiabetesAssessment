package com.openclassrooms.mediscreenapidiabetesassessment.proxies;

import com.openclassrooms.mediscreenapidiabetesassessment.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "apipatient", url="${API_PATIENT_URL}")
public interface MicroservicePatientsProxy {

    @GetMapping(value = "/apipatient/patients")
    List<Patient> listDesPatients();

    @GetMapping(value = "/apipatient/patients/{id}")
    Patient recupererUnPatient(@PathVariable(name="id") Long id);
}
