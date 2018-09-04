<%@ page language="java"%>

<%@ page import="org.apache.pdfbox.pdmodel.PDDocument" %>
<%@ page import="org.apache.pdfbox.pdmodel.PDPage" %>
<%@ page import= "org.apache.pdfbox.pdmodel.PDPageContentStream" %>
<%@ page import= "org.apache.pdfbox.pdmodel.font.PDType1Font" %>

<%

response.reset();
response.setContentType("application/force-download");
//response.setHeader("Content-disposition","attachment; filename=k.pdf");
response.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
response.setDateHeader("Expires", 0);
response.setHeader("Pragma", "public"); 

	PDDocument doc = new PDDocument();    
	PDPage myPage = new PDPage();
	doc.addPage(myPage);
	try (PDPageContentStream cont = new PDPageContentStream(doc, myPage)) {
	    cont.beginText();
	
	    cont.setFont(PDType1Font.TIMES_ROMAN, 12);
	    cont.setLeading(14.5f);
	
	    cont.newLineAtOffset(25, 700);
	    String line1 = "There is some text here. "
	            + "does this download?";
	    cont.showText(line1);
	    cont.newLine();
	    cont.endText();
	}
	finally
	{
	   if( doc != null )
	   {
  	      doc.save("C:/Users/sd991t/Desktop/k.pdf");
	      doc.close();
	   }
	}

%>    
