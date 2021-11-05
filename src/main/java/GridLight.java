import java.awt.*;
import java.util.*;
import java.util.stream.Stream;

public class GridLight {

    private final Strategy turnOnStrategy;
    private final Strategy turnOffStrategy;
    private Strategy toggleStrategy;
    private Map<Point, Integer> lightsOn = new HashMap<Point, Integer>();

    public GridLight() {
        this.turnOnStrategy = new TurnOnStrategy();
        this.turnOffStrategy = new TurnOffStrategy();
        this.toggleStrategy = new ToggleStrategy();
    }


    public void turnOn(Point from, Point to) {
        execute(from, to, turnOnStrategy);

    }

    public void turnOff(Point from, Point to) {
        execute(from, to, turnOffStrategy);

    }

    public void toggle(Point from, Point to) {
        execute(from, to, toggleStrategy);

    }

    private void execute(Point from, Point to, Strategy strategy) {
        for (int x = from.x; x <= to.x; x++) {
            for (int y = from.y; y <= to.y; y++) {
                strategy.execute(this.lightsOn, new Point(x, y));
            }
        }
    }

    public int countOn() {
        return lightsOn.size();
    }


    public Integer brightness() {
        return lightsOn
                .values()
                .stream()
                .reduce(Integer::sum).orElse(0);
    }
}
