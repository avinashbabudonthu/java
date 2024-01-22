package com.ab.poc;

import org.xml.sax.InputSource;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GayathriXml {

    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources/poc");
        readFromFile(path.resolve("file2.xml").toFile(), Object.class);
    }

    public static Object readFromFile(File file, Class<? extends Object> klass) {
        Object obj = null;

        try {

            SAXParserFactory spf = SAXParserFactory.newInstance();

            //Option 1: This is the PRIMARY defense against XXE
            spf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            spf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            spf.setXIncludeAware(false);


            //Do unmarshall operation
            Source xmlSource = new SAXSource(spf.newSAXParser().getXMLReader(),
                    new InputSource(new FileInputStream(file)));
            JAXBContext jc = JAXBContext.newInstance(klass);
            Unmarshaller unMarshaller = jc.createUnmarshaller();
            unMarshaller.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());

            obj = unMarshaller.unmarshal(xmlSource);
        } catch (Exception e) {
            // logger.error("JaxbHelper::readXML - Failed to unmarshal file " + file.getName() + "\n" + e);
            e.printStackTrace();
        }
        return obj;
    }
}
