package model.ingredient;

import exception.NotFoundException;
import model.Element;
import repository.TypeDrink;

import java.util.Map;

public class Syrup extends Ingredient{

    public Syrup(int netWeight) {
        super(netWeight, Status.STORAGE, "сироп");
    }

    @Override
    public void execute(Map<String, Element> elements) throws NotFoundException {

    }

    @Override
    public String toString() {
        return "сироп";
    }
}
