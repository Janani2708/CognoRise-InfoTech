import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle {
    private int x, y;
    private final int width = 100, height = 10;
    private final int moveSpeed = 20;

    public Paddle(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public void moveLeft() {
        if (x - moveSpeed >= 0) {
            x -= moveSpeed;
        }
    }

    public void moveRight() {
        if (x + width + moveSpeed <= 800) {
            x += moveSpeed;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            moveLeft();
        }
        if (key == KeyEvent.VK_RIGHT) {
            moveRight();
        }
    }
}
