package controller.command.impl;

import bean.*;
import bean.enums.*;
import controller.command.Command;
import service.LibraryService;
import service.factory.ServiceFactory;
import service.exeption.ServiceException;

/**
 * The type Add new edition.
 */
public class AddNewEdition implements Command {

    @Override
    public String execute(String request) {
        String response;
        try {
            Edition edition = EditionCreator.valueOf(request);

            ServiceFactory factory = ServiceFactory.getInstance();
            LibraryService service = factory.getLibraryService();

            service.addNewEdition(edition);
            response = "Added completed";
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            response = "Error during added procedure";
        } catch (IllegalArgumentException e) {
            response = "Illegal arguments";
        } catch (ServiceException e) {
            response = "Error during added procedure. " + e.getMessage().substring(e.getMessage().indexOf(paramDelimiter) + 1);
        }

        return response;
    }

}
