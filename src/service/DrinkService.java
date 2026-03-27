package service;

import exception.NotFoundException;
import model.Element;
import model.ingredient.Ingredient;
import repository.DrinkRepository;

import java.util.List;

public class DrinkService {
    private final DrinkRepository drinkRepository = DrinkRepository.getInstance();

    public Element create(String name, String weighString) throws NotFoundException {
        if(weighString==null){
            return drinkRepository.create(name, 0);
        }else {
            try {
                int weigh = Integer.parseInt(weighString);
                return drinkRepository.create(name, weigh);
            } catch (NumberFormatException e) {
                throw new NotFoundException("Цена должна быть введена верно");
            }
        }
    }

    public String result(){
        return drinkRepository.setNameDrink();
    }

    public void getAllElements(){
        drinkRepository.printTree();
    }
}
