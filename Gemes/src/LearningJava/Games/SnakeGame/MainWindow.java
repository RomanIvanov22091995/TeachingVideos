package LearningJava.Games.SnakeGame;


import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow(){
        setTitle("Змейка");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // close window when we turn cross
        setSize(320,345);
        setLocation(400,400);
        add(new GameField()); // add game Field
        setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow mw = new MainWindow();

    }

}
