package it.unicam.cs.pa.jlogo.api;

import it.unicam.cs.pa.jlogo.api.module.CursorLogo;
import it.unicam.cs.pa.jlogo.api.module.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is used to test the functionalities of the {@link CursorLogo} class
 */

public class CursorLogoTest {

    /**
     * Checks that invalid size is not accepted by the cursor
     */
    @Test
    void sizeShouldNotBeValid() {
        IllegalArgumentException exception;

        exception = assertThrows(IllegalArgumentException.class, () -> new CursorLogo(new Point(0, 0)).changePenSize(0));
        assertEquals(exception.getMessage(), "Illegal cursor pen size: " + 0 + "; the should be more than 0");
    }

    /**
     * Checks that invalid angle change is not accepted by the cursor
     */
    @Test
    void directionShouldNotBeValid() {
        IllegalArgumentException exception;

        exception = assertThrows(IllegalArgumentException.class, () -> new CursorLogo(new Point(0, 0)).changeDirection(361));
        assertEquals(exception.getMessage(), "Illegal change of direction: " + 361 + "; the angle should be in the [0;360] bounds!");

        exception = assertThrows(IllegalArgumentException.class, () -> new CursorLogo(new Point(0, 0)).changeDirection(-361));
        assertEquals(exception.getMessage(), "Illegal change of direction: " + -361 + "; the angle should be in the [0;360] bounds!");
    }

    /**
     * Checks that the direction is modified correctly after being altered by the new angle
     */
    @Test
    void shouldModifyDirectionWithinBounds() {
        CursorLogo c = new CursorLogo(new Point(0, 0));

        c.changeDirection(359);
        c.changeDirection(100);
        assertEquals(99, c.getDirection());

        c.changeDirection(-200);
        assertEquals(259, c.getDirection());
    }
}
