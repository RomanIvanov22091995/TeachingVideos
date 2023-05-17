package ImprovedVersion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameField extends JPanel implements ActionListener {

    private final int SIZE = 320;
    private final int DOT_SIZE = 16;
    private final int ALL_DOTS = 400;
    private Image dot;
    private Image apple;
    private Image field;
    private int appleX;
    private int appleY;
    private int[] x = new int[ALL_DOTS];
    private int[] y = new int[ALL_DOTS];
    private int dots;
    private Timer timer;

    //перенести переменные в класс с передвижением
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    //
    private boolean inGame = false;
    private boolean timerOn = false;


    public GameField() {
        setBackground(Color.WHITE);
        loadImages();
        initGame();
        addKeyListener(new inGameListener());
        setFocusable(true);
        startTimer();
    }

    public void initGame() {
        right = true;
        left = false;
        up = false;
        down = false;

        inGame = true;
        timerOn = true;

        dots = 3;
        for (int i = 0; i < dots; i++) {
            x[i] = 48 - i * DOT_SIZE;
            y[i] = 48;
        }
    }

    public void startTimer() {
        timer = new Timer(250, this);
        timer.start();
        createApple();
    }

    public void createApple() {
        newApple();
        for (int i = dots; i > 0; i--) {
            if (x[i] == appleX && y[i] == appleY) {
                newApple();
            }
        }
    }

    public void newApple() {
        appleX = new Random().nextInt(20) * DOT_SIZE;
        appleY = new Random().nextInt(20) * DOT_SIZE;
    }

    public void loadImages() {
        ImageIcon dotImage = new ImageIcon("src/Dot.png");
        dot = dotImage.getImage();
        ImageIcon appleImage = new ImageIcon("src/Apple.png");
        apple = appleImage.getImage();
        ImageIcon fieldImage = new ImageIcon("src/fence.png");
        field = fieldImage.getImage();
    }

    public void checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            dots++;
            createApple();
        }
    }

    public void move() {
        for (int i = dots; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        if (left) {
            x[0] -= DOT_SIZE;
            if (x[0] < 0)
                inGame = false;
        }
        if (right) {
            x[0] += DOT_SIZE;
            if (x[0] > (SIZE - DOT_SIZE))
                inGame = false;
        }
        if (up) {
            y[0] -= DOT_SIZE;
            if (y[0] < 0)
                inGame = false;
        }
        if (down) {
            y[0] += DOT_SIZE;
            if (y[0] > (SIZE - DOT_SIZE))
                inGame = false;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (inGame) {
            g.drawImage(apple, appleX, appleY, this);
            for (int i = 0; i < dots; i++) {
                g.drawImage(dot, x[i], y[i], this);
            }
        } else {
            String theEnd = "Game Over";
            Font font = new Font("Arial", Font.BOLD, 14);
            g.setColor(Color.LIGHT_GRAY);
            g.setFont(font);
            g.drawString(theEnd, 120, SIZE / 2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            checkBorders();
            checkApple();
            move();
            repaint();
        }
    }

    public void checkBorders() {
        for (int i = dots; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i])
                inGame = false;
        }
    }

    public class inGameListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT && !right) {
                left = true;
                up = false;
                down = false;
            }

            if (key == KeyEvent.VK_RIGHT && !left) {
                right = true;
                up = false;
                down = false;
            }

            if (key == KeyEvent.VK_UP && !down) {
                up = true;
                left = false;
                right = false;
            }
            if (key == KeyEvent.VK_DOWN && !up) {
                right = false;
                down = true;
                left = false;
            }
            if (key == KeyEvent.VK_ENTER) {
                initGame();
            }
            if (key == KeyEvent.VK_SPACE) {
                if (timerOn) {
                    timer.stop();
                    timerOn = false;
                } else {
                    timerOn = true;
                    timer.start();
                }
            }
        }
    }
}
