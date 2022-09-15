package it.unicam.cs.pa.jlogo.api.color;

/**
 * This interface is going to be implemented in every type of color class
 *
 * @author Stanislav Teghipco
 */

public interface RGBColor {

    /**
     * Return the red byte of the color
     *
     * @return the red byte of the color
     */
    int getRedByte();

    /**
     * Return the green byte of the color
     *
     * @return the green byte of the color
     */
    int getGreenByte();

    /**
     * Return the blue byte of the color
     *
     * @return the blue byte of the color
     */
    int getBlueByte();

    /**
     * Checks whether the given byte value is within bounds or not. It throws an exceptions if it isn't
     *
     * @param colorByte the byte that is going to be assigned one of the three colors
     * @return the byte, if it's within bounds
     * @throws IllegalArgumentException if the byte isn't withing bounds
     */
    default int isWithinBounds(int colorByte) throws IllegalArgumentException {
        if (colorByte < 0 || colorByte > 255)
            throw new IllegalArgumentException("Incorrect value (" + colorByte + ") given for a color byte! It must be between [0;255] bounds");
        return colorByte;
    }
}
