package model.action;

import model.Element;
import model.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.Map;

public class Stir extends Action{
    public Stir() {
        super("перемешать");
    }

    @Override
    public void execute(Map<String, Ingredient> elements) {

    }

    @Override
    public String toString() {
        return "перемешать";
    }
}
