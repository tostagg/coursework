package org.example.pawcare;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.io.ByteArrayOutputStream;

import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;

public class MainFrame extends JFrame {

    public MainFrame() {
        // remover topbar
        setUndecorated(true);

        // conteúdo
        JPanel painelConteudo = new JPanel(new BorderLayout());
        painelConteudo.setBackground(new Color(245, 244, 243));

        // painel principal
        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBackground(new Color(245, 244, 243));

        // conteúdo no painel principal -- PROVISÓRIO
        JLabel labelTexto = new JLabel("Bem-vindo ao PawCare");
        labelTexto.setHorizontalAlignment(SwingConstants.CENTER);
        painelPrincipal.add(labelTexto, BorderLayout.CENTER);

        // sidebar
        JPanel painelSidebar = new JPanel(new BorderLayout());
        painelSidebar.setBackground(new Color(0x5AC6BD));
        painelSidebar.setPreferredSize(new Dimension(250, 700));

        // conteúdo da sidebar
        JPanel conteudoSidebar = new JPanel(new BorderLayout());
        conteudoSidebar.setOpaque(false);

        // logótipo no topo da sidebar
        JPanel painelHeader = new JPanel(new BorderLayout());
        painelHeader.setOpaque(false);

        ImageIcon header = null;
        try {
            URL headerURL = getClass().getResource("/logo/header.png");
            if (headerURL != null) {
                header = new ImageIcon(headerURL);
                int headerW = 220;
                int headerH = (int) (header.getIconHeight() * ((double) headerW / header.getIconWidth()));

                JLabel labelHeader = new JLabel(header);
                labelHeader.setHorizontalAlignment(SwingConstants.CENTER);
                painelHeader.add(labelHeader, BorderLayout.CENTER);
                labelHeader.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            } else {
                System.err.println("Imagem não encontrada!");
            }
        } catch (Exception e) {
            System.err.println("Erro ao fazer loading da imagem: " + e.getMessage());
            e.printStackTrace();
        }

        conteudoSidebar.add(painelHeader, BorderLayout.NORTH);
        conteudoSidebar.add(Box.createRigidArea(new Dimension(0, 30)));

        // botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.Y_AXIS));
        painelBotoes.setOpaque(false);
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

        adicionarBotao(painelBotoes, "/icones/inicio.svg", "Inicio");
        adicionarBotao(painelBotoes, "/icones/agenda.svg", "Agenda");
        adicionarBotao(painelBotoes, "/icones/vendas.svg", "Vendas");
        adicionarBotao(painelBotoes, "/icones/sair.svg", "Sair");

        conteudoSidebar.add(painelBotoes, BorderLayout.CENTER);
        painelSidebar.add(conteudoSidebar, BorderLayout.NORTH);
        painelConteudo.add(painelSidebar, BorderLayout.WEST);
        painelConteudo.add(painelPrincipal, BorderLayout.CENTER);

        setContentPane(painelConteudo);
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // criar botões com imagem
    private void adicionarBotao(JPanel panel, String iconPath, String buttonText) {
        URL iconURL = getClass().getResource(iconPath);
        ImageIcon icon = null;

        if (iconURL != null) {
            try (java.io.InputStream input = iconURL.openStream()) {
                PNGTranscoder transcoder = new PNGTranscoder();
                TranscoderInput input2 = new TranscoderInput(input);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                TranscoderOutput output = new TranscoderOutput(outputStream);

                transcoder.transcode(input2, output);

                byte[] pngData = outputStream.toByteArray();
                icon = new ImageIcon(pngData);

                Image scaledImage = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                icon = new ImageIcon(scaledImage);

            } catch (Exception ex) {
                System.err.println("Erro ao carregar o SVG: " + iconPath + ": " + ex.getMessage());
                ex.printStackTrace();
            }
        } else {
            System.err.println("O caminho é inválido: " + iconPath);
        }

        JButton botao = new JButton(buttonText);
        if (icon != null) {
            botao.setIcon(icon);
        }

        // personalização botões
        Font buttonFont = new Font("Fredoka Medium", Font.PLAIN, 18);
        botao.setFont(buttonFont);
        botao.setHorizontalAlignment(SwingConstants.LEFT);
        botao.setHorizontalTextPosition(SwingConstants.RIGHT);
        botao.setIconTextGap(10);
        botao.setBackground(new Color(0x5AC6BD));
        botao.setForeground(new Color(0xF5F4F3));
        botao.setBorderPainted(false);
        botao.setFocusPainted(false);
        botao.setPreferredSize(new Dimension(220, 40));
        botao.setMaximumSize(new Dimension(220, 50));
        panel.add(botao);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));


        // confirmar fecho do programa
        if (buttonText.equals("Sair")) {
            botao.addActionListener(e -> {
                int option = JOptionPane.showConfirmDialog(
                        MainFrame.this,
                        "Tem a certeza que deseja sair da aplicação?",
                        "PawCare Pro",
                        JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}