package com.openclassrooms.mediscreenapidiabetesassessment.service;

import com.openclassrooms.mediscreenapidiabetesassessment.constant.Genre;
import com.openclassrooms.mediscreenapidiabetesassessment.constant.MotDeclencheur;
import com.openclassrooms.mediscreenapidiabetesassessment.model.Note;
import com.openclassrooms.mediscreenapidiabetesassessment.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssessmentServiceTest {

    private AssessmentService assessmentService;

    @BeforeEach
    public void setup() {
        assessmentService = new AssessmentService();
    }

    @Test
    public void testEvaluateRisk_None() {
        Patient patient = new Patient();
        patient.setDateDeNaissance(LocalDate.now()); // Initialiser la date de naissance avec une valeur non nulle
        List<Note> notes = new ArrayList<>();

        String risk = assessmentService.evaluateRisk(patient, notes);

        assertEquals("None", risk);
    }

    @Test
    public void testEvaluateRisk_Borderline() {
        Patient patient = new Patient();
        patient.setDateDeNaissance(LocalDate.now().minusYears(35));
        List<Note> notes = new ArrayList<>();
        notes.add(createNoteWithTrigger());
        notes.add(createNoteWithTrigger());

        String risk = assessmentService.evaluateRisk(patient, notes);

        assertEquals("Borderline", risk);
    }

    @Test
    public void testEvaluateRisk_InDanger_Male() {
        Patient patient = new Patient();
        patient.setDateDeNaissance(LocalDate.now().minusYears(25));
        patient.setGenre(Genre.M);
        List<Note> notes = new ArrayList<>();
        notes.add(createNoteWithTrigger());
        notes.add(createNoteWithTrigger());
        notes.add(createNoteWithTrigger());

        String risk = assessmentService.evaluateRisk(patient, notes);

        assertEquals("In Danger", risk);
    }

    @Test
    public void testEvaluateRisk_InDanger_Female() {
        Patient patient = new Patient();
        patient.setDateDeNaissance(LocalDate.now().minusYears(25));
        patient.setGenre(Genre.F);
        List<Note> notes = new ArrayList<>();
        notes.add(createNoteWithTrigger());
        notes.add(createNoteWithTrigger());
        notes.add(createNoteWithTrigger());
        notes.add(createNoteWithTrigger());

        String risk = assessmentService.evaluateRisk(patient, notes);

        assertEquals("In Danger", risk);
    }

    @Test
    public void testEvaluateRisk_EarlyOnset_Male() {
        Patient patient = new Patient();
        patient.setDateDeNaissance(LocalDate.now().minusYears(25));
        patient.setGenre(Genre.M);
        List<Note> notes = new ArrayList<>();
        notes.add(createNoteWithTrigger());
        notes.add(createNoteWithTrigger());
        notes.add(createNoteWithTrigger());
        notes.add(createNoteWithTrigger());
        notes.add(createNoteWithTrigger());

        String risk = assessmentService.evaluateRisk(patient, notes);

        assertEquals("Early onset", risk);
    }

    @Test
    public void testEvaluateRisk_EarlyOnset_Female() {
        Patient patient = new Patient();
        patient.setDateDeNaissance(LocalDate.now().minusYears(28));
        patient.setGenre(Genre.F);
        List<Note> notes = new ArrayList<>();
        notes.add(createNoteWithTrigger());
        notes.add(createNoteWithTrigger());
        notes.add(createNoteWithTrigger());
        notes.add(createNoteWithTrigger());
        notes.add(createNoteWithTrigger());
        notes.add(createNoteWithTrigger());
        notes.add(createNoteWithTrigger());
//        notes.add(createNoteWithTrigger());
//        notes.add(createNoteWithTrigger());

        String risk = assessmentService.evaluateRisk(patient, notes);

        assertEquals("Early onset", risk);
    }

    @Test
    public void testCountTriggers_NullList() {
        List<Note> notes = null;

        int count = assessmentService.countTriggers(notes);

        assertEquals(0, count);
    }

    @Test
    public void testCountTriggers_EmptyList() {
        List<Note> notes = new ArrayList<>();

        int count = assessmentService.countTriggers(notes);

        assertEquals(0, count);
    }

    @Test
    public void testCountTriggers() {
        List<Note> notes = new ArrayList<>();
        notes.add(createNoteWithTrigger());
        notes.add(createNoteWithTrigger());
        notes.add(createNoteWithoutTrigger());
        notes.add(createNoteWithTrigger());

        int count = assessmentService.countTriggers(notes);

        assertEquals(3, count);
    }

    @Test
    public void testCalculateAge() {
        LocalDate patientAge = LocalDate.now().minusYears(30);

        int age = assessmentService.calculateAge(patientAge);

        assertEquals(30, age);
    }

    // Méthode utilitaire pour créer une note avec déclencheur
    private Note createNoteWithTrigger() {
        Note note = new Note();
        note.setObservation("Some observation with trigger word " + MotDeclencheur.MOT_DECLENCHEUR_1.getValue());
        return note;
    }

    // Méthode utilitaire pour créer une note sans déclencheur
    private Note createNoteWithoutTrigger() {
        Note note = new Note();
        note.setObservation("Some observation without trigger word");
        return note;
    }
}
