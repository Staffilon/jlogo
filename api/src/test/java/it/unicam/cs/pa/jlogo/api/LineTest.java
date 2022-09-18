package it.unicam.cs.pa.jlogo.api;

import it.unicam.cs.pa.jlogo.api.colors.RGBColor;
import it.unicam.cs.pa.jlogo.api.colors.RGBColorLogo;
import it.unicam.cs.pa.jlogo.api.shapes.Line;
import it.unicam.cs.pa.jlogo.api.module.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is used to test the {@link Line} class
 *
 * @author Stanislav Teghipco
 */
public class LineTest {

    /**
     * Checks that the lines created with invalid size values do throw exceptions with the respective messages
     */
    @Test
    void shouldThrowException() {
        Point p1 = new Point(1, 5);
        Point p2 = new Point(2, 7);
        IllegalArgumentException exception;

        for (int i = 0; i < 3; i++) {
            int size = -i;
            exception = assertThrows(IllegalArgumentException.class, () -> new Line(p1, p2, size, new RGBColorLogo()));
            assertEquals(exception.getMessage(), "Invalid line size: " + size + "; size should be bigger than 0");
        }
    }

    /**
     * Checks that the lines created with valid size values do not throw exceptions
     */
    @Test
    void shouldNotThrowException() {
        Point p1 = new Point(12, 654);
        Point p2 = new Point(0, 1);

        assertDoesNotThrow(() -> new Line(p1, p2, 1, new RGBColorLogo()));
        assertDoesNotThrow(() -> new Line(p1, p2, 2, new RGBColorLogo()));
    }
}