<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hotel Sorna | Reservas</title>
    <link rel="icon" href="imagens/favicon.png">
    <link rel="stylesheet" href="css/estilos.css">
</head>

<body>
<form action="guardar.jsp" method="post">
    <div align="center">

        <!-- Header -->
        <img src="imagens/header.png" alt="Hotel Sorna Logo" style="margin: 20px 0;" class="header">
        <br>
        <h2>Reservar Estadia</h2>

        <!-- Data de check-in -->
        <div class="calendario">
            <label for="dataCheckin" class="data">Seleccione a data de check-in:</label>
            <input type="date"
                   id="dataCheckin"
                   name="dataCheckin"
            class="selecData"
            onchange="handleDataChange(this.value)"
            required>
        </div>

        <!-- Data de check-out -->
        <div class="calendario">
            <label for="dataCheckout" class="data">Seleccione a data de check-out:</label>
            <input type="date"
                   id="dataCheckout"
                   name="dataCheckout"
            class="selecData"
            onchange="handleDataChange(this.value)"
            required>
        </div>

        <!-- Tipo de quarto -->
        <div class="dropdown">
            <label for="quarto" class="quarto">Tipo de alojamento:</label>
            <select id="quarto" name="quarto" class="selecQuarto" required>
                <option value="">Seleccione a opção</option>
                <option value="Quarto singular">Quarto singular</option>
                <option value="Quarto duplo">Quarto duplo</option>
                <option value="Penthouse">Penthouse</option>
                <option value="Villa">Villa</option>
            </select>
        </div>
        
        <!-- Input do contacto -->
        <div class="contacto">
            <label for="contacto" class="contacto">Contacto:</label>
            <input type="text" id="contacto" name="contacto" class="introContacto" required>
        </div>

        <!-- Botões -->
        <div class="botoes">
            <button type="submit" class="btn confirmar">Confirmar</button>
            <button type="reset" class="btn limpar">Limpar</button>
        </div>
    </div>
</form>
</body>
</html>