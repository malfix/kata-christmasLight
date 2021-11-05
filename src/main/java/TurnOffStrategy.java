import java.awt.*;
import java.util.Map;

public class TurnOffStrategy implements Strategy {
    public void execute(Map<Point, Integer> lightsOn, Point point) {
        if (lightsOn.containsKey(point)) {
            Integer brightness = lightsOn.get(point) - 1;
            if (brightness <= 0) {
                lightsOn.remove(point);
            } else {
                lightsOn.put(point, brightness);
            }

        }
    }
}
