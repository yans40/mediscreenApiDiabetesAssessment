package com.openclassrooms.mediscreenapidiabetesassessment.constant;

public enum MotDeclencheur {
    MOT_DECLENCHEUR_1("Hémoglobine A1C"),
    MOT_DECLENCHEUR_2("Microalbumine"),
    MOT_DECLENCHEUR_3("Taille"),
    MOT_DECLENCHEUR_4("Poids"),
    MOT_DECLENCHEUR_5("Fumeur"),
    MOT_DECLENCHEUR_6("Anormal"),
    MOT_DECLENCHEUR_7("Cholestérol"),
    MOT_DECLENCHEUR_8("Vertige"),
    MOT_DECLENCHEUR_9("Rechute"),
    MOT_DECLENCHEUR_10("Réaction"),
    MOT_DECLENCHEUR_11("Anticorps");

    private String value;

    MotDeclencheur(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
