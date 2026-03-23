package model;

import exception.NotFoundException;
import repository.TypeDrink;

import java.util.HashMap;
import java.util.Map;

public class Drink{
    protected String name;
    protected TypeDrink type;

    public Drink() {
        this.name = "";
    }

    public TypeDrink getType() {
        return type;
    }

    public void setType(TypeDrink type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
