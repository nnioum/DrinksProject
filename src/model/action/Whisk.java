package model.action;

import exception.NotFoundException;
import model.Element;
import model.ingredient.Ingredient;
import model.ingredient.Status;

import java.util.ArrayList;
import java.util.Map;

public class Whisk extends Action{
    public Whisk() {
        super("взбить");
    }

    @Override
    public void execute(Map<String, Ingredient> elements) throws NotFoundException {
        Ingredient milk = elements.get("молоко");
        if(milk!=null && milk.getStatus().equals(Status.STORAGE)){
            milk.setStatus(Status.FOAMED);
        }else {
            throw new NotFoundException("Не хватает нужных ингредиентов для использования этой команды");
        }
    }

    @Override
    public String toString() {
        return "взбить молоко";
    }
}
