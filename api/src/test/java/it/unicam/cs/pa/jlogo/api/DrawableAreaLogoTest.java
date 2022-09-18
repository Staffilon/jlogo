package it.unicam.cs.pa.jlogo.api;

import it.unicam.cs.pa.jlogo.api.colors.RGBColorLogo;
import it.unicam.cs.pa.jlogo.api.module.DrawableAreaLogo;
import it.unicam.cs.pa.jlogo.api.shapes.Line;
import it.unicam.cs.pa.jlogo.api.module.Point;
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
        assertEquals(0, area.getDrawnShapes().size());

        Point p1 = new Point(120, 32);
        Point p2 = new Point(43, 54);
        area.drawShape(new Line(p1, p2, 4, new RGBColorLogo()));
        area.drawShape(new Line(p1, p2, 4, new RGBColorLogo()));
        area.drawShape(new Line(p1, p2, 4, new RGBColorLogo()));
        area.drawShape(new Line(p1, p2, 4, new RGBColorLogo()));
        area.drawShape(new Line(p1, p2, 4, new RGBColorLogo()));
        area.drawShape(new Line(p1, p2, 4, new RGBColorLogo()));
        assertEquals(6, area.getDrawnShapes().size());
    }
}
