<%@ page language="java"%>
    
<html>
<head>

<title>Report 1 </title>


<script src="report.js"></script>
</head>
<body>
<FORM method="post" action="Controller" name="Report" target="_self">
<INPUT type="hidden" name="methodName" value="getReport" />


<br /><br />

<a href="export.jsp">download via PDFBox in JSP</a>
<br /><br />
<br /><br />

<a href="export2.jsp">download via embedding header/footer</a>
<br /><br />


<br /><br />


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