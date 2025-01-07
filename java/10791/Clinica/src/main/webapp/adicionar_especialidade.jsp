<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.sql.*" %>
<%@page import="ligarbd.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Clínica MD | Adicionar Especialidade</title>
    <link rel="stylesheet" type="text/css" charset="UTF-8" href="/webapp/css/estilos.css">
</head>

<body>
<%@include file="menu.jsp" %>
<div align="center">
    <h1>Adicionar Especialidade</h1>
    <%
        if (request.getMethod().equals("POST")) {
            String especialidade = request.getParameter("especialidade");
            String preco = request.getParameter("preco_consulta");

            Connection cn = ligacaomysql.criarligacao();
            String sql = "INSERT INTO tab_especialidades (especialidade, preco_consulta) VALUES ('" + especialidade + "', '" + preco + "')";
            cn.createStatement().executeUpdate(sql);
            cn.close();
            out.println("Especialidade adicionada!");
        }
    %>

    <form method="POST">
        <input type="text" name="especialidade" placeholder="Especialidade" required><br><br>
        <input type="number" name="preco_consulta" placeholder="Preço da Consulta" required><br><br>
        <input type="submit" value="Adicionar">
    </form>
</div>
</body>
</html>
