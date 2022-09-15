package it.unicam.cs.pa.jlogo.api.module;

/**
 * This interface is used to coordinate the cursor and the area in order to manage the drawing of shapes and connected functions
 *
 * @author Stanislav Teghipco
 */

public interface DrawingManager {

    /**
     * Returns the area used for drawing
     *
     * @return the area used for drawing
     */
    DrawableAreaLogo getArea();

    /**
     * Returns the cursor used to draw with
     *
     * @return the cursor used to draw with
     */
    CursorLogo getCursor();

    /**
     * Draws a line from the current position of the cursor to a new position
     *
     * @param newPosition the ending position of the line
     */
    void drawLine(Point2D newPosition);

    /**
     * Changes the cursor direction by a given angle and checks that the values are right
     *
     * @param angle the angle that is going to be added to the direction of the cursor
     */
    void changeCursorDirection(int angle);

    /**
     *
     * @param size
     */
    void changeCursorSize(int size);
}
