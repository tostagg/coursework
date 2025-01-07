<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@page import="java.io.*" %>
<%@page import="ligarbd.*" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Biblioteca | Editoras</title>
    <link rel="stylesheet" href="css/estilos.css">
</head>
<body>
<h1>Listagem de editoras</h1>
<table class="listagem">
    <tr>
        <th>ID Editora</th>
        <th>Editora</th>
    </tr>
    <%
        Connection cn=ligacaomysql.criarligacao();
        Statement st=cn.createStatement();
        ResultSet rs=st.executeQuery("select * from editoras order by id_editora");
        while(rs.next()){
            out.println("<tr><td>"+rs.getString(1)+"</td>");
            out.println("<td>"+rs.getString(2)+"</td>");
        }
    %>
</table>
</body>
</html>
