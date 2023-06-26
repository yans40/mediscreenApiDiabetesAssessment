package com.openclassrooms.mediscreenapidiabetesassessment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    private String id;
    private Long patientId;
    private String patient;
    private String observation;
}
