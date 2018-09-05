<%@ page language="java"%>
    
<%@ page import="org.apache.pdfbox.pdmodel.PDDocument" %>
<%@ page import="org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject" %>
<%@ page import="org.apache.pdfbox.pdmodel.common.PDRectangle" %>
<%@ page import="org.apache.pdfbox.pdmodel.PDPage" %>
<%@ page import= "org.apache.pdfbox.pdmodel.PDPageContentStream" %>
<%@ page import= "org.apache.pdfbox.pdmodel.font.PDType1Font" %>
<%@ page import= "java.io.File" %>
<%@ page import= "java.io.InputStream" %>
<%@ page import= "java.io.BufferedInputStream" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Report 1 </title>


<script src="report.js"></script>
</head>
<body>
<FORM method="post" action="ReportController" name="Report" target="_self">
<INPUT type="hidden" name="methodName" value="getReport">

<%
String contextType = (String)request.getAttribute("contextType");
if (contextType == null)
	contextType = "text/html";
response.setContentType(contextType);

PDDocument document = new PDDocument();
PDPage page1 = new PDPage(PDRectangle.A4);
PDRectangle rect = page1.getMediaBox();
document.addPage(page1);

// Start a new content stream which will "hold" the content that's about to be created
PDPageContentStream cos = new PDPageContentStream(document, page1);


// add an image
try {
    PDImageXObject ximage = PDImageXObject.createFromFile("export3.jsp", document);
    float scale = 0.5f; // alter this value to set the image size
    cos.drawImage(ximage, 100, 400, ximage.getWidth()*scale, ximage.getHeight()*scale);
} catch (Exception ioex) {
    System.out.println("No image for you");
}

// close the content stream for page 2
cos.close();

// Save the results and ensure that the document is properly closed:
document.save("C:/Users/sd991t/Desktop/kk.pdf");
document.close();

%>

	Welcome ${requestScope['user'].username}. 

<br><br>

<a href="export.jsp">download via PDFBox in JSP</a>
<br><br>
<br><br>


<a href="export2.jsp">download via embedding header/footer</a>
<br><br>


<br><br>


	<strong>Download Options:</strong>
	<select name="cbDownload" onchange="download('0')">
	<option value="">Make a Selection...</option>
	<option value="un_sum_excel">Export to Excel with NO Formatting</option>
	<option value="sum_excel">Export to Excel with text Formatting</option>
	<option value="sum_word">Export to Word</option>
 	<option value="sum_pdf">Export to PDF</option>
 	<option value="fop_pdf">Export Apache FOP</option>
	</select>
</FORM>
</body>
</html>