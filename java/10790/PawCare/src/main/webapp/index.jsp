<!-- splashscreen inicial -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>PawCare Pro</title>
    <link rel="stylesheet" href="css/estilos.css">  <!-- css -->
    <link rel="icon" type="image/x-icon" href="imagens/icones/favicon.svg"> <!-- favicon -->
    <script src="https://kit.fontawesome.com/462dabcdd4.js" crossorigin="anonymous"></script> <!-- icons -->

</head>
<body>
<!-- container página -->
<div class="main-container">

    <!-- container splash -->
    <div class="splash-container">

        <!-- splash -->
        <div id="splash">

            <!-- logo pawcare -->
            <img src="imagens/logo/logo.svg" alt="PawCare Pro">

            <!-- container progresso -->
            <div class="progresso-container">

                <!-- barra de progresso -->
                <div class="barra-progresso">
                    <div class="percentagem-progresso">0%</div>
                    <div class="carregar-progresso"></div>
                </div>
            </div>
        </div>
    </div>

</div>

<script>
    window.addEventListener('load', function () {
        const barraProgresso = document.querySelector('.carregar-progresso');
        const percentagem = document.querySelector('.percentagem-progresso');
        let progresso = 0;

        const interval = setInterval(() => {
            if (progresso < 100) {
                progresso++;
                barraProgresso.style.width = progresso + '%';
                percentagem.textContent = progresso + '%';
            } else {
                clearInterval(interval);
                setTimeout(() => {
                    window.location.href = "login.jsp";
                }, 1000);
            }
        }, 30);
    });
</script>
</body>
</html>
