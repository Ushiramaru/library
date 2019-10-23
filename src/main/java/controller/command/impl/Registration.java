package controller.command.impl;

import bean.User;
import controller.command.Command;
import service.ClientService;
import service.exeption.ServiceException;
import service.factory.ServiceFactory;

public class Registration implements Command {

    @Override
    public String execute(String request) {
        String response;
        try {
            int indexStart = request.indexOf(paramDelimiter) + 1;
            int indexEnd = request.indexOf(paramDelimiter, indexStart);
            String login = request.substring(indexStart, indexEnd);

            indexStart = indexEnd + 1;
            indexEnd = request.indexOf(paramDelimiter, indexStart);
            String password = request.substring(indexStart, indexEnd);

            indexEnd++;
            int age = Integer.valueOf(request.substring(indexEnd));
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            ClientService clientService = serviceFactory.getClientService();
            clientService.signIn(login, password);
            response = "Registration completed";
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            response = "Error during registration procedure";
        } catch (ServiceException e) {
            response = "Error during registration procedure. " + e.getMessage();
        }
        return response;
    }

}
