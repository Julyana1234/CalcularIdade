<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body bgcolor="Pink">
	<form action= "index.html" method = "post" >
	Usuário: <br/> <input type = "text" name = "usuario" /> <br/>
	Senha: <br/> <input type = "password" name = "senha" /> <br/>
	<input type = "submit" value = "Logar" />
	</form>
	
	<% 
		String usuario = request.getParameter ("usuario");
		String senha = request.getParameter ("senha");
		
		if ((usuario !=null) && (senha != null) && !usuario.isEmpty() && !senha.isEmpty()){
			response.sendRedirect("index.html");
		}else if ((usuario == null) || (senha == null) || (usuario.isEmpty()) || (senha.isEmpty())){
			response.sendRedirect("Inexistente.jsp");
		}
	%>
</body>
</html>