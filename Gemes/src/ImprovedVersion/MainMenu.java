package ImprovedVersion;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    MainMenu() {
        setTitle("MainMenu");
        add(new MainMenuPanel());
        setBackground(Color.orange);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        System.out.println("Запуск главного меню");
    }
}
