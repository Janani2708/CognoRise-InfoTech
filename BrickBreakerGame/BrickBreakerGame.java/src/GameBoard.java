import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameBoard extends JPanel implements ActionListener {
    private Timer timer;
    private Paddle paddle;
    private Ball ball;
    private Brick[][] bricks;
    private boolean gameOver = false;

    public GameBoard() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
        setFocusable(true);

        paddle = new Paddle(350, 550);
        ball = new Ball(390, 540);
        bricks = new Brick[5][10];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                bricks[i][j] = new Brick(70 * j + 30, 30 * i + 50);
            }
        }

        timer = new Timer(10, this);
        timer.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                paddle.keyPressed(e);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!gameOver) {
            paddle.draw(g);
            ball.draw(g);

            for (int i = 0; i < bricks.length; i++) {
                for (int j = 0; j < bricks[i].length; j++) {
                    if (bricks[i][j] != null) {
                        bricks[i][j].draw(g);
                    }
                }
            }
        } else {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game Over", 300, 300);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            ball.move();
            ball.checkCollision(paddle, bricks);
            if (ball.getBounds().y > 600) {
                gameOver = true;
            }
            repaint();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Brick Breaker Game");
        GameBoard gameBoard = new GameBoard();
        frame.add(gameBoard);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
