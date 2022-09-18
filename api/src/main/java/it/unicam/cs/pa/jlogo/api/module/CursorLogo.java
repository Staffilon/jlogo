package it.unicam.cs.pa.jlogo.api.module;

import it.unicam.cs.pa.jlogo.api.colors.RGBColor;
import it.unicam.cs.pa.jlogo.api.colors.RGBColorLogo;

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
    private Point position;

    /**
     * Builds the cursor with the default values
     *
     * @param home the position at the center of the area
     */
    public CursorLogo(Point home) {
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
    public Point getPosition() {
        return position;
    }

    @Override
    public int getDirection() {
        return direction;
    }

    /**
     * Changes the size of the next shapes the cursor will be used to draw
     *
     * @param size the new size of the cursor
     * @throws IllegalArgumentException it throws an exception when the input size
     *                                  is less than 1
     */
    public void changePenSize(int size) throws IllegalArgumentException {
        if (size < 1)
            throw new IllegalArgumentException("Illegal cursor pen size: " + size + "; the should be more than 0");
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
     * @param additionalAngle the angle that needs to be added to the direction
     * @throws IllegalArgumentException the exception thrown in the case that the new angle is now within bounds
     */
    public void changeDirection(int additionalAngle) throws IllegalArgumentException {
        if (additionalAngle < -360 || additionalAngle > 360)
            throw new IllegalArgumentException("Illegal change of direction: " + additionalAngle + "; the angle should be in the [0;360] bounds!");
        direction += additionalAngle;
        evaluateNewDirection();
    }

    /**
     * modifies the value of the direction in case it's not within bounds
     */
    private void evaluateNewDirection() {
        if (Math.abs(direction) > 360)
            direction %= 360;
        if (direction < 0)
            direction += 360;
    }

    /**
     * Changes the position of the cursor
     *
     * @param newPosition the new position
     */
    public void changePosition(Point newPosition) {
        position = newPosition;
    }

    /**
     * Changes the value of the plot
     */
    public void changePlot() {
        plot = !plot;
    }
}