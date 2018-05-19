<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>model page</title>
</head>
<body>
	this is model page
	<br>
	<p> person name = ${user.name}</p>
	<br>
	<a href="model.json">json</a>
	<br>
	<a href="model.pdf">pdf</a>
	<br>
	<a href="model.xlsx">excell</a>
	<br>
	<a href="model.xml">XML</a>
	<br>
	<a href="model.rss">RSS</a>
	
</body>
</html>