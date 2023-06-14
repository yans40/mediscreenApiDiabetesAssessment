package com.openclassrooms.mediscreenapidiabetesassessment.service;

import com.openclassrooms.mediscreenapidiabetesassessment.constant.MotDeclencheur;
import com.openclassrooms.mediscreenapidiabetesassessment.model.Note;
import com.openclassrooms.mediscreenapidiabetesassessment.model.Patient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class AssessmentService {


    public String evaluateRisk(Patient patient, List<Note> notes) {
        String risk = "None";

        int triggerCount = countTriggers(notes);
        int age = calculateAge(patient.getDateDeNaissance());
        String gender = String.valueOf(patient.getGenre());

        if (triggerCount == 0) {
            risk = "None";
        } else if (triggerCount == 2 && age > 30) {
            risk = "Borderline";
        } else if (age < 30) {
            if (gender.equals("M")) {
                if (triggerCount >= 3) {
                    risk = "In Danger";
                }
            } else if (gender.equals("F")) {
                if (triggerCount >= 4) {
                    risk = "In Danger";
                }
            }
        } else if (age > 30) {
            if (gender.equals("M")) {
                if (triggerCount >= 6) {
                    risk = "In Danger";
                }
            } else if (gender.equals("F")) {
                if (triggerCount >= 8) {
                    risk = "Early onset";
                }
            }
        }

        return risk;
    }







    public int countTriggers(List<Note> medicalNotes) {
        if (medicalNotes == null) {
            return 0; // Retourner 0 si la liste est null
        }

        int count = 0;
        for (Note medicalNote:medicalNotes){
            String observation = medicalNote.getObservation();
            for (MotDeclencheur declencheur : MotDeclencheur.values()) {
                if (observation != null && observation.contains(declencheur.getValue())) {
                    count++;
                }
            }
        }

        return count;
    }

    public int calculateAge(LocalDate patientAge) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(patientAge, currentDate).getYears();
    }
}
