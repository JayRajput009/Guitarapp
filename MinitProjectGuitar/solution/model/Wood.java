package com.aurionpro.MinitProjectGuitar.solution.model;

public enum Wood {
    ALDER, MAHOGANY, MAPLE, CEDAR, COCOBOLO, ADIDONDACK, INDIAN_ROSEWOOD, SITKA;

    public String toString() {
        switch (this) {
            case ALDER: return "Alder";
            case MAHOGANY: return "Mahogany";
            case MAPLE: return "Maple";
            case CEDAR: return "Cedar";
            case COCOBOLO: return "Cocobolo";
            case ADIDONDACK: return "Adidondack";
            case INDIAN_ROSEWOOD: return "Indian Rosewood";
            case SITKA: return "Sitka";
            default: return "";
        }
    }
}