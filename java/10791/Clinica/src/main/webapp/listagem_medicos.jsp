<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="ligarbd.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Clínica MD | Listagem de Médicos</title>
	<link rel="icon" href="imagens/fav.png">
	<link rel="stylesheet" href="css/estilos.css?v=<%=System.currentTimeMillis()%>">
	<link rel="stylesheet" type="text/css" charset="UTF-8" href="/webapp/css/estilos.css">
</head>
<body>
<!-- navbar -->
<%@include file="menu.jsp" %>

<h1>Listagem de Médicos</h1>
<table class="tabela">
	<tr>
		<th>Nº do Médico</th>
		<th>Nome</th>
		<th>Nº da Especialidade</th>
		<th>E-mail</th>
	</tr>

	<%
		String sql = "SELECT tab_medicos.codigo_medico, tab_medicos.nome, " +
				"tab_medicos.codigo_especialidade, tab_medicos.email " +
				"FROM tab_medicos " +
				"INNER JOIN tab_especialidades ON tab_medicos.codigo_especialidade = tab_especialidades.codigo_especialidade " +
				"ORDER BY tab_medicos.codigo_medico";
		Connection cn=ligacaomysql.criarligacao();
		Statement st=cn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()){
			out.println("<tr>");
			out.println("<td>"+rs.getString(1)+"</td>");
			out.println("<td>"+rs.getString(2)+"</td>");
			out.println("<td>"+rs.getString(3)+"</td>");
			out.println("<td>"+rs.getString(4)+"</td>");
			out.println("</tr>");
		}
	%>
</table>
</body>
</html>