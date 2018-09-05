package com.test;

import org.apache.fop.apps.*;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;

public class IbmTest {

    public static void main(String[] args) throws Exception {
        FileOutputStream outputStream = new FileOutputStream("H:\\git\\pdfTests\\TestFOP\\src\\com\\test\\test.pdf");
        File templateFile = new File("H:\\git\\pdfTests\\TestFOP\\src\\com\\test\\xhtml-to-xslfo.xsl");
        File sourceFile = new File("H:\\git\\pdfTests\\TestFOP\\src\\com\\test\\test.html");

        final Source xmlSource = new StreamSource(sourceFile);
        final Source sourceTemplate = new StreamSource(templateFile);

        // version 1.0 of getting factory
        // final FopFactory fopFactory = FopFactory.newInstance();

        // version 2.1 of getting factory
        FopFactoryBuilder builder = new FopFactoryBuilder(new URI("http://google.com"));
        builder.setSourceResolution(96);
        FopFactory fopFactory = builder.build();
        
        final FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        Fop fop;
        try {
            fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, outputStream);

            
            final TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(sourceTemplate);

            final Result result = new SAXResult(fop.getDefaultHandler());
            transformer.transform(xmlSource, result);
System.out.println(outputStream.getFD());
            outputStream.flush();

        } catch (final Exception exp) {
            throw new RuntimeException("Error creating PDF", exp);
        }
    }
}