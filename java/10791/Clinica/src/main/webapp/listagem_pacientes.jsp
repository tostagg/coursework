<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="java.sql.*" %>
<%@page import="ligarbd.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Clínica MD | Listagem de Pacientes</title>
    <link rel="icon" href="imagens/fav.png">
    <link rel="stylesheet" href="css/estilos.css?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet" type="text/css" charset="UTF-8" href="/webapp/css/estilos.css">
</head>
<body>
<!-- navbar -->
<%@include file="menu.jsp" %>

<h1>Listagem de Pacientes</h1>
<table class="tabela">
    <tr>
        <th>Nº do Paciente</th>
        <th>Nome</th>
        <th>Observações</th>
        <th>E-mail</th>
    </tr>
    <%
        Connection cn = ligacaomysql.criarligacao();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select * from tab_pacientes");
        while (rs.next()) {
            out.println("<tr>");
            out.println("<td>" + rs.getString(1) + "</td>");
            out.println("<td>" + rs.getString(2) + "</td>");
            out.println("<td>" + rs.getString(3) + "</td>");
            out.println("<td>" + rs.getString(4) + "</td>");
            out.println("</tr>");
        }
    %>
</table>
</body>
</html>