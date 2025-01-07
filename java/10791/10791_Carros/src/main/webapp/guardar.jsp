<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Carros</title>
    <link rel="icon" href="imagens/favicon.png">
    <link rel="stylesheet" href="css/estilos.css">
</head>
<body>
<div align="center">
    <h2>Detalhes da Reserva</h2>

    <!-- Imagem Carro -->
    <div id="containerImagem">
        <img src="imagens/<%= request.getParameter("marca").toLowerCase() %>.png" id="imagemCarro" alt="Carro seleccionado" class="carro-imagem">
    </div>

    <!-- Detalhes da reserva -->
    <div class="detalhes">
        <p><strong>Marca:</strong> <%= request.getParameter("marca") %>
        </p>
        <p><strong>Modelo:</strong> <%= request.getParameter("modelo") %>
        </p>
        <p><strong>Matrícula:</strong> <%= request.getParameter("matricula") %>
        </p>
        <p><strong>Ano:</strong> <%= request.getParameter("ano") %>
        </p>
    </div>

    <!-- Botão para regressar ao formulário -->
    <div class="botoes">
        <button type="button" class="btn voltar" onclick="window.location.href='index.jsp'">Voltar ao Formulário
        </button>
    </div>
</div>
</body>
</html>