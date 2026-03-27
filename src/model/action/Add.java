package model.action;

import exception.NotFoundException;
import model.Element;
import model.ingredient.Ingredient;
import model.ingredient.Status;

import java.util.Map;

public class Add extends Action {
    public Add() {
        super("добавить");
    }


    @Override
    public void execute(Map<String, Ingredient> elements) throws NotFoundException {
        Ingredient ice = elements.get("лед");
        Ingredient syrup = elements.get("сироп");
        if ((ice != null && ice.getStatus().equals(Status.STORAGE))
                || (syrup != null && syrup.getStatus().equals(Status.STORAGE))) {

            if (ice != null && ice.getStatus().equals(Status.STORAGE)) {
                ice.setStatus(Status.ADD);
            }
            if (syrup != null && syrup.getStatus().equals(Status.STORAGE)) {
                syrup.setStatus(Status.ADD);
            }
        } else {
            throw new NotFoundException("Не найден Ингредиент, который можно использовать");
        }
    }

    @Override
    public String toString() {
        return "добавить";
    }
}
