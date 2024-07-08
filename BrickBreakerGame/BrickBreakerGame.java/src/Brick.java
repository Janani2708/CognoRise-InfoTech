import java.awt.*;

public class Brick {
    private int x, y, width = 60, height = 20;
    private boolean isVisible = true;

    public Brick(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public void draw(Graphics g) {
        if (isVisible) {
            g.setColor(Color.GREEN);
            g.fillRect(x, y, width, height);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
