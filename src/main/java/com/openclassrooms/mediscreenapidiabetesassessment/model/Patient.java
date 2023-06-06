package com.openclassrooms.mediscreenapidiabetesassessment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private Long id;
    private String prenom;
    private String nom;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateDeNaissance;

}
