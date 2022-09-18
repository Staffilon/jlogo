package it.unicam.cs.pa.jlogo.api.shapes;

/**
 * This interface is going to be implemented in every shape that can be represented
 * in the logo application. It's use is to enable shapes to be able to give an output
 * of themselves, respecting the open closed principle in the long run, but risking to
 * break the SRP.
 *
 * @author Stanislav Teghipco
 */
public interface Shape {

    /**
     * Gives as an output the data of the shape in a logo friendly format
     * @return the string representing the data of the shape
     */
    String getLogoFormat();
}