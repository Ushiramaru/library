package view;

import controller.Controller;

import java.util.Scanner;

/**
 * The type Console view.
 */
public class ConsoleView {

    private static final String EXIT_COMMAND = "exit";

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        Controller controller = Controller.getInstance();

        Scanner scanner = new Scanner(System.in);
        boolean isWork = true;
        String command = "";
        while (isWork) {
            if (scanner.hasNextLine()) {
                command = scanner.nextLine();
            }
            if (command.equals(EXIT_COMMAND)) {
                isWork = false;
                System.out.println("Good buy");
            } else {
                System.out.println(controller.executeCommand(command));
            }
        }
    }

}