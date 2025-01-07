<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Hotel Sorna | Confirmação de Reserva</title>
    <link rel="icon" href="imagens/favicon.png">
    <link rel="stylesheet" href="css/estilos.css">

</head>

<body>
<div align="center">

    <!-- Header -->
    <img src="imagens/header.png" alt="Hotel Sorna Logo" style="margin: 20px 0;" class="header">
    <br>
    <h2>Detalhes da Reserva</h2>

    <!-- Imagem do alojamento seleccionado -->
    <div>
        <%
            String quartoTipo = request.getParameter("quarto");
            String imagemQ = "";

            switch (quartoTipo) {
                case "Quarto singular":
                    imagemQ = "imagens/singular.png";
                    break;
                case "Quarto duplo":
                    imagemQ = "imagens/duplo.png";
                    break;
                case "Penthouse":
                    imagemQ = "imagens/penthouse.png";
                    break;
                case "Villa":
                    imagemQ = "imagens/villa.png";
                    break;
                default:
                    imagemQ = "imagens/default.png";
                    break;
            }
        %>
        <img src="<%= imagemQ %>" alt="<%= quartoTipo %>" class="imagemQuarto">
    </div>

    <!-- Detalhes da reserva -->
    <div class="detalhes">
        <p><strong>Data de check-in:</strong>
            <%
                String checkin = request.getParameter("dataCheckin");
                LocalDate dateCheckin = LocalDate.parse(checkin);
                out.print(dateCheckin.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            %>
        </p>
        <p><strong>Data de check-out:</strong>
            <%
                String checkout = request.getParameter("dataCheckout");
                LocalDate dateCheckout = LocalDate.parse(checkout);
                out.print(dateCheckout.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            %>
        </p>
        <p><strong>Tipo de alojamento:</strong>
            <%= request.getParameter("quarto") %>
        </p>
        <p><strong>Contacto:</strong>
            <%= request.getParameter("contacto") %>
        </p>
    </div>

    <!-- Botão para regressar ao formulário de reserva-->
    <div class="botoes">
        <button type="button" class="btn voltar" onclick="window.location.href='index.jsp'">Voltar
        </button>
    </div>
</div>
</body>
</html>
