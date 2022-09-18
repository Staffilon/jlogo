package it.unicam.cs.pa.jlogo.api.colors;

/**
 * This interface is going to implemented in every color class, making it possible
 * for them to return their information in the logo format
 *
 * @author Stanislav Teghipco
 */

public interface Color {

    /**
     * Returns the information about the color in the logo format
     *
     * @return the string containing the information about the color
     */
    String getLogoFormat();
}
