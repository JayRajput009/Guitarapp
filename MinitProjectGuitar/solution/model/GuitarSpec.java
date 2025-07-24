package com.aurionpro.MinitProjectGuitar.solution.model;

public class GuitarSpec {
    private Builder builder;
    private Model model;
    private Type type;
    private Wood backWood;
    private Wood topWood;

    public GuitarSpec(Builder builder, Model model, Type type, Wood backWood, Wood topWood) {
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public Builder getBuilder() { return builder; }
    public Model getModel() { return model; }
    public Type getType() { return type; }
    public Wood getBackWood() { return backWood; }
    public Wood getTopWood() { return topWood; }

    public boolean matches(GuitarSpec otherSpec) {
        if (builder != Builder.ANY && otherSpec.builder != Builder.ANY && builder != otherSpec.builder)
            return false;
        if (model != Model.ANY && otherSpec.model != Model.ANY &&
            !model.toString().equalsIgnoreCase(otherSpec.model.toString()))
            return false;
        if (type != null && otherSpec.type != null && type != otherSpec.type)
            return false;
        if (backWood != null && otherSpec.backWood != null && backWood != otherSpec.backWood)
            return false;
        if (topWood != null && otherSpec.topWood != null && topWood != otherSpec.topWood)
            return false;
        return true;
    }
}