<%@ page language="java"%>
<%
response.setContentType("application/pdf");
response.setHeader("Content-disposition","attachment; filename=k2.pdf");
response.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
response.setDateHeader("Expires", 0);
response.setHeader("Pragma", "public"); 
%>    

<jsp:include page="pdf_header.jsp"/>

There is some text here.

<jsp:include page="pdf_footer.jsp"/>
