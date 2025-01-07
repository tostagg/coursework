<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.sql.*" %>
<%@page import="ligarbd.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Clínica MD | Adicionar Paciente</title>
    <link rel="stylesheet" type="text/css" charset="UTF-8" href="/webapp/css/estilos.css">
</head>
<body>
<%@include file="menu.jsp" %>
<div align="center">
    <h1>Adicionar Paciente</h1>
    <%
        if (request.getMethod().equals("POST")) {
            String nome = request.getParameter("nome");
            String obs = request.getParameter("observacoes");
            String email = request.getParameter("email");

            Connection cn = ligacaomysql.criarligacao();
            String sql = "INSERT INTO tab_pacientes (nome, observacoes, email) VALUES ('" + nome + "', '" + obs + "', '" + email + "')";
            cn.createStatement().executeUpdate(sql);
            cn.close();
            out.println("Paciente adicionado!");
        }
    %>

    <form method="POST">
        <input type="text" name="nome" placeholder="Nome" required><br><br>
        <textarea name="observacoes" placeholder="Observações"></textarea><br><br>
        <input type="email" name="email" placeholder="Email" required><br><br>
        <input type="submit" value="Adicionar">
    </form>
</div>
</body>
</html>