<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="ligarbd.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Clínica MD | Apagar Marcação</title>
    <link rel="stylesheet" type="text/css" charset="UTF-8" href="/webapp/css/estilos.css">
</head>
<body>
<%@include file="menu.jsp" %>

<div align="center">
    <h1>Apagar Marcação</h1>

    <%
        if (request.getMethod().equals("POST")) {
            String id = request.getParameter("id_marcacao");

            Connection cn = ligacaomysql.criarligacao();
            String sql = "DELETE FROM tab_marcacoes WHERE id_marcacao = '" + id + "'";
            Statement st = cn.createStatement();
            st.executeUpdate(sql);
            cn.close();
            out.println("<p>Marcação removida com sucesso!</p>");
        }
    %>

    <form method="POST" action="apagar_marcacao.jsp">
        <label>ID da Marcação:</label><br>
        <input type="text" required name="id_marcacao"><br><br>

        <input type="submit" value="Apagar" class="btn">
        <input type="reset" value="Cancelar" class="btn">
    </form>
</div>
</body>
</html>