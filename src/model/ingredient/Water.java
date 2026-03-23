package model.ingredient;

import exception.NotFoundException;
import model.Element;
import repository.TypeDrink;

import java.util.Map;

public class Water extends Ingredient {
    public Water(int netWeight) {
        super(netWeight, Status.STORAGE, "вода");
    }


    @Override
    public void execute(Map<String, Element> elements) throws NotFoundException {

    }

    @Override
    public String toString() {
        return "вода";
    }
}
