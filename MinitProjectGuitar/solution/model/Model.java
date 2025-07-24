package com.aurionpro.MinitProjectGuitar.solution.model;

public enum Model {
    STRATOCASTOR, SG, D28, CUSTOM, ANY;

    public String toString() {
        switch (this) {
            case STRATOCASTOR: return "Stratocastor";
            case SG: return "SG";
            case D28: return "D-28";
            case CUSTOM: return "Custom";
            case ANY: return "Any";
            default: return "";
        }
    }
}