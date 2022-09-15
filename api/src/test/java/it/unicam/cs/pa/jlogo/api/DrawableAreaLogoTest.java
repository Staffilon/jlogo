package it.unicam.cs.pa.jlogo.api;

import it.unicam.cs.pa.jlogo.api.module.DrawableAreaLogo;
import it.unicam.cs.pa.jlogo.api.module.Line2D;
import it.unicam.cs.pa.jlogo.api.module.Point2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is used to test the {@link DrawableAreaLogo} class
 */
public class DrawableAreaLogoTest {

    /**
     * Checks that the addShape method works properly
     */
    @Test
    void shouldDrawShapes() {
        DrawableAreaLogo area = new DrawableAreaLogo(123, 456);
        assertEquals(0, area.getShapes().size());

        Point2D p1 = new Point2D(120, 32);
        Point2D p2 = new Point2D(43, 54);
        area.draw(new Line2D(p1, p2, 4));
        area.draw(new Line2D(p1, p2, 4));
        area.draw(new Line2D(p1, p2, 4));
        area.draw(new Line2D(p1, p2, 4));
        area.draw(new Line2D(p1, p2, 4));
        area.draw(new Line2D(p1, p2, 4));
        assertEquals(6, area.getShapes().size());
    }
}
