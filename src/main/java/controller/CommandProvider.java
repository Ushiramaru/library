package controller;

import controller.command.Command;
import controller.command.CommandName;
import controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {

    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.SIGN_IN, new SignIn());
        repository.put(CommandName.SIGN_OUT, new SignOut());
        repository.put(CommandName.REGISTRATION, new Registration());
        repository.put(CommandName.ADD_NEW_PRINT_EDITION, new AddNewPrintEdition());
        repository.put(CommandName.EDITED_PRINT_EDITION, new EditedPrintEdition());
        repository.put(CommandName.DELETE_EDITION, new DeleteEdition());
        repository.put(CommandName.SHOW_PRINT_EDITIONS, new ShowPrintEditions());
        repository.put(CommandName.SORT_EDITIONS, new SortEditions());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    Command getCommand(String name) {
        CommandName commandName;
        Command command;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }

}
