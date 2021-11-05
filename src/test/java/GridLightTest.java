import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

class GridLightTest {

    private GridLight gridLight;

    @BeforeEach
    void setUp() {
        gridLight = new GridLight();
    }

    @Test
    void check_light_on() {
        Assertions.assertEquals(0, gridLight.countOn());
        Assertions.assertEquals(0, gridLight.brightness());
    }

    @Test
    void turnOn() {
        gridLight.turnOn(new Point(0, 0), new Point(999, 999));

        Assertions.assertEquals(1000000, gridLight.countOn());

    }

    @Test
    void toggle() {
        gridLight.toggle(new Point(0, 0), new Point(499, 0));

        Assertions.assertEquals(500, gridLight.countOn());
        Assertions.assertEquals(1000, gridLight.brightness());

        gridLight.toggle(new Point(0, 0), new Point(999, 0));

        Assertions.assertEquals(3000, gridLight.brightness());

    }

    @Test
    void toggle_brightness() {
        gridLight.toggle(new Point(0, 0), new Point(999, 999));

        Assertions.assertEquals(1000000, gridLight.countOn());
        Assertions.assertEquals(2000000, gridLight.brightness());

    }


    @Test
    void turnOff() {
        gridLight.turnOn(new Point(0, 0), new Point(9, 9));

        Assertions.assertEquals(100, gridLight.countOn());

        gridLight.turnOff(new Point(4, 4), new Point(5, 5));

        Assertions.assertEquals(96, gridLight.countOn());

    }


    @Test
    void game() {
        gridLight.turnOn(new Point(887, 9), new Point(959, 629));
        gridLight.turnOn(new Point(454, 398), new Point(844, 448));
        gridLight.turnOff(new Point(539, 243), new Point(559, 965));
        gridLight.turnOff(new Point(370, 819), new Point(676, 868));
        gridLight.turnOff(new Point(145, 40), new Point(370, 997));
        gridLight.turnOff(new Point(301, 3), new Point(808, 453));
        gridLight.turnOn(new Point(351, 678), new Point(951, 908));
        gridLight.toggle(new Point(720, 196), new Point(897, 994));
        gridLight.toggle(new Point(831, 394), new Point(904, 860));

        Assertions.assertEquals(280830, gridLight.countOn());
        Assertions.assertEquals(539560, gridLight.brightness());
    }


}