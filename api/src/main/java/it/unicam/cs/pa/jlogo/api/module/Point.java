package it.unicam.cs.pa.jlogo.api.module;

/**
 * This class represents a point on the bidimensional area in which the user will be able to draw
 *
 * @author Stanislav Teghipco
 */

public class Point implements Coordinate {

    /**
     * the x and y attributes are used to represent the coordinate of the point in the bidimensional area
     */

    private double x;
    private double y;

    /**
     * Creates a point with the given axis values
     *
     * @param x is the value of the horizontal axis
     * @param y is the value of the vertical axis
     */

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Creates a point without given values, with default coordinates
     */
    public Point() {
        this.x = 0d;
        this.y = 0d;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public String getLogoFormat() {
        String logoFormat = x + " " + y;

        return logoFormat;
    }
}
