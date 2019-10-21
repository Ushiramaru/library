package controller.command;

public interface Command {

    char paramDelimiter = ' ';

    String execute(String request);

}
