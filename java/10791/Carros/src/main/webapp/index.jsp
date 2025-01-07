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
    <h1>Reserva de Carros</h1>

    <!-- Imagem Carro -->
    <div id="containerImagem">
        <img src="imagens/default.png" id="imagemCarro" alt="Seleccione um carro" class="carro-imagem">
    </div>
    <br>

    <!-- Dropdown "Marca" -->
    <form action="guardar.jsp" method="post">
        <div class="dropdown">
            <label for="marca">Marca:</label>
            <select id="marca" name="marca" onchange="atualizarImagem()">
                <option value="">Seleccione uma marca</option>
                <option value="honda">Honda</option>
                <option value="opel">Opel</option>
                <option value="peugeot">Peugeot</option>
                <option value="renault">Renault</option>
            </select>
        </div>
        <br>

        <!-- Input "Modelo" -->
        <div class="inputUser">
            <label for="modelo">Modelo:</label>
            <input type="text" id="modelo" name="modelo" required>
        </div>
        <br>

        <!-- Input "Matrícula" -->
        <div class="inputUser">
            <label for="matricula">Matrícula:</label>
            <input type="text" id="matricula" name="matricula" required>
        </div>
        <br>

        <!-- Dropdown "Ano" -->
        <div class="dropdown">
            <label for="ano">Ano:</label>
            <select id="ano" name="ano">
                <option value="">Seleccione o ano</option>
                <option value="2000-2005">2000 - 2005</option>
                <option value="2006-2010">2006 - 2010</option>
                <option value="2011-2015">2011 - 2015</option>
                <option value="2015-2020">2015 - 2020</option>
            </select>
        </div>
        <br>

        <!-- Botões -->
        <div class="botoes">
            <button type="submit" class="btn confirmar">Confirmar</button>
            <button type="reset" class="btn limpar">Limpar</button>
        </div>
    </form>
</div>

<!-- Script para atualizar imagem do carro mediante a marca seleccionada-->
<script>
    function atualizarImagem() {
        const marca = document.getElementById('marca').value;
        const imagemCarro = document.getElementById('imagemCarro');

        if (marca) {
            imagemCarro.src = 'imagens/' + marca.toLowerCase() + '.png';
            imagemCarro.style.display = 'block';
        } else {
            imagemCarro.src = 'imagens/default.png';
            imagemCarro.style.display = 'block';
        }
    }
</script>
</body>
</html>