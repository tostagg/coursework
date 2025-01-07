<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="ligarbd.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clínica MD | Listagem de Especialidades</title>
	<link rel="stylesheet" href="css/estilos.css?v=<%=System.currentTimeMillis()%>">
	<link rel="stylesheet" type="text/css" charset="UTF-8" href="/webapp/css/estilos.css">
</head>
<body>
<!-- navbar -->
<%@include file="menu.jsp" %>

	<h1>Listagem de Especialidades</h1>
	<table class="tabela">
		<tr>
			<th>Nº Especialidade:</th>
			<th>Especialidade:</th>
			<th>Preço da Consulta:</th>
			
		</tr>
		<%
			String sql = "SELECT codigo_especialidade, especialidade, preco_consulta " +
					"FROM tab_especialidades " +
					"INNER JOIN tab_medicos ON tab_medicos.codigo_especialidade = tab_especialidades.codigo_especialidade " +
					"ORDER BY codigo_especialidade";
			Connection cn=ligacaomysql.criarligacao();
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select * from tab_especialidades");
			while(rs.next()){
				out.println("<tr><td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td></tr>");
			}
		%>
	</table>
</body>
</html>