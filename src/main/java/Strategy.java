import java.awt.*;
import java.util.Map;
import java.util.Set;

public interface Strategy {
    void execute(Map<Point, Integer> lightsOn, Point point);
}
