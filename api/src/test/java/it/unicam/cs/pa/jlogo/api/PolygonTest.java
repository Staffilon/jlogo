package it.unicam.cs.pa.jlogo.api;

import it.unicam.cs.pa.jlogo.api.colors.RGBColorLogo;
import it.unicam.cs.pa.jlogo.api.exceptions.IllegalShapeException;
import it.unicam.cs.pa.jlogo.api.module.Point;
import it.unicam.cs.pa.jlogo.api.shapes.Line;
import it.unicam.cs.pa.jlogo.api.shapes.Polygon;
import it.unicam.cs.pa.jlogo.api.shapes.SingleStrokeShape;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is used to test the functionalities of the {@link it.unicam.cs.pa.jlogo.api.shapes.Polygon} class
 *
 * @author Stanislav Teghipco
 */

public class PolygonTest {
    /**
     * Checks that the list of shapes with not enough elements will throw an IllegalArgumentException
     */
    @Test
    void shouldThrowIllegalArgumentException() {
        Line l1 = new Line(new Point(0, 0), new Point(0, 4), 2, new RGBColorLogo());
        Line l2 = new Line(new Point(0, 4), new Point(4, 8), 2, new RGBColorLogo());
        IllegalArgumentException exception;

        List<SingleStrokeShape> shapes = new ArrayList<>();
        shapes.add(l1);
        shapes.add(l2);

        exception = assertThrows(IllegalArgumentException.class, () -> new Polygon(shapes, new RGBColorLogo()));
        assertEquals(exception.getMessage(), "Illegal composing shapes number: " + 2 + "; they cannot be less than 3");
    }

    /**
     * Checks that the different external points will throw an IllegalShapeException
     */
    @Test
    void shouldThrowIllegalShapeExceptionWithExternalPoints() {
        Line l1 = new Line(new Point(0, 0), new Point(0, 4), 2, new RGBColorLogo());
        Line l2 = new Line(new Point(0, 4), new Point(4, 8), 2, new RGBColorLogo());
        Line l3 = new Line(new Point(4, 8), new Point(0, 0.1), 2, new RGBColorLogo());
        IllegalShapeException exception;

        List<SingleStrokeShape> shapes = new ArrayList<>();
        shapes.add(l1);
        shapes.add(l2);
        shapes.add(l3);

        exception = assertThrows(IllegalShapeException.class, () -> new Polygon(shapes, new RGBColorLogo()));
        assertEquals(exception.getMessage(),
                "Illegal enclosed shape, starting point " + "0.0 0.0"
                        + " doesn't have the same coordinates as ending point " + "0.0 0.1");
    }

    /**
     * Checks that the different internal points will throw an IllegalShapeException
     */
    @Test
    void shouldThrowIllegalShapeExceptionWithInternalPoints() {
        Line l1 = new Line(new Point(0, 0), new Point(0, 4), 2, new RGBColorLogo());
        Line l2 = new Line(new Point(0, 4), new Point(4, 9), 2, new RGBColorLogo());
        Line l3 = new Line(new Point(4, 8), new Point(0, 0), 2, new RGBColorLogo());
        IllegalShapeException exception;

        List<SingleStrokeShape> shapes = new ArrayList<>();
        shapes.add(l1);
        shapes.add(l2);
        shapes.add(l3);

        exception = assertThrows(IllegalShapeException.class, () -> new Polygon(shapes, new RGBColorLogo()));
        assertEquals(exception.getMessage(),
                "Illegal enclosed shape, ending point " + "4.0 9.0"
                        + " is not connected to the starting point of the next shape " + "4.0 8.0");
    }

    /**
     * Checks that, given correct values, the polygon is built
     */
    @Test
    void shouldBuildPolygon() {
        Line l1 = new Line(new Point(0, 0), new Point(0, 4), 2, new RGBColorLogo());
        Line l2 = new Line(new Point(0, 4), new Point(4, 8), 2, new RGBColorLogo());
        Line l3 = new Line(new Point(4, 8), new Point(0, 0), 2, new RGBColorLogo());

        List<SingleStrokeShape> shapes = new ArrayList<>();
        shapes.add(l1);
        shapes.add(l2);
        shapes.add(l3);
        assertDoesNotThrow(() -> new Polygon(shapes, new RGBColorLogo()));
    }
}