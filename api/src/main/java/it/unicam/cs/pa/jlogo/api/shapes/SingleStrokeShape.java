package it.unicam.cs.pa.jlogo.api.shapes;

import it.unicam.cs.pa.jlogo.api.colors.RGBColor;
import it.unicam.cs.pa.jlogo.api.module.Point;

/**
 * This interface represents a bidimensional shape
 *
 * @author Stanislav Teghipco
 */
public interface SingleStrokeShape extends Shape {
    /**
     * This method returns the starting point of the shape
     *
     * @return the point in which the shape starts
     */
    Point getStartPoint();

    /**
     * This method returns the ending point of the shape
     *
     * @return the point in which the shape ends
     */
    Point getEndPoint();

    /**
     * This method returns the size of the shape
     *
     * @return the value of the size
     */
    int getSize();

    /**
     * This method returns the color of the shape
     * @return the RGBColor representing the color of the shape
     */
    RGBColor getColor();

    /**
     * Checks whether the given size is valid, in affirmative case it returns it,
     * otherwise it throws an IllegalArgumentException
     *
     * @param size size that is going to be checked
     * @return returns the checked size
     * @throws IllegalArgumentException exception thrown if the size is not valid
     */
    default int isSizeValid(int size) throws IllegalArgumentException {
        if (size < 1)
            throw new IllegalArgumentException("Invalid line size: " + size + "; size should be bigger than 0");
        return size;
    }
}
