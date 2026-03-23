package model.action;

import exception.NotFoundException;
import model.Element;
import model.ingredient.Ingredient;
import model.ingredient.Status;

import java.util.ArrayList;
import java.util.Map;

public class Spill extends Action {
    public Spill() {
        super("пролить");
    }

    @Override
    public void execute(Map<String, Element> elements) throws NotFoundException {
        Ingredient coffeeBeans = (Ingredient) elements.get("кофейные зерна");
        Ingredient water = (Ingredient) elements.get("вода");
        if (coffeeBeans != null && water != null &&
                water.getStatus().equals(Status.BOILED) && coffeeBeans.getStatus().equals(Status.GROUND)) {
            coffeeBeans.setStatus(Status.WASTE);
            water.setStatus(Status.ADD);
        }else{
            throw new NotFoundException("Не хватает нужных ингредиентов для использования этой команды");
        }
    }

    @Override
    public String toString() {
        return "пролить воду через кофе";
    }
}
