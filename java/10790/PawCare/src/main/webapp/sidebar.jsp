<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.*,java.text.*" %>
<%@page import="java.sql.*" %>
<%@page import="ligarbd.*" %>

<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>PawCare Pro</title>
    <link rel="stylesheet" href="css/estilos.css"> <!-- css -->
    <script src="https://kit.fontawesome.com/462dabcdd4.js" crossorigin="anonymous"></script> <!-- icons -->
</head>

<body>
<div class="sidebar" id="sidebar" role="navigation">

    <!-- logo pawcare -->
    <div class="sidebar-logo">
        <img src="imagens/logo/logo.svg" alt="PawCare Pro">
    </div>

    <!-- navegação -->
    <div class="sidebar-nav">

        <!-- início -->
        <button class="botao-opcao">
            <a href="#"> <i class="fas fa-house"></i>Início</a>
        </button>

        <!-- agenda -->
        <button class="botao-opcao">
            <a href="#"> <i class="fas fa-calendar"></i>Agenda</a>
        </button>

        <!-- vendas -->
        <button class="botao-opcao">
            <a href="#"> <i class="fas fa-cash-register"></i>Vendas</a>
        </button>

        <!-- dropdown registo -->
            <button class="botao-dropdown">
                <a href="#"><i class="fas fa-notes-medical"></i>Registo</a>
                <i class="fa-solid fa-chevron-down fa-xs" id="chevron"></i>
            </button>
            <!-- escolhas dropdown registo -->
            <div class="dropdown-opcoes">
                <!-- animais -->
                <button class="botao-opcao">
                    <a href="#"> <i class="fas fa-paw"></i>Animais</a>
                </button>
                <!-- tutores -->
                <button class="botao-opcao">
                    <a href="#"> <i class="fas fa-user"></i>Tutores</a>
                </button>
                <!-- fornecedores -->
                <button class="botao-opcao">
                    <a href="#"> <i class="fas fa-bag-shopping"></i>Fornecedores</a>
                </button>
            </div>

        <!-- historial clínico -->
        <button class="botao-opcao">
            <a href="#"> <i class="fas fa-stethoscope"></i>Historial</a>
        </button>

        <!-- dropdown gestão -->
        <button class="botao-dropdown">
            <a href="#"> <i class="fas fa-gear"></i>Gestão</a>
            <i class="fa-solid fa-chevron-down fa-xs" id="chevron"></i>
        </button>

        <!-- escolhas dropdown gestão -->
        <div class="dropdown-opcoes">
            <!-- inventário -->
            <button class="botao-opcao">
                <a href="#"> <i class="fas fa-prescription-bottle"></i>Inventário</a>
            </button>

            <!-- encomendas -->
            <button class="botao-opcao">
                <a href="#"> <i class="fas fa-box"></i>Encomendas</a>
            </button>

            <!-- equipa -->
            <button class="botao-opcao">
                <a href="#"> <i class="fas fa-user-doctor"></i>Equipa</a>
            </button>
        </div>

        <!-- logout -->
        <button class="botao-opcao">
            <a href="login.jsp"><i class="fas fa-right-from-bracket"></i>Logout</a>
        </button>

    </div>
</div>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        const botoesDropdown = document.querySelectorAll(".botao-dropdown");

        botoesDropdown.forEach(button => {
            button.addEventListener("click", function (event) {
                event.stopPropagation();
                const conteudoDropdown = this.nextElementSibling;
                const chevron = this.querySelector('#chevron');


                botoesDropdown.forEach(otherButton => {
                    if (otherButton !== this) {
                        otherButton.classList.remove("active");
                        const otherContent = otherButton.nextElementSibling;
                        const otherChevron = otherButton.querySelector('#chevron');
                        if (otherContent) {
                            otherContent.style.display = "none";
                            otherButton.style.backgroundColor = "";
                            otherButton.querySelector('i:not(#chevron)').style.color = "";
                            otherButton.querySelector('a').style.color = "";
                            if (otherChevron) {
                                otherChevron.style.color = "";
                            }
                        }
                    }
                });


                this.classList.toggle("active");
                if (conteudoDropdown) {
                    const isCurrentlyVisible = conteudoDropdown.style.display === "block";
                    conteudoDropdown.style.display = isCurrentlyVisible ? "none" : "block";

                    if (!isCurrentlyVisible) {
                        this.style.backgroundColor = "#0f5765";
                        this.querySelector('i:not(#chevron)').style.color = "#d4dfdf";
                        this.querySelector('a').style.color = "#d4dfdf";
                        if (chevron) {
                            chevron.style.color = "#d4dfdf";
                            chevron.style.transform = "rotate(180deg)";
                        }
                    } else {
                        this.style.backgroundColor = "";
                        this.querySelector('i:not(#chevron)').style.color = "";
                        this.querySelector('a').style.color = "";
                        if (chevron) {
                            chevron.style.color = "";
                            chevron.style.transform = "";
                        }
                    }
                }
            });
        });
    });
</script>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        const sidebar = document.querySelector(".sidebar");
        const openButton = document.querySelector(".openbtn");
        const dropdownButtons = document.querySelectorAll(".botao-dropdown");


        dropdownButtons.forEach((btn) => {
            btn.addEventListener("click", function () {
                const dropdownContent = this.nextElementSibling;
                dropdownContent.classList.toggle("show");
                this.classList.toggle("active");
            });
        });
    });
</script>
</body>
</html>