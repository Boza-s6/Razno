import java.awt.Canvas;
import java.awt.Graphics;

/**
 * Created by nemanja on 16.11.15..
 */
public class SolarSystemCanvas extends Canvas {
    private Sun mSun = new Sun();
    private Earth mEarth = new Earth(this);
    private Moon mMoon = new Moon(this);

    public SolarSystemCanvas(){
        setSize(500, 500);
        new Thread(mEarth).start();
        new Thread(mMoon).start();
    }

    @Override
    public void paint(Graphics g) {
        mSun.paintSelf(g);
        mEarth.paintSelf(g);
        mMoon.paintSelf(g);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    @Override
    public void update(Graphics g) {
        super.update(g);
    }

    public Sun getSun() {
        return mSun;
    }

    public Earth getEarth() {
        return mEarth;
    }
}
