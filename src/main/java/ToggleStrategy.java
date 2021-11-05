import java.awt.*;
import java.util.Map;

public class ToggleStrategy implements Strategy {

    public static final int INCREMENT = 2;

    public void execute(Map<Point, Integer> lightsOn, Point point) {
        if (lightsOn.containsKey(point)) {
            lightsOn.put(point, lightsOn.get(point) + INCREMENT);
        } else {
            lightsOn.put(point, INCREMENT);
        }
    }
}
