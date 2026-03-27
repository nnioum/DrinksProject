package model;

import exception.NotFoundException;
import model.ingredient.Ingredient;

import java.util.Map;

public interface Element {
    String getName();
    void execute(Map<String, Ingredient> elements) throws NotFoundException;
}
