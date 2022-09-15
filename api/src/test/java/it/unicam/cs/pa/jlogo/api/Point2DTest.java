package it.unicam.cs.pa.jlogo.api;

import it.unicam.cs.pa.jlogo.api.module.Point2D;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;


/**
 * This class is used to test the {@link Point2D} class
 *
 * @author Stanislav Teghipco
 */
public class Point2DTest {

    /**
     * Checks that the points have the same value and no error has been caused by the double type
     */
    @RepeatedTest(10)
    void shouldHaveSameValues() {
        Point2D p1 = new Point2D(5.6931, 1234.4385);
        Point2D p2 = new Point2D(5.6931, 1234.4385);

        assertTrue(p1.compareCoordinates(p2));

        Point2D p3 = new Point2D();
        Point2D p4 = new Point2D(0d, 0d);

        assertTrue(p3.compareCoordinates(p4));
    }

    /**
     * Checks that the points have the different values
     */
    @RepeatedTest(10)
    void shouldHaveDifferentValues() {
        Point2D p1 = new Point2D(10.22262, 322.79842);
        Point2D p2 = new Point2D(10.22261, 322.79841);

        assertFalse(p1.compareCoordinates(p2));

        Point2D p3 = new Point2D();
        Point2D p4 = new Point2D(0.000001, 0.000001);

        assertFalse(p3.compareCoordinates(p4));
    }
}