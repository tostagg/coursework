<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="ligarbd.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Clínica MD | Adicionar Marcação</title>
    <link rel="stylesheet" type="text/css" charset="UTF-8" href="/webapp/css/estilos.css">
</head>
<body>
<%@include file="menu.jsp" %>
<div align="center">
    <h1>Adicionar Marcação</h1>
    <%
        if (request.getMethod().equals("POST")) {
            String data = request.getParameter("data");
            String hora = request.getParameter("hora");
            String codigo_medico = request.getParameter("codigo_medico");
            String codigo_paciente = request.getParameter("codigo_paciente");

            Connection cn = ligacaomysql.criarligacao();
            String sql = "INSERT INTO tab_marcacoes (data, hora, codigo_medico, codigo_paciente) VALUES ('" +
                    data + "', '" + hora + "', '" + codigo_medico + "', '" + codigo_paciente + "')";
            Statement st = cn.createStatement();
            st.executeUpdate(sql);
            cn.close();
            out.println("<p>Marcação adicionada com sucesso!</p>");
        }
    %>

    <form method="POST" action="adicionar_marcacao.jsp">
        <label>Data:</label><br>
        <input type="date" required name="data"><br><br>

        <label>Hora:</label><br>
        <input type="time" required name="hora"><br><br>

        <label>Código do Médico:</label><br>
        <input type="text" required name="codigo_medico"><br><br>

        <label>Código do Paciente:</label><br>
        <input type="text" required name="codigo_paciente"><br><br>

        <input type="submit" value="Guardar" class="btn">
        <input type="reset" value="Cancelar" class="btn">
    </form>
</div>
</body>
</html>