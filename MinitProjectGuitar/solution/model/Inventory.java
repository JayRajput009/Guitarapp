package com.aurionpro.MinitProjectGuitar.solution.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Guitar> guitars = new ArrayList<>();

    public void addGuitar(String serialNumber, double price, Builder builder, Model model, Type type, Wood backWood, Wood topWood) {
        GuitarSpec spec = new GuitarSpec(builder, model, type, backWood, topWood);
        Guitar guitar = new Guitar(serialNumber, price, spec);
        guitars.add(guitar);
    }

    public List<Guitar> search(GuitarSpec searchSpec) {
        List<Guitar> matchingGuitars = new ArrayList<>();
        for (Guitar guitar : guitars) {
            if (guitar.getSpec().matches(searchSpec)) {
                matchingGuitars.add(guitar);
            }
        }
        return matchingGuitars;
    }

    public List<Guitar> getAllGuitars() {
        return guitars;
    }
}