package dao.parser.impl;

import dao.Editions;
import dao.parser.XmlParser;
import dao.parser.exception.ParserException;
import dao.parser.validator.XmlValidator;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * The type Edition jaxb parser.
 */
public class EditionJaxbParser implements XmlParser<Editions> {

    private final static Logger LOGGER = Logger.getLogger(EditionJaxbParser.class);

    private XmlValidator validator;

    /**
     * Instantiates a new Edition jaxb parser.
     *
     * @param validator the validator
     */
    public EditionJaxbParser(XmlValidator validator) {
        this.validator = validator;
    }

    @Override
    public Editions parse(String pathToXml) throws ParserException {
        if (!validator.isValid(pathToXml)) {
            LOGGER.error("XML doesn't match XSD");
            throw new ParserException("XML doesn't match XSD");
        }

        Unmarshaller unmarshaller;
        try {
            JAXBContext context = JAXBContext.newInstance(Editions.class);
            unmarshaller = context.createUnmarshaller();
        } catch (JAXBException e) {
            LOGGER.error(e.getMessage());
            throw new ParserException(e);
        }

        Editions candies;
        try {
            File xmlFile = new File(pathToXml);
            candies = (Editions) unmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            LOGGER.error(e.getMessage());
            throw new ParserException(e);
        }

        return candies;
    }

}