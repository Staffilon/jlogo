package it.unicam.cs.pa.jlogo.api.module;

import it.unicam.cs.pa.jlogo.api.color.RGBColor;

/**
 * This interface represents the core features a cursor within a logo application needs to have
 *
 * @author Stanislav Teghipco
 */

public interface Cursor {

    /**
     * Returns the color used to draw shapes on the area
     *
     * @return the color used to draw shapes
     */
    RGBColor getPenColor();

    /**
     * Returns the color used to fill the polygons created on the area
     *
     * @return the color used to fill polygons
     */
    RGBColor getFillColor();

    /**
     * Returns the size (thickness) of the shapes drawn on the area
     *
     * @return the size of the shapes
     */
    int getPenSize();

    /**
     * Shows if the cursor is going to draw while being moved
     *
     * @return true if the cursor is going to draw, false otherwise
     */
    boolean getPlot();

    /**
     * Returns the position of the cursor on the area
     *
     * @return the position of the cursor
     */
    Point2D getPosition();

    /**
     * Returns the direction in which the cursor is going to move;
     * With the cardinal directions as a reference:
     * 0/360 degrees: East
     * 90 degrees: North
     * 180 degrees: West
     * 270 degrees: South
     *
     * @return the degrees corresponding to the direction
     */
    int getDirection();
}
