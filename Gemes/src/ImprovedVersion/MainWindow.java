package ImprovedVersion;

import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        setTitle("Змейка");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(336, 360);
        setLocationRelativeTo(null);
        add(new GameField());
        setVisible(true);
    }
}
