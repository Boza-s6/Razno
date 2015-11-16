import java.applet.Applet;

/**
 * Created by nemanja on 16.11.15..
 */
public class SolarSystem extends Applet {
    @Override
    public void init() {
        setSize(500, 500);
        add(new SolarSystemCanvas());
    }
}
