package controller;

import static data.GlobalData.IS_RUNNING;

import exception.NotFoundException;
import model.Element;
import service.DrinkService;

import java.util.Arrays;
import java.util.List;

public class DrinkController {
    private final DrinkService drinkService = new DrinkService();

    public void create(String command) throws NotFoundException {
        List<String> commands = List.of(command.split(" "));
        String firstCommand = commands.getFirst();
        if (firstCommand.equals("create")) {
            if (commands.size() == 3) {
                Element element = drinkService.create(commands.get(1), commands.get(2));
                System.out.println("Создан ингредиент " + "\"" + element + "\"");
            } else {
                throw new NotFoundException("Не найдены все аргументы");
            }
        } else if (firstCommand.equals("get")) {
            drinkService.getAllElements();
        } else {
            Element element = drinkService.create(commands.getFirst(), null);
            System.out.println("Выполнено действие " + "\"" + element + "\"");
        }
    }

    public String result() {
        String result = drinkService.result();
        drinkService.getAllElements();
        System.out.println("приготовлен " + result);
        return result;
    }

    public static void stop(String name) {
        IS_RUNNING = false;
        System.out.println("Ваш напиток \"" + name + "\" готов");
    }
}
