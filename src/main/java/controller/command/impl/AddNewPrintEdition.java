package controller.command.impl;

import bean.*;
import bean.enums.*;
import controller.command.Command;
import service.LibraryService;
import service.factory.ServiceFactory;
import service.exeption.ServiceException;

public class AddNewPrintEdition implements Command {

    @Override
    public String execute(String request) {
        String response;
        try {
            int indexStart = request.indexOf(paramDelimiter) + 1;
            int indexEnd = request.indexOf(paramDelimiter, indexStart);
            EditionType type = EditionType.valueOf(request.substring(indexStart, indexEnd));


            indexStart = indexEnd + 1;
            indexEnd = request.indexOf(paramDelimiter, indexStart);
            long id = Long.valueOf(request.substring(indexStart, indexEnd));

            indexStart = indexEnd + 1;
            indexEnd = request.indexOf(paramDelimiter, indexStart);
            String title = request.substring(indexStart, indexEnd);

            indexStart = indexEnd + 1;
            indexEnd = request.indexOf(paramDelimiter, indexStart);
            ListFormat listFormat = ListFormat.valueOf(request.substring(indexStart, indexEnd).toUpperCase());

            indexStart = indexEnd + 1;
            indexEnd = request.indexOf(paramDelimiter, indexStart);
            int listCount = Integer.valueOf(request.substring(indexStart, indexEnd));

            indexStart = indexEnd + 1;
            indexEnd = request.indexOf(paramDelimiter, indexStart);
            int publicationYear = Integer.valueOf(request.substring(indexStart, indexEnd));

            PrintEdition edition;
            switch (type) {
                case BOOK:
                    Genre genre = Genre.valueOf(request.substring(indexEnd + 1).toUpperCase());
                    edition = new Book(id, title, listFormat, listCount, publicationYear, genre);
                    break;
                case NEWSPAPER:
                    NewspaperType newspaperType = NewspaperType.valueOf(request.substring(indexEnd + 1).toUpperCase());
                    edition = new Newspaper(id, title, listFormat, listCount, publicationYear, newspaperType);
                    break;
                case ENCYCLOPEDIA:
                    EncyclopediaType encyclopediaType = EncyclopediaType.valueOf(request.substring(indexEnd + 1).toUpperCase());
                    edition = new Encyclopedia(id, title, listFormat, listCount, publicationYear, encyclopediaType);
                    break;
                default:
                    edition = null;
            }

            ServiceFactory factory = ServiceFactory.getInstance();
            LibraryService service = factory.getLibraryService();

            service.addNewEdition(edition);
            response = "Added completed";
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            response = "Error during added procedure";
        } catch (ServiceException e) {
            response = "Error during added procedure" + e.getMessage();
        }

        return response;
    }

}
