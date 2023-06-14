package com.openclassrooms.mediscreenapidiabetesassessment.proxies;

import com.openclassrooms.mediscreenapidiabetesassessment.model.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-notes", url="localhost:8082/apiNote" )
public interface MicroserviceNotesProxy {

    @GetMapping("/notesList/{patientId}")
    List <Note> getNotesByPatientId(@PathVariable Long patientId);
}
