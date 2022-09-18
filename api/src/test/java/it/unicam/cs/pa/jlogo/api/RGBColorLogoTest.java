package it.unicam.cs.pa.jlogo.api;
import it.unicam.cs.pa.jlogo.api.colors.RGBColor;
import it.unicam.cs.pa.jlogo.api.colors.RGBColorLogo;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is used to test the {@link RGBColorLogo} class
 *
 * @author Stanislav Teghipco
 */
public class RGBColorLogoTest {

    /**
     * Checks that the values have been assigned correctly to the respective color bytes
     */
    @Test
    void shouldHaveSameValues() {
        RGBColor c1 = new RGBColorLogo(123, 54, 200);
        RGBColor c2 = new RGBColorLogo(0, 0, 0);
        RGBColor c3 = new RGBColorLogo(255, 255, 255);
        RGBColor c4 = new RGBColorLogo();

        checkByteValues(c1, 123, 54, 200);
        checkByteValues(c2, 0, 0, 0);
        checkByteValues(c3, 255, 255, 255);
        checkByteValues(c4, 0, 0, 0);
    }

    /**
     * Checks that the passed values correspond to the values of the RGBColor object
     *
     * @param color     RGBColor object of which attributes are going to be check
     * @param redByte   red byte value that the color should have
     * @param greenByte green byte value that the color should have
     * @param blueByte  blue byte value that the color should have
     */
    void checkByteValues(@NotNull RGBColor color, int redByte, int greenByte, int blueByte) {
        assertEquals(redByte, color.getRedByte());
        assertEquals(greenByte, color.getGreenByte());
        assertEquals(blueByte, color.getBlueByte());
    }

    /**
     * Checks that the IllegalArgumentException is being thrown at the creation of a new RGBColor object and that the
     * exception message corresponds to the expected one
     */
    @Test
    void shouldThrowException() {
        IllegalArgumentException exception;

        exception = assertThrows(IllegalArgumentException.class, () -> new RGBColorLogo(-1, 0, 0));
        assertEquals(exception.getMessage(), "Incorrect value (" + -1 + ") given for a color byte! It must be between [0;255] bounds");

        exception = assertThrows(IllegalArgumentException.class, () -> new RGBColorLogo(0, -1, 0));
        assertEquals(exception.getMessage(), "Incorrect value (" + -1 + ") given for a color byte! It must be between [0;255] bounds");

        exception = assertThrows(IllegalArgumentException.class, () -> new RGBColorLogo(0, 0, -1));
        assertEquals(exception.getMessage(), "Incorrect value (" + -1 + ") given for a color byte! It must be between [0;255] bounds");

        exception = assertThrows(IllegalArgumentException.class, () -> new RGBColorLogo(256, 255, 255));
        assertEquals(exception.getMessage(), "Incorrect value (" + 256 + ") given for a color byte! It must be between [0;255] bounds");

        exception = assertThrows(IllegalArgumentException.class, () -> new RGBColorLogo(255, 256, 255));
        assertEquals(exception.getMessage(), "Incorrect value (" + 256 + ") given for a color byte! It must be between [0;255] bounds");

        exception = assertThrows(IllegalArgumentException.class, () -> new RGBColorLogo(255, 255, 256));
        assertEquals(exception.getMessage(), "Incorrect value (" + 256 + ") given for a color byte! It must be between [0;255] bounds");
    }
}