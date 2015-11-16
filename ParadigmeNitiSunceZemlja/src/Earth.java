import java.awt.Graphics;

/**
 * Created by nemanja on 16.11.15..
 */
public class Earth implements Runnable {
    private static final int DIAMETER = 10;
    private static final int CIRCLE_DIAMETER = 400;
    private int mX, mY; //coordinates
    private double mAngle;
    private SolarSystemCanvas mSolarSystemCanvas;

    public Earth(SolarSystemCanvas canvas) {
        mX = 50;
        mY = 250;
        mSolarSystemCanvas = canvas;
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
        int sx = sun.getX();
        int sy = sun.getY();

        mX *= (int) Math.cos(mAngle);
        mY *= (int) Math.sin(mAngle);
        mAngle += 2 * Math.PI / 365;
    }

    public synchronized void paintSelf(Graphics g) {
        g.fillOval(mX, mY, DIAMETER / 2, DIAMETER / 2);
    }

    public synchronized int getX() {
        return mX;
    }

    public synchronized int getY() {
        return mY;
    }

    public synchronized double getAngle() {
        return mAngle;
    }
}
