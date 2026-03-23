import controller.DrinkController;
import exception.NotFoundException;

import java.util.Arrays;
import java.util.Scanner;

import static data.GlobalData.IS_RUNNING;
import static data.GlobalData.WELCOME_MESSAGE;

public class Main {
    public static void main(String[] args) {
        System.out.println(WELCOME_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        while (IS_RUNNING) {
            try {
                String line = scanner.nextLine();
                String[] blocks = line.split(" ");
                if (blocks.length == 0) {
                    System.out.println("Команда не найдена");
                    continue;
                }
                DrinkController drinkController = new DrinkController();
                if(blocks[0].equals("result")){
                    drinkController.result();
                }else {
                    drinkController.create(line);
                }
            } catch (NotFoundException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}
