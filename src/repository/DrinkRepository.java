package repository;

import exception.NotFoundException;
import model.Drink;
import model.Element;
import model.action.*;
import model.ingredient.*;

import java.util.*;
import java.util.stream.Collectors;

public class DrinkRepository {
    private final Drink drink;
    public static Map<String, Element> ELEMENT_LIST = new LinkedHashMap<>();
    private static final DrinkRepository INSTANCE = new DrinkRepository();

    private DrinkRepository() {
        ELEMENT_LIST = new HashMap<>();
        this.drink = new Drink();
    }

    public static DrinkRepository getInstance(){
        return INSTANCE;
    }

    public Element create(String name, int weigh) throws NotFoundException {
        Element element;
        switch (name){
            case "add" -> element = new Add();
            case "boil" -> element = new Boil();
            case "grind" -> element = new Grind();
            case "spill" -> element = new Spill();
            case "stir" -> element = new Stir();
            case "whisk" -> element = new Whisk();
            case "coffee_beans" -> element = new CoffeeBeans(weigh);
            case "ice" -> element = new Ice(weigh);
            case "milk" -> element = new Milk(weigh);
            case "syrup" -> element = new Syrup(weigh);
            case "water" -> element = new Water(weigh);
            default -> throw new NotFoundException("такой команды не найдено");
        }
        prepare(element);
        ELEMENT_LIST.put(element.getName(), element);
        return element;
    }

    public String setNameDrink(){
        String drinkName = determineDrinkName();
        drink.setName(drinkName);
        if(ELEMENT_LIST.get("лед")!=null){
            Ingredient ingredient = (Ingredient) ELEMENT_LIST.get("лед");
            if(ingredient.getStatus().equals(Status.ADD)){
                drinkName = "ICE " +drinkName;
            }
        }
        return drinkName;
    }

    public String determineDrinkName() {
        Map<String, Status> ingredientSummary = ELEMENT_LIST.values().stream()
                .filter(e -> e instanceof Ingredient)
                .map(e -> (Ingredient) e)
                .collect(Collectors.toMap(
                        Ingredient::getName,
                        Ingredient::getStatus,
                        (existing, replacement) -> replacement
                ));

        return Arrays.stream(TypeDrink.values())
                .filter(recipe -> recipe.isMatch(ingredientSummary))
                .map(TypeDrink::name)
                .findFirst()
                .orElse("австорский напиток");
    }

    public List<String> getAllElements(){
        return ELEMENT_LIST.values().stream()
                .map(Element::getName)
                .toList();
    }


    private void prepare(Element element) throws NotFoundException {
        element.execute(ELEMENT_LIST);
    }
}
