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
    private final List<ElementNode> roots;
    public static Map<String, Ingredient> INGREDIENT_LIST = new LinkedHashMap<>();
    private static final DrinkRepository INSTANCE = new DrinkRepository();

    private static class ElementNode {
        private final Element element;
        private final List<ElementNode> children;

        public ElementNode(Element element) {
            this.element = element;
            this.children = new ArrayList<>();
        }

        public Element getElement() {
            return element;
        }

        public List<ElementNode> getChildren() {
            return children;
        }

        public void addChild(ElementNode child) {
            children.add(child);
        }
    }

    private DrinkRepository() {
        this.roots = new ArrayList<>();
        this.drink = new Drink();
    }

    public static DrinkRepository getInstance() {
        return INSTANCE;
    }

    public Element create(String name, int weigh) throws NotFoundException {
        Element element;
        switch (name) {
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
        addToTree(element);
        return element;
    }

    private void addToTree(Element element) {
        ElementNode newNode = new ElementNode(element);
        if (element instanceof Ingredient) {
            INGREDIENT_LIST.put(element.getName(), (Ingredient) element);
            roots.add(newNode);
        }
        else if (element instanceof Action) {
            roots.add(newNode);
            addRequiredIngredientsToAction(element, newNode);
        }
    }

    private void addRequiredIngredientsToAction(Element action, ElementNode actionNode) {
        String actionName = action.getName();
        List<String> requiredIngredients = getRequiredIngredients(actionName);

        List<ElementNode> ingredientsToMove = new ArrayList<>();
        for (Ingredient root : INGREDIENT_LIST.values()) {
            String ingredientName = root.getName();
            if (requiredIngredients.contains(ingredientName)) {
                ingredientsToMove.add(new ElementNode(root));
            }
        }

        for (ElementNode ingredient : ingredientsToMove) {
            roots.remove(ingredient);
            actionNode.addChild(ingredient);
        }
    }


    private List<String> getRequiredIngredients(String actionName) {
        return switch (actionName) {
            case "добавить" -> Arrays.asList("лед", "сироп");
            case "вскипятить" -> List.of("вода");
            case "перемолоть" -> List.of("кофейные зерна");
            case "пролить" -> Arrays.asList("кофейные зерна", "вода");
            case "взбить" -> List.of("молоко");
            default -> List.of();
        };
    }


    public String setNameDrink() {
        String drinkName = determineDrinkName();
        drink.setName(drinkName);
        if (INGREDIENT_LIST.get("лед") != null) {
            Ingredient ingredient = INGREDIENT_LIST.get("лед");
            if (ingredient.getStatus().equals(Status.ADD)) {
                drinkName = "ICE " + drinkName;
            }
        }
        return drinkName;
    }

    public String determineDrinkName() {
        Map<String, Status> ingredientSummary = INGREDIENT_LIST.values().stream()
                .collect(Collectors.toMap(
                        Ingredient::getName,
                        Ingredient::getStatus,
                        (existing, replacement) -> replacement
                ));

        return Arrays.stream(TypeDrink.values())
                .filter(recipe -> recipe.isMatch(ingredientSummary))
                .map(TypeDrink::name)
                .findFirst()
                .orElse("SIGNATURE DRINK");
    }

    public void printTree() {
        System.out.println("=== Дерево элементов ===");
        for (ElementNode root : roots) {
            printTreeRecursive(root, 0);
        }
    }

    private void printTreeRecursive(ElementNode node, int level) {
        String indent = "  ".repeat(level);
        String statusInfo = "";

        if (node.getElement() instanceof Ingredient ingredient) {
            statusInfo = " " + ingredient.getNetWeight();
        }

        System.out.println(indent + node.getElement().getName() + statusInfo);

        for (ElementNode child : node.getChildren()) {
            printTreeRecursive(child, level + 1);
        }
    }

    private void prepare(Element element) throws NotFoundException {
        element.execute(INGREDIENT_LIST);
    }
}