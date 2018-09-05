package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.FopFactoryBuilder;
import org.apache.fop.apps.MimeConstants;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class ReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReportController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {

		System.out.println("I'm in doPost");
		PDDocument newFile = createFile();
		String methodName = request.getParameter("methodName");
		if (methodName == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/report.jsp");
			rd.forward(request, response);
		} else if (methodName.equalsIgnoreCase("getReport")) {
			getReport(request, response);
		} else if (methodName.equalsIgnoreCase("fopPDF")) {
			FileOutputStream file = fopPdf(request, response);
			request.setAttribute("outputFile", file);
			RequestDispatcher rd = request.getRequestDispatcher(file);
			rd.forward(request, response);
		} else {
			//writePdf(request, response);
			//downloadPdf (request, response);
			//testCreate();
			//PDDocument newFile = createFile();
			response.setContentType("application/pdf");
			//response.addHeader("Content-Disposition", "attachment; filename=" + "test.pdf");
			RequestDispatcher rd = request.getRequestDispatcher("/report.jsp");
			rd.forward(request, response);
		} 
	}
	
	private void getReport(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {

		System.out.println("I'm in getReport");
			RequestDispatcher rd = request.getRequestDispatcher("/report2.jsp");
			rd.forward(request, response);
	}

	private FileOutputStream fopPdf(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		System.out.println("I'm in fopPdf");
        FileOutputStream outputStream = new FileOutputStream("H:\\git\\pdfTests\\TestWeb\\WebContent\\pdf\\test.pdf");
        File templateFile = new File("H:\\git\\pdfTests\\TestWeb\\WebContent\\pdf\\xhtml-to-xslfo.xsl");
        File sourceFile = new File("H:\\git\\pdfTests\\TestWeb\\WebContent\\pdf\\test.html");

        final Source xmlSource = new StreamSource(sourceFile);
        final Source sourceTemplate = new StreamSource(templateFile);

		try {
			// version 2.1 of getting factory
	        FopFactoryBuilder builder = new FopFactoryBuilder(new URI("http://google.com"));
	        builder.setSourceResolution(96);
	        FopFactory fopFactory = builder.build();
		
	        final FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
	        Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, outputStream);

            final TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(sourceTemplate);

            final Result result = new SAXResult(fop.getDefaultHandler());
            transformer.transform(xmlSource, result);
            outputStream.flush();
            outputStream.close();
            return outputStream;
            
        } catch (final Exception exp) {
            throw new RuntimeException("Error creating PDF", exp);
        }
	}
	
	private void downloadPdf(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {

		System.out.println("I'm in downloadPdf");
			RequestDispatcher rd = request.getRequestDispatcher("/export.jsp");
			request.setAttribute("contextType", "application/pdf");
			rd.forward(request, response);
	}

	private void writePdf(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {

		System.out.println("I'm in writePdf");
		
		String pdfFileName = "pdfTemplate.pdf";
		String contextPath = "c://";
		//String pdfFileName = "pdf-test.pdf";
		//String contextPath = getServletContext().getRealPath(File.separator);
		//String contextPath = getServletContext().getRealPath(File.separator);
		File pdfFile = new File(contextPath + pdfFileName);
		//File pdfFile = new File(pdfFileName);

		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename=" + pdfFileName);
		response.setContentLength((int) pdfFile.length());

		FileInputStream fileInputStream = new FileInputStream(pdfFile);
		OutputStream responseOutputStream = response.getOutputStream();
		int bytes;
		while ((bytes = fileInputStream.read()) != -1) {
			responseOutputStream.write(bytes);
		}
	}
	
	public static PDDocument createFile() throws IOException {

    try (PDDocument doc = new PDDocument()) {

        PDPage myPage = new PDPage();
        doc.addPage(myPage);

        try (PDPageContentStream cont = new PDPageContentStream(doc, myPage)) {

            cont.beginText();

            cont.setFont(PDType1Font.TIMES_ROMAN, 12);
            cont.setLeading(14.5f);

            cont.newLineAtOffset(25, 700);
            String line1 = "World War II (often abbreviated to WWII or WW2), "
                    + "also known as the Second World War,";
            cont.showText(line1);

            cont.newLine();

            String line2 = "was a global war that lasted from 1939 to 1945, "
                    + "although related conflicts began earlier.";
            cont.showText(line2);
            cont.newLine();

            String line3 = "It involved the vast majority of the world's "
                    + "countries—including all of the great powers—";
            cont.showText(line3);
            cont.newLine();

            String line4 = "eventually forming two opposing military "
                    + "alliances: the Allies and the Axis.";
            cont.showText(line4);
            cont.newLine();

            cont.endText();
        }
    	finally
    	{
           doc.save("C:\\Users\\sd991t\\Downloads\\myTest.pdf");
    	   if( doc != null )
    	   {
    	      doc.close();
    	   }
    	}

        return(doc);
    	}
    }
	   
	public void testCreate () throws IOException {
       
	      //Creating PDF doument object 
	      PDDocument document = new PDDocument();    
	       
	      //Saving the document
	      document.save("./my_doc.pdf");
	         
	      System.out.println("PDF created");  
	    
	      //Closing the document  
	      document.close();
	}  


}