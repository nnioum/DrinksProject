package model.ingredient;


import exception.NotFoundException;
import model.Element;
import repository.TypeDrink;

import java.util.Map;

public class CoffeeBeans extends Ingredient {
    public CoffeeBeans(int netWeight) {
        super(netWeight, Status.RAW, "кофейные зерна");
    }


    @Override
    public void execute(Map<String, Ingredient> elements) throws NotFoundException {
    }

    @Override
    public String toString() {
        return "кофейные зерна";
    }
}
