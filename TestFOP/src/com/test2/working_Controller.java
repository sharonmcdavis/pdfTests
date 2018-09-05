package com.test2;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpRecoverableException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.apache.xalan.xsltc.trax.TransformerFactoryImpl;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controller() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {

		System.out.println("I'm in doPost");
			fopPdf(request, response);
			response.setContentType("application/pdf");
			RequestDispatcher rd = request.getRequestDispatcher("/report.jsp");
			rd.forward(request, response);
	}
	
	private FileOutputStream fopPdf(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
/*
		HttpClient client = new HttpClient();
		StringBuffer url = new StringBuffer("http://localhost:8080/TestFOP");
		//url.append("/TestFOP?actionName=aa&commandName=cc&Id=" + Id);
		url.append("?actionName=aa&commandName=cc");
		// Create a method instance.
		GetMethod method = new GetMethod(url.toString());
		// Execute the method.
		try {
			// execute the method.
			int statusCode = client.executeMethod(method);
		} catch (HttpRecoverableException e) {
			System.err.println("A recoverable exception occurred, retrying." + e.getMessage());
		} catch (IOException e) {
			System.err.println("Failed to download file.");
			e.printStackTrace();
			System.exit(-1);
		}
		// Read the response body.
		byte[] responseBody = method.getResponseBody();
		// Release the connection.
		method.releaseConnection();
		
		//save response to output file
        File responseFile = new File("H:\\git\\pdfTests\\TestFOP\\src\\com\\test2\\test.html");
        try {
 
            OutputStream os = new FileOutputStream(responseFile);
            os.write(responseBody);
            System.out.println("Write bytes to file.");
//            printContent(responseFile);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		*/
		File xsltfile = new File("H:\\git\\pdfTests\\TestFOP\\src\\com\\test2\\xhtml-to-xslfo.xsl");
		// the XML file from which we take the name
		StreamSource source = new StreamSource(new File("H:\\git\\pdfTests\\TestFOP\\src\\com\\test2\\test.html"));
		// creation of transform source
		StreamSource transformSource = new StreamSource(xsltfile);
		// create an instance of fop factory
		FopFactory fopFactory;
		try {
			fopFactory = FopFactory.newInstance(new URI("http://google.com"));

		// a user agent is needed for transformation
		FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
		// to store output
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();


		try
		{
			Transformer xslfoTransformer = getTransformer(transformSource);
			// Construct fop with desired output format
		        Fop fop = fopFactory.newFop
					(MimeConstants.MIME_PDF, foUserAgent, outStream);
				// Resulting SAX events (the generated FO) 
				// must be piped through to FOP
		                Result res = new SAXResult(fop.getDefaultHandler());

				// Start XSLT transformation and FOP processing
				try
				{
				        // everything will happen here..
					xslfoTransformer.transform(source, res);
					// if you want to get the PDF bytes, use the following code
					//return outStream.toByteArray();

					// if you want to save PDF file use the following code
					/*File pdffile = new File("Result.pdf");
					OutputStream out = new java.io.FileOutputStream(pdffile);
		                        out = new java.io.BufferedOutputStream(out);
		                        FileOutputStream str = new FileOutputStream(pdffile);
		                        str.write(outStream.toByteArray());
		                        str.close();
		                        out.close();*/

					// to write the content to out put stream
					byte[] pdfBytes = outStream.toByteArray();
		                        response.setContentLength(pdfBytes.length);
		                        response.setContentType("application/pdf");
		                        response.addHeader("Content-Disposition", 
							"attachment;filename=pdffile.pdf");
		                        response.getOutputStream().write(pdfBytes);
		                        response.getOutputStream().flush();
				}
				catch (TransformerException e) {
					try {
						throw e;
					} catch (TransformerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			} catch (FOPException e) {
				try {
					throw e;
				} catch (FOPException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} 
		} catch (URISyntaxException e) {
		
			
		} catch (TransformerFactoryConfigurationError e )
		{
			throw e;
		} 
		return null;
	}
	
	private Transformer getTransformer(StreamSource streamSource)
	{
		// setup the xslt transformer
		TransformerFactoryImpl impl = 
				new TransformerFactoryImpl();

		try {
			return impl.newTransformer(streamSource);

		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}
}