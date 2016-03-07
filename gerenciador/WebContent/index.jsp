<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	Bem vindo ao nosso gerenciador de empresas!
	<br />
	<c:if test="${not empty usuarioLogado}">
    	Você está logado como ${usuarioLogado.email}<br/>
	</c:if>
	<form action="executa?tarefa=NovaEmpresa" method="POST">
		Nome: <input type="text" name="nome" /><br />
		<input type="submit" value="Enviar" />
	</form>
	
	<form action="login" method="post">
    	Email: <input type="text" name="email" /><br/>
    	Senha: <input type="password" name="senha" /><br/>
    	<input type="submit" value="Login" />
	</form>
	
	<form action="executa?tarefa=Logout" method="post">
		<input type="submit" value="Logout"/>
	</form>
</body>
</html>