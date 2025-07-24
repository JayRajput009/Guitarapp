package com.aurionpro.MinitProjectGuitar.solution.model;

public enum Builder {
    FENDER, MARTIN, GIBSON, COLLINGS, OLSON, PRS, ANY;

    public String toString() {
        switch (this) {
            case FENDER: return "Fender";
            case MARTIN: return "Martin";
            case GIBSON: return "Gibson";
            case COLLINGS: return "Collings";
            case OLSON: return "Olson";
            case PRS: return "PRS";
            case ANY: return "Any";
            default: return "";
        }
    }
}