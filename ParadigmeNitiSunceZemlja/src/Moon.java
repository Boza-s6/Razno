import java.awt.Graphics;

/**
 * Created by nemanja on 16.11.15..
 */
public class Moon implements Runnable {
    private static final int DIAMETER = 5;
    private static final int CIRCLE_DIAMETER = 50;

    private int mX, mY;
    private double mAngle;
    private SolarSystemCanvas mSolarSystemCanvas;

    public Moon(SolarSystemCanvas canvas) {
        mSolarSystemCanvas = canvas;
        mX = 0;
        mY = 250;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(100);
                updateCoordinates();
//                mSolarSystemCanvas.repaint();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void updateCoordinates() {
        Sun sun = mSolarSystemCanvas.getSun();
        Earth earth = mSolarSystemCanvas.getEarth();
        int sx = sun.getX();
        int sy = sun.getY();

        mX = sx + (int) Math.cos(earth.getAngle());
        mY = sy + (int) Math.sin(earth.getAngle());

        int ex = earth.getX();
        int ey = earth.getY();

        mX += ex + Math.cos(mAngle);
        mY += ey + Math.cos(mAngle);

        mAngle += 24 * Math.PI / 365;
    }

    public synchronized void paintSelf(Graphics g) {
        g.fillOval(mX, mY, DIAMETER / 2, DIAMETER / 2);
    }
}
