package model.ingredient;

import exception.NotFoundException;
import model.Element;

import java.util.Map;

public class Ice extends Ingredient{

    public Ice(int netWeight) {
        super(netWeight, Status.STORAGE, "лед");
    }

    @Override
    public void execute(Map<String, Element> elements) throws NotFoundException {

    }

    @Override
    public String toString() {
        return "лед";
    }
}
