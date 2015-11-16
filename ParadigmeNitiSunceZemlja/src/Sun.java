import java.awt.Graphics;

/**
 * Created by nemanja on 16.11.15..
 */
public class Sun {
    private static final int DIAMETER = 50;

    public void paintSelf(Graphics g) {
        g.fillOval(250, 250, DIAMETER/2, DIAMETER/2);
    }

    public synchronized int getX() {
        return 250;
    }

    public synchronized int getY() {
        return 250;
    }
}
