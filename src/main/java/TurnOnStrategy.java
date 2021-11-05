import java.awt.*;
import java.util.Map;

public class TurnOnStrategy implements Strategy {

    public static final int INCREMENT = 1;

    public void execute(Map<Point, Integer> lightsOn, Point point) {
        if (lightsOn.containsKey(point)) {
            Integer brightness = lightsOn.get(point) + INCREMENT;
            lightsOn.put(point, brightness);

        } else {
            lightsOn.put(point, INCREMENT);
        }
    }
}
