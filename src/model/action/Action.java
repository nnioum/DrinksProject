package model.action;

import java.util.List;
import java.util.Objects;

public abstract class Action {
    private String name;
    private List<String> permittedIngredients;

    public void perform(){}

    public Action(String name, List<String> permittedIngredients) {
        this.name = name;
        this.permittedIngredients = permittedIngredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPermittedIngredients() {
        return permittedIngredients;
    }

    public void setPermittedIngredients(List<String> permittedIngredients) {
        this.permittedIngredients = permittedIngredients;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return Objects.equals(name, action.name) && Objects.equals(permittedIngredients, action.permittedIngredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, permittedIngredients);
    }
}
