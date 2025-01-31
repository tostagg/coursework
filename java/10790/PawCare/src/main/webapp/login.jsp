<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="java.util.*,java.text.*" %>
<%@page import="java.sql.*" %>
<%@page import="ligarbd.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>PawCare Pro</title>
    <link rel="stylesheet" href="css/estilos.css"> <!-- css -->
    <link rel="icon" type="image/x-icon" href="imagens/icones/favicon.svg"> <!-- favicon -->
    <script src="https://kit.fontawesome.com/462dabcdd4.js" crossorigin="anonymous"></script> <!-- icons -->
</head>
<body>

<!-- container página -->
<div class="main-container">

    <!-- container login -->
    <div class="login-container">

        <!-- logo pawcare -->
        <img src="imagens/logo/logo.svg" alt="PawCare Pro">

        <!-- formulário de login -->
        <div class="formulario-login">

            <!-- mensagem -->
            <h1>bem-vindo</h1>

            <p id="errorMessage" style="color:#072b32;"></p>

            <!-- form -->
            <form method="post" id="form">

                <!-- input utilizador -->
                <div class="input-info">
                    <label for="username"><i class="fa-solid fa-user"></i></label>
                    <input type="text" placeholder="username" id="username" required>
                </div>

                <!-- input password -->
                <div class="input-info">
                    <label for="password"><i class="fa-solid fa-lock"></i></label>
                    <input type="password" placeholder="password" id="password" required>
                </div>

                <!-- botão login -->
                <button type="submit">login</button>
            </form>
        </div>
    </div>
</div>

<script>
    document.getElementById('form').addEventListener('submit', function (event) {
        event.preventDefault();

        let username = document.getElementById('username').value;
        let password = document.getElementById('password').value;

        if (username === "admin" && password === "admin") {
            window.location.href = "home.jsp";
        } else {

            document.getElementById('errorMessage').textContent = "Username/password inválidos. Tente novamente.";
        }
    });
</script>
</body>
</html>