package repository;

import model.ingredient.Status;

import java.util.Map;

public enum TypeDrink {
    RAF(Map.of("кофейные зерна", Status.WASTE, "вода", Status.ADD, "молоко", Status.FOAMED, "сироп", Status.ADD)),
    LATE(Map.of("кофейные зерна", Status.WASTE, "вода", Status.ADD, "молоко", Status.FOAMED)),
    ESPRESSO(Map.of("кофейные зерна", Status.WASTE, "вода", Status.ADD)),
    WATER(Map.of("вода", Status.STORAGE)),
    MILK(Map.of("молоко", Status.STORAGE));

    final Map<String, Status> ingredients;

    TypeDrink(Map<String, Status> ingredients) {

        this.ingredients = ingredients;
    }

    public boolean isMatch(Map<String, Status> current) {
        return ingredients.entrySet().stream()
                .allMatch(entry -> current.containsKey(entry.getKey()) &&
                        current.get(entry.getKey()) == entry.getValue());
    }
}
