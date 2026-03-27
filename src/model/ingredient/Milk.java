package model.ingredient;

import exception.NotFoundException;
import model.Element;
import repository.TypeDrink;

import java.util.Map;

public class Milk extends Ingredient {

    public Milk(int netWeight) {
        super(netWeight, Status.STORAGE, "молоко");
    }


    @Override
    public String toString() {
        return "молоко";
    }

    @Override
    public void execute(Map<String, Ingredient> elements) throws NotFoundException {

    }
}
