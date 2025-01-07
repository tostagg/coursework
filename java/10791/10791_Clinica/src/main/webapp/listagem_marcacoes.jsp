<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="ligarbd.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Clínica MD | Listagem de Marcações</title>
	<link rel="icon" href="imagens/fav.png">
	<link rel="stylesheet" href="css/estilos.css?v=<%=System.currentTimeMillis()%>">
	<link rel="stylesheet" type="text/css" charset="UTF-8" href="/webapp/css/estilos.css">
</head>
<body>
<!-- navbar -->
<%@include file="menu.jsp" %>

<h1>Listagem de Marcações</h1>
<table class="tabela">
	<tr>
		<th>Nº de Marcações</th>
		<th>Data</th>
		<th>Hora</th>
		<th>Nº do Médico</th>
		<th>Nº do Paciente</th>
	</tr>

	<%
		String sql = "SELECT id_marcacao, data, hora, codigo_medico, codigo_paciente " +
				"FROM tab_marcacoes " +
				"INNER JOIN tab_medicos ON tab_medicos.codigo_medico = tab_marcacoes.codigo_medico " +
				"INNER JOIN tab_pacientes ON tab_pacientes.codigo_paciente = tab_marcacoes.codigo_paciente " +
				"ORDER BY id_marcacao";
		Connection cn=ligacaomysql.criarligacao();
		Statement st=cn.createStatement();
		ResultSet rs=st.executeQuery("select * from tab_marcacoes");
		while(rs.next()){
			out.println("<tr>");
			out.println("<td>"+rs.getString(1)+"</td>");
			out.println("<td>"+rs.getString(2)+"</td>");
			out.println("<td>"+rs.getString(3)+"</td>");
			out.println("<td>"+rs.getString(4)+"</td>");
			out.println("<td>"+rs.getString(5)+"</td>");
			out.println("</tr>");
		}
	%>
</table>
</body>
</html>