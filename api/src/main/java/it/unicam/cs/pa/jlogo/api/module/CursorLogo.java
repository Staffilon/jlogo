package it.unicam.cs.pa.jlogo.api.module;

import it.unicam.cs.pa.jlogo.api.color.RGBColor;
import it.unicam.cs.pa.jlogo.api.color.RGBColorLogo;

/**
 * This class represents a cursor that will be used by the commands to draw in the area within the logo application
 *
 * @author Stanislav Teghipco
 */

public class CursorLogo implements Cursor {

    private RGBColor penColor;
    private RGBColor fillColor;

    /**
     * Size of the drawn shapes
     */
    private int size;

    /**
     * Value that determines if the movement of the cursor will cause ony drawing
     */
    private boolean plot;

    /**
     * Direction in which the cursor will move
     */
    private int direction;
    private Point2D position;

    /**
     * Builds the cursor with the default values
     *
     * @param home the position at the center of the area
     */
    public CursorLogo(Point2D home) {
        this.penColor = new RGBColorLogo();
        this.fillColor = new RGBColorLogo(255, 255, 255);
        this.direction = 0;
        this.position = home;
        this.plot = true;
        this.size = 1;
    }

    @Override
    public RGBColor getPenColor() {
        return penColor;
    }

    @Override
    public RGBColor getFillColor() {
        return fillColor;
    }

    @Override
    public int getPenSize() {
        return size;
    }

    @Override
    public boolean getPlot() {
        return plot;
    }

    @Override
    public Point2D getPosition() {
        return position;
    }

    @Override
    public int getDirection() {
        return direction;
    }

    /**
     * Changes the size of the next shapes the cursor will be used to draw
     *
     * @param size the size of the next shapes
     */
    public void changePenSize(int size) {
        this.size = size;
    }

    /**
     * Changes the color of the polygon area
     *
     * @param newColor the new color of the area
     */
    public void changeFillColor(RGBColor newColor) {
        fillColor = newColor;
    }

    /**
     * Changes the color used to draw shapes
     *
     * @param newColor the new color
     */
    public void changePenColor(RGBColor newColor) {
        penColor = newColor;
    }

    /**
     * Changes the direction of the cursor
     *
     * @param newDirection the new direction
     */
    public void changeDirection(int newDirection) {
        direction = newDirection;
    }

    /**
     * Changes the position of the cursor
     *
     * @param newPosition the new position
     */
    public void changePosition(Point2D newPosition) {
        position = newPosition;
    }

    /**
     * Changes the value of the plot
     */
    public void changePlot() {
        plot = !plot;
    }
}