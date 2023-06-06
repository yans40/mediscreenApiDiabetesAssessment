package com.openclassrooms.mediscreenapidiabetesassessment.controller;

import com.openclassrooms.mediscreenapidiabetesassessment.model.Note;
import com.openclassrooms.mediscreenapidiabetesassessment.model.Patient;
import com.openclassrooms.mediscreenapidiabetesassessment.proxies.MicroserviceNotesProxy;
import com.openclassrooms.mediscreenapidiabetesassessment.proxies.MicroservicePatientsProxy;
import com.openclassrooms.mediscreenapidiabetesassessment.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiabetesAssessmentController {
    @Autowired
    private AssessmentService AssessmentService;
    private MicroservicePatientsProxy patientsProxy;

    public void mediscreenUiController(MicroservicePatientsProxy patientsProxy){
        this.patientsProxy = patientsProxy;
    }

    private MicroserviceNotesProxy notesProxy;

    public void mediscreenUiController(MicroserviceNotesProxy notesProxy){
        this.notesProxy = notesProxy;
    }


    @GetMapping("/evaluer-risque/{patientId}")
    public String evaluerRisque(@PathVariable("patientId") Long patientId) {
        // Récupérer les informations du patient à partir de l'API "apiPatient"
        Patient patient = patientsProxy.recupererUnPatient(patientId);

        // Récupérer les notes associées au patient à partir de l'API "apiNotes"
        List<Note> notes = notesProxy.listDesNotes(patientId);

        // Évaluer le risque en utilisant RiskEvaluator
        String risk = AssessmentService.evaluateRisk(patient,notes);

        // Retourner le résultat
        return risk;
    }


}
