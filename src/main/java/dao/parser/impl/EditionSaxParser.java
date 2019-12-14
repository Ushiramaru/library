package dao.parser.impl;

import dao.Editions;
import dao.parser.XmlParser;
import dao.parser.exception.ParserException;
import dao.parser.validator.XmlValidator;
import org.apache.log4j.Logger;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

/**
 * The type Edition sax parser.
 */
public class EditionSaxParser implements XmlParser<Editions> {

    private final static Logger LOGGER = Logger.getLogger(EditionSaxParser.class);

    private XmlValidator validator;

    /**
     * Instantiates a new Edition sax parser.
     *
     * @param validator the validator
     */
    public EditionSaxParser(XmlValidator validator) {
        this.validator = validator;
    }

    @Override
    public Editions parse(String pathToXml) throws ParserException {
        if (!validator.isValid(pathToXml)) {
            LOGGER.error("XML doesn't match XSD");
            throw new ParserException("XML doesn't match XSD");
        }

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            LOGGER.error(e.getMessage());
            throw new ParserException(e);
        }

        Editions editions = new Editions();
        try {
            ContentHandler contentHandler = new EditionContentHandler(editions);
            reader.setContentHandler(contentHandler);
            reader.parse(pathToXml);
        } catch (SAXException | IOException e) {
            LOGGER.error(e.getMessage());
            throw new ParserException(e);
        }

        return editions;
    }

}