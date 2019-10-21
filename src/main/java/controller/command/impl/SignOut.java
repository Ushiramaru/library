package controller.command.impl;

import controller.command.Command;
import service.ClientService;
import service.factory.ServiceFactory;

public class SignOut implements Command {

    @Override
    public String execute(String request) {
        String response;
        try {
            String login = request.substring(request.indexOf(paramDelimiter) + 1, request.lastIndexOf(paramDelimiter));
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            ClientService clientService = serviceFactory.getClientService();
            clientService.signOut(login);
            response = "Good buy";
        } catch (Exception e) {
            response = "Error during logout procedure. " + e.getMessage();
        }
        return response;
    }

}
