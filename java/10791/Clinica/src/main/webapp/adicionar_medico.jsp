<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.sql.*" %>
<%@page import="ligarbd.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Clínica MD | Adicionar Médico</title>
    <link rel="stylesheet" type="text/css" charset="UTF-8" href="/webapp/css/estilos.css">
</head>

<body>
<%@include file="menu.jsp" %>
<div align="center">
    <h1>Adicionar Médico</h1>

    <%
        if (request.getMethod().equals("POST")) {
            String nome = request.getParameter("nome");
            String especialidade = request.getParameter("codigo_especialidade");
            String email = request.getParameter("email");

            Connection cn = ligacaomysql.criarligacao();
            String sql = "INSERT INTO tab_medicos (nome, codigo_especialidade, email) VALUES ('" + nome + "', '" + especialidade + "', '" + email + "')";
            cn.createStatement().executeUpdate(sql);
            cn.close();
            out.println("Médico adicionado!");
        }
    %>

    <form method="POST">
        <input type="text" name="nome" placeholder="Nome" required><br>
        <input type="text" name="codigo_especialidade" placeholder="Código Especialidade" required><br>
        <input type="email" name="email" placeholder="Email" required><br>
        <input type="submit" value="Adicionar">
    </form>
</div>

<div class="botoes">
    <button type="button" class="btn voltar" onclick="window.location.href='index.jsp'">Voltar</button>
</div>
</body>
</html>