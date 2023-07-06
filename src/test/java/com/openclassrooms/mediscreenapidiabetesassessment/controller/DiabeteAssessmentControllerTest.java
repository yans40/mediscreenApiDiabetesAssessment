package com.openclassrooms.mediscreenapidiabetesassessment.controller;


import com.openclassrooms.mediscreenapidiabetesassessment.model.Note;
import com.openclassrooms.mediscreenapidiabetesassessment.model.Patient;
import com.openclassrooms.mediscreenapidiabetesassessment.proxies.MicroserviceNotesProxy;
import com.openclassrooms.mediscreenapidiabetesassessment.proxies.MicroservicePatientsProxy;
import com.openclassrooms.mediscreenapidiabetesassessment.service.AssessmentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DiabeteAssessmentControllerTest {

    @Mock
        private MicroservicePatientsProxy patientsProxy;

    @Mock
    private MicroserviceNotesProxy notesProxy;

    @Mock
    private AssessmentService assessmentService;

    @InjectMocks
        private DiabetesAssessmentController diabeteAssessmentController;

    @Test
    public void testEvaluerRisque() {
        // ID du patient pour le test
        Long patientId = 123L;

        // Patient de test
        Patient patient = new Patient();
        patient.setPatientId(patientId);
        // Autres attributs du patient

        // Liste de notes de test
        List<Note> notes = new ArrayList<>();
        // Ajouter des notes de test à la liste

        // Résultat d'évaluation de risque de test
        String resultatEvaluation = "Risque élevé de diabète";

        // Configurer les mocks pour les appels aux API
        Mockito.when(patientsProxy.recupererUnPatient(patientId)).thenReturn(patient);
        Mockito.when(notesProxy.getNotesByPatientId(patientId)).thenReturn(notes);
        Mockito.when(assessmentService.evaluateRisk(patient, notes)).thenReturn(resultatEvaluation);

        // Appeler la méthode à tester
        String resultat = diabeteAssessmentController.evaluerRisque(patientId);

        // Vérifier que les appels aux API et au service d'évaluation sont effectués avec les bons paramètres
        Mockito.verify(patientsProxy).recupererUnPatient(patientId);
        Mockito.verify(notesProxy).getNotesByPatientId(patientId);
        Mockito.verify(assessmentService).evaluateRisk(patient, notes);

        // Vérifier que le résultat retourné correspond au résultat d'évaluation attendu
        Assert.assertEquals(resultatEvaluation, resultat);
    }
}


