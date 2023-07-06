package com.openclassrooms.mediscreenapidiabetesassessment.constant;

public enum MotDeclencheur {
    MOT_DECLENCHEUR_1("hémoglobine A1C"),
    MOT_DECLENCHEUR_2("microalbumine"),
    MOT_DECLENCHEUR_3("taille"),
    MOT_DECLENCHEUR_4("poids"),
    MOT_DECLENCHEUR_5("fumeur"),
    MOT_DECLENCHEUR_6("anormale"),
    MOT_DECLENCHEUR_7("cholestérol"),
    MOT_DECLENCHEUR_8("vertige"),
    MOT_DECLENCHEUR_9("rechute"),
    MOT_DECLENCHEUR_10("réaction"),
    MOT_DECLENCHEUR_11("anticorps");

    private String value;

    MotDeclencheur(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
