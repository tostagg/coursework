<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@page import="java.io.*" %>
<%@page import="ligarbd.*" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Biblioteca | Géneros</title>
    <link rel="stylesheet" href="css/estilos.css">
</head>
<body>
<h1>Listagem de géneros</h1>
<table class="listagem">
    <tr>
        <th>ID Género</th>
        <th>Género</th>
    </tr>
    <%
        Connection cn=ligacaomysql.criarligacao();
        Statement st=cn.createStatement();
        ResultSet rs=st.executeQuery("select * from generos order by id_genero");
        while(rs.next()){
            out.println("<tr><td>"+rs.getString(1)+"</td>");
            out.println("<td>"+rs.getString(2)+"</td>");
        }
    %>
</table>
</body>
</html>
