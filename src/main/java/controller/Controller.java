package controller;

import controller.command.Command;

public final class Controller {

    private static final Controller instance = new Controller();
    private final CommandProvider provider = new CommandProvider();

    private final char paramDelimiter = ' ';

    private Controller() {

    }

    public static Controller getInstance() {
        return instance;
    }

    public String executeCommand(String request) {
        Command executionCommand;

        String commandName = request.substring(0, request.indexOf(paramDelimiter));
        executionCommand = provider.getCommand(commandName);

        return executionCommand.execute(request);
    }

}
