package it.unicam.cs.pa.jlogo.api.module;

import it.unicam.cs.pa.jlogo.api.colors.RGBColor;
import it.unicam.cs.pa.jlogo.api.shapes.SingleStrokeShape;

import java.util.List;

/**
 * This interface is used to represent the core features of a drawable area of a logo application
 *
 * @author Stanislav Teghipco
 */
public interface DrawableArea {

    /**
     * Returns the color of the area
     *
     * @return the color of the area
     */
    RGBColor getAreaColor();

    /**
     * Returns the width of the area
     *
     * @return the width of the area
     */
    double getAreaWidth();

    /**
     * Returns the height of the area
     *
     * @return the height of the area
     */
    double getAreaHeight();

    /**
     * Returns all the shapes present in the area
     *
     * @return all the shapes present in the area
     */
    List<SingleStrokeShape> getDrawnShapes();

    /**
     * Adds a shape to the list of shapes drawn on the area
     *
     * @param newShape the shape to be added
     */
    void drawShape(SingleStrokeShape newShape);
}
