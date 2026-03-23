package model.action;

import exception.NotFoundException;
import model.Element;
import model.ingredient.Ingredient;
import model.ingredient.Status;

import java.util.ArrayList;
import java.util.Map;

public class Grind extends Action{
    public Grind() {
        super("перемолоть");
    }

    @Override
    public void execute(Map<String, Element> elements) throws NotFoundException {
        Ingredient coffeeBeans = (Ingredient) elements.get("кофейные зерна");
        if(coffeeBeans!=null && coffeeBeans.getStatus().equals(Status.RAW)){
            coffeeBeans.setStatus(Status.GROUND);
        }else {
            throw new NotFoundException("Не найден Ингредиент, который можно использовать");
        }
    }

    @Override
    public String toString() {
        return "перемолоть кофе";
    }
}
