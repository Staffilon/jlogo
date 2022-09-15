package it.unicam.cs.pa.jlogo.api;

import it.unicam.cs.pa.jlogo.api.module.Line2D;
import it.unicam.cs.pa.jlogo.api.module.Point2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is used to test the {@link Line2D} class
 *
 * @author Stanislav Teghipco
 */
public class Line2DTest {

    /**
     * Checks that the lines created with invalid size values do throw exceptions with the respective messages
     */
    @Test
    void shouldThrowException() {
        Point2D p1 = new Point2D(1, 5);
        Point2D p2 = new Point2D(2, 7);
        IllegalArgumentException exception;

        for (int i = 0; i < 3; i++) {
            int size = -i;
            exception = assertThrows(IllegalArgumentException.class, () -> new Line2D(p1, p2, size));
            assertEquals(exception.getMessage(), "Invalid line size: " + size + "; size should be bigger than 0");
        }

    }

    /**
     * Checks that the lines created with valid size values do not throw exceptions
     */
    @Test
    void shouldNotThrowException() {
        Point2D p1 = new Point2D(12, 654);
        Point2D p2 = new Point2D(0, 1);

        assertDoesNotThrow(() -> new Line2D(p1, p2, 1));
        assertDoesNotThrow(() -> new Line2D(p1, p2, 2));
    }
}