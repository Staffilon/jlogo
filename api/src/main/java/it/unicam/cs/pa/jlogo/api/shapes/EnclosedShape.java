package it.unicam.cs.pa.jlogo.api.shapes;

import it.unicam.cs.pa.jlogo.api.colors.RGBColor;
import it.unicam.cs.pa.jlogo.api.exceptions.IllegalShapeException;

import java.util.List;

/**
 * This interface represents enclosed shapes with their core methods
 *
 * @author Stanislav Teghipco
 */

public interface EnclosedShape extends Shape {
    /**
     * Returns the single stroke shapes that make up the enclosed shape
     *
     * @return the single stroke shapes that build the enclosed shapes
     */
    List<SingleStrokeShape> getComposingShapes();

    /**
     * Returns the color that fills the enclosed shape
     *
     * @return the RGBColor that fills the shape
     */
    RGBColor getFillColor();

    /**
     * Checks that the single shapes that make up the enclosed shapes are connected and that they aren't less than
     * required
     *
     * @param strokeShapes single stroke shapes that are going to build the enclosed shape
     * @return the single shapes if they have passed the conditions
     * @throws IllegalArgumentException throws this exception if the number of shapes is less than the minimum required number
     */
    default List<SingleStrokeShape> isEnclosedShape(List<SingleStrokeShape> strokeShapes) throws IllegalArgumentException {
        if (strokeShapes.size() < 3)
            throw new IllegalArgumentException("Illegal composing shapes number: " + strokeShapes.size() + "; they cannot be less than 3");
        areStartingAndEndPointConnected(strokeShapes);
        areComposingShapesConnected(strokeShapes);
        return strokeShapes;
    }

    /**
     * Checks that the starting and ending point of an enclosed shape are connected
     *
     * @param strokeShapes the shapes that are going to build the enclosed shape
     * @throws IllegalShapeException throws this exception if the starting and ending point of the shape aren't connected
     */
    default void areStartingAndEndPointConnected(List<SingleStrokeShape> strokeShapes) throws IllegalShapeException {
        if (!strokeShapes.get(0).getStartPoint().compareCoordinates(strokeShapes.get(strokeShapes.size() - 1).getEndPoint()))
            throw new IllegalShapeException("Illegal enclosed shape, starting point " + strokeShapes.get(0).getStartPoint().getLogoFormat()
                    + " doesn't have the same coordinates as ending point " + strokeShapes.get(strokeShapes.size() - 1).getEndPoint().getLogoFormat());
    }

    /**
     * Checks that the internal points of the shape are connected together
     *
     * @param strokeShapes the shapes composing the enclosed shape
     * @throws IllegalShapeException throws this exception if the internal points aren't connected
     */
    default void areComposingShapesConnected(List<SingleStrokeShape> strokeShapes) throws IllegalShapeException {
        for (int i = 0; i < strokeShapes.size() - 1; i++) {
            if (!strokeShapes.get(i).getEndPoint().compareCoordinates(strokeShapes.get(i + 1).getStartPoint()))
                throw new IllegalShapeException("Illegal enclosed shape, ending point " + strokeShapes.get(i).getEndPoint().getLogoFormat()
                        + " is not connected to the starting point of the next shape " + strokeShapes.get(i + 1).getStartPoint().getLogoFormat());
        }
    }
}