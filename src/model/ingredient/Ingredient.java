package model.ingredient;

import java.util.Objects;

public abstract class Ingredient {
    private String name;
    private int netWeight;

    public Ingredient(String name, int netWeight) {
        this.name = name;
        this.netWeight = netWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(int netWeight) {
        this.netWeight = netWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return netWeight == that.netWeight && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, netWeight);
    }

    @Override
    public String toString() {
        return name;
    }
}
