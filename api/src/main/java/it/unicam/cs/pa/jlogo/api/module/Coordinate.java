package it.unicam.cs.pa.jlogo.api.module;

/**
 * This interface represents a coordinate in a bidimensional space;
 * the x coordinate represents the horizontal axis,
 * the y coordinate represents the vertical axis
 *
 * @author Stanislav Teghipco
 */
public interface Coordinate {

    /**
     * this attribute represents the tolerance taken in consideration when comparing two double values
     */
    double EPSILON = 0.000001d;

    /**
     * returns the value corresponding to the x coordinate
     *
     * @return x coordinate
     */
    double getX();

    /**
     * returns the value corresponding to the y coordinate
     *
     * @return y coordinate
     */
    double getY();

    /**
     * Returns the information of the coordinate in the logo format
     *
     * @return the string containing the information about the coordinate
     */
    String getLogoFormat();

    /**
     * Checks that another coordinate has the same position as the current coordinate
     *
     * @param otherCoordinate coordinate which we compare to the current one
     * @return true if they have the same position, false otherwise
     */
    default boolean compareCoordinates(Coordinate otherCoordinate) {
        return (Math.abs(getX() - otherCoordinate.getX()) < EPSILON) && (Math.abs(getY() - otherCoordinate.getY()) < EPSILON);
    }
}
