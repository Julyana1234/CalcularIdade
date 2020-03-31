<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resultado da idade</title>
</head>
	<body bgcolor="Pink">
		<form>
    		<h2 style="font-family:verdana">SUA IDADE É DE: </h2>
			<input type="text" size = "10" value = "<%= request.getAttribute("idade") %>">
			<input type="text" size = "50" value = "<%= request.getAttribute("resultado") %>">
			<input type = "button" value = "retornar" onclick = "history.back()" >
		</form>
	</body>
</html>