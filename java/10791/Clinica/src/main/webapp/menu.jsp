<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="java.util.*,java.text.*" %>
<%@page import="java.sql.*" %>
<%@page import="ligarbd.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Clínica MD | Menu</title>
    <link rel="icon" href="imagens/fav.png">
    <style>
        .botaomenu{
            background-color: grey;
            color: white;
            padding: 15px;
            font-size: 15px;
            border: none;
            cursor: pointer;
        }

        .escolha{
            position: relative;
            font-size: 15px;
            display: inline-block;
        }

        .escolha-conteudo{
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 170px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
        }

        .escolha-conteudo a{
            color: black;
            padding: 12px;
            text-decoration: none;
            display: block;
        }

        .escolha-conteudo a:hover{
            background-color: #f1f1f1;
        }

        .escolha:hover .escolha-conteudo{
            display:block;
        }

        .escolha:hover .botaomenu{
            background-color: grey;
        }
    </style>
</head>
<body>

<div style="width:100%;background-color:grey">
    <div class="escolha">
        <button class="botaomenu">Especialidades</button>
        <div class="escolha-conteudo">
            <a href="adicionar_especialidade.jsp">Nova especialidade</a>
            <a href="apagar_especialidade.jsp">Apagar especialidade</a>
            <a href="listagem_especialidades.jsp">Listar especialidades</a>
        </div>
    </div>

    <div class="escolha">
        <button class="botaomenu">Médicos</button>
        <div class="escolha-conteudo">
            <a href="adicionar_medico.jsp">Novo médico</a>
            <a href="apagar_medico.jsp">Apagar médico</a>
            <a href="listagem_medicos.jsp">Listar médicos</a>
        </div>
    </div>

    <div class="escolha">
        <button class="botaomenu">Pacientes</button>
        <div class="escolha-conteudo">
            <a href="adicionar_paciente.jsp">Novo paciente</a>
            <a href="apagar_paciente.jsp">Apagar paciente</a>
            <a href="listagem_pacientes.jsp">Listar pacientes</a>
        </div>
    </div>

    <div class="escolha">
        <button class="botaomenu">Marcações</button>
        <div class="escolha-conteudo">
            <a href="adicionar_marcacao.jsp">Nova marcação</a>
            <a href="apagar_marcacao.jsp">Apagar marcação</a>
            <a href="listagem_marcacoes.jsp">Listar marcações</a>
        </div>
    </div>
</div>

</body>
</html>