<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.sql.*" %>
<%@page import="ligarbd.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Clínica MD | Apagar Paciente</title>
    <link rel="stylesheet" type="text/css" charset="UTF-8" href="/webapp/css/estilos.css">
</head>
<body>
<%@include file="menu.jsp" %>

<div align="center">
    <h1>Apagar Paciente</h1>
    <%
        if (request.getMethod().equals("post")) {
            try {
                String codigo = request.getParameter("codigo_paciente");
                Connection cn = null;
                Statement st = null;

                try {
                    cn = ligacaomysql.criarligacao();
                    st = cn.createStatement();
                    String sql = "DELETE FROM tab_pacientes WHERE codigo_paciente = '" + codigo + "'";
                    st.executeUpdate(sql);
                    out.println("<p>Paciente removido com sucesso!</p>");
                } finally {
                    if (st != null) st.close();
                    if (cn != null) cn.close();
                }
            } catch(Exception e) {
                out.println("<p>Erro ao remover paciente: " + e.getMessage() + "</p>");
            }
        }
    %>
    <form method="POST">
        <input type="text" name="codigo_paciente" placeholder="Código do Paciente" required><br><br>
        <input type="submit" value="Apagar">
    </form>
</div>
</body>
</html>