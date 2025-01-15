// App.java
package org.example.pawcare;

import javax.swing.SwingUtilities;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        try {
            SplashScreen splash = new SplashScreen();
            splash.simulateLoading();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            SwingUtilities.invokeLater(() -> {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            });

            splash.close();
        } catch (Exception e) {
            System.err.println("Erro no arranque!" + e.getMessage());
            e.printStackTrace();
        }
    }
}