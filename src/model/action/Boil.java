package model.action;

import exception.NotFoundException;
import model.Element;
import model.ingredient.Ingredient;
import model.ingredient.Status;

import java.util.ArrayList;
import java.util.Map;

public class Boil extends Action{
    public Boil() {
        super("вскипятить");
    }

    @Override
    public void execute(Map<String, Element> elements) throws NotFoundException {
        Ingredient water = (Ingredient) elements.get("вода");
        if (water != null && water.getStatus().equals(Status.STORAGE)) {
            water.setStatus(Status.BOILED);
        }else {
            throw new NotFoundException("Не найден Ингредиент, который можно использовать");
        }
    }

    @Override
    public String toString() {
        return "вскипятить воду";
    }
}
