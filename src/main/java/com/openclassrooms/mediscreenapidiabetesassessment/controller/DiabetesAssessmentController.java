package com.openclassrooms.mediscreenapidiabetesassessment.controller;

import com.openclassrooms.mediscreenapidiabetesassessment.model.Note;
import com.openclassrooms.mediscreenapidiabetesassessment.model.Patient;
import com.openclassrooms.mediscreenapidiabetesassessment.proxies.MicroserviceNotesProxy;
import com.openclassrooms.mediscreenapidiabetesassessment.proxies.MicroservicePatientsProxy;
import com.openclassrooms.mediscreenapidiabetesassessment.service.AssessmentService;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apidiabete")
@Slf4j
public class DiabetesAssessmentController {
    @Autowired
    private AssessmentService assessmentService;
    @Autowired
    private MicroservicePatientsProxy patientsProxy;

    @Autowired
    private MicroserviceNotesProxy notesProxy;

    @GetMapping("/helloworld")
    public String test() {
        return "hello world";
    }


    @GetMapping("/evaluerrisque/{patientId}")
    public String evaluerRisque(@PathVariable("patientId") Long patientId) {
        log.info("Début de l'évaluation");
//        try {
            // Récupérer les informations du patient à partir de l'API "apiPatient"
            Patient patient = patientsProxy.recupererUnPatient(patientId);
            // Récupérer les notes associées au patient à partir de l'API "apiNotes"
            List<Note> notes = notesProxy.getNotesByPatientId(patientId);
            // Retourner le résultat
            return assessmentService.evaluateRisk(patient, notes);
//        } catch (FeignException e) {
//            return "Erreur lors de la récupération des informations du patient : " + e.getMessage();
//        }
    }



}
