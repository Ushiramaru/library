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
        repository.put(CommandName.ADD_NEW_EDITION, new AddNewEdition());
        repository.put(CommandName.ADD_EDITED_EDITION, new AddEditedEdition());
        repository.put(CommandName.DELETE_EDITION, new DeleteEdition());
        repository.put(CommandName.DELETE, new Delete());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }

}
