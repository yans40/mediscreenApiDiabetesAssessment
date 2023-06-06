package com.openclassrooms.mediscreenapidiabetesassessment.service;

import com.openclassrooms.mediscreenapidiabetesassessment.model.Note;
import com.openclassrooms.mediscreenapidiabetesassessment.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentService {
    public static String evaluateRisk(Patient patient, List<Note> notes) {
        String risk = null;

//        // Vérifier si le dossier du patient ne contient aucune note
//        if (notes.isEmpty()) {
//            risk = "Aucun risque";
//        } else {
//            int motsClesDeclencheurs = countMotsClesDeclencheurs(notes);
//            int age = patient.getAge();
//            String genre = patient.getGenre();
//
//            if (age > 30 && motsClesDeclencheurs >= 2) {
//                risk = "Risque limité";
//            } else if (age < 30) {
//                if (genre.equals("masculin") && motsClesDeclencheurs >= 3) {
//                    risk = "Danger";
//                } else if (genre.equals("féminin") && motsClesDeclencheurs >= 4) {
//                    risk = "Danger";
//                }
//            } else if (age > 30) {
//                if (genre.equals("masculin") && motsClesDeclencheurs >= 6) {
//                    risk = "Danger";
//                }
//            }
//
//            if (risk == null) {
//                risk = "Apparition précoce";
//            }
//        }

        return risk;

    }
}
