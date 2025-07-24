package com.aurionpro.MinitProjectGuitar.solution.model;

public enum Type {
    ACOUSTIC, ELECTRIC;

    public String toString() {
        switch (this) {
            case ACOUSTIC: return "Acoustic";
            case ELECTRIC: return "Electric";
            default: return "";
        }
    }
}