package model.ingredient;

import model.Element;

import java.util.Objects;

public abstract class Ingredient implements Element {
    protected final String name;
    protected final int netWeight;
    protected Status status;

    public Ingredient(int netWeight, Status status, String name) {
        this.netWeight = netWeight;
        this.status = status;
        this.name = name;
    }

    public int getNetWeight() {
        return netWeight;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return netWeight == that.netWeight && Objects.equals(name, that.name) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, netWeight, status);
    }

    @Override
    public String toString() {
        return name;
    }
}