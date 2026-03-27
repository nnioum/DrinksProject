package model.action;

import exception.NotFoundException;
import model.Element;
import model.ingredient.Ingredient;

import java.util.Map;
import java.util.Objects;

public abstract class Action implements Element {
    protected final String name;

    public void execute(Map<String, Ingredient> elements) throws NotFoundException {
    }

    public Action(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return Objects.equals(name, action.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
