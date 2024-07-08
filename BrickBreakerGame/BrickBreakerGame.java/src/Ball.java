import java.awt.*;

public class Ball {
    private int x, y, diameter = 10;
    private int xSpeed = 3, ySpeed = -3;

    public Ball(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public void move() {
        x += xSpeed;
        y += ySpeed;

        // Collision with walls
        if (x <= 0 || x >= 800 - diameter) {
            xSpeed = -xSpeed;
        }
        if (y <= 0) {
            ySpeed = -ySpeed;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, diameter, diameter);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, diameter, diameter);
    }

    public void checkCollision(Paddle paddle, Brick[][] bricks) {
        if (getBounds().intersects(paddle.getBounds())) {
            ySpeed = -ySpeed;
        }

        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[i].length; j++) {
                Brick brick = bricks[i][j];
                if (brick != null && getBounds().intersects(brick.getBounds())) {
                    ySpeed = -ySpeed;
                    bricks[i][j] = null;
                }
            }
        }
    }
}
