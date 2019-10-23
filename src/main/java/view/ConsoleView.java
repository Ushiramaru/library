package view;

import controller.Controller;

import java.util.Scanner;

public class ConsoleView {

    private static final String EXIT_COMMAND = "exit";

    public static void main(String[] args) {

        Controller controller = Controller.getInstance();

        Scanner scanner = new Scanner(System.in);
        boolean isWork = true;
        String command = "";
        while (isWork) {
            if (scanner.hasNextLine()) {
                command = scanner.nextLine();
            }
            System.out.println(controller.executeCommand(command));
            if (command.equals(EXIT_COMMAND)) {
                isWork = false;
                System.out.println("Good buy");
            }
        }
    }

}