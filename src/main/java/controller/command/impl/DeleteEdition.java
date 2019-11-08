package controller.command.impl;

import controller.command.Command;
import service.LibraryService;
import service.exeption.ServiceException;
import service.factory.ServiceFactory;

public class DeleteEdition implements Command {

    @Override
    public String execute(String request) {
        String response;
        try {
            long id = Long.valueOf(request.substring(request.indexOf(paramDelimiter) + 1));

            ServiceFactory factory = ServiceFactory.getInstance();
            LibraryService service = factory.getLibraryService();

            service.deleteEdition(id);
            response = "Deleted completed";
        } catch (NumberFormatException e) {
            response = "Incorrect id";
        } catch (ServiceException e) {
            response = "Error during deleted procedure. " + e.getMessage().substring(e.getMessage().indexOf(paramDelimiter) + 1);
        }

        return response;
    }

}
