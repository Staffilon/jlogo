package it.unicam.cs.pa.jlogo.api.module;

import it.unicam.cs.pa.jlogo.api.colors.RGBColor;
import it.unicam.cs.pa.jlogo.api.colors.RGBColorLogo;
import it.unicam.cs.pa.jlogo.api.shapes.SingleStrokeShape;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used to represent an area which can be used to draw onto, used by the logo application
 *
 * @author Stanislav Teghipco
 */
public class DrawableAreaLogo implements DrawableArea {

    private RGBColor color;
    private double height;
    private double width;

    /**
     * It's the default position of the cursor when starting the application
     */
    private Point homePosition;

    /**
     * Contains all the shapes drawn on the area
     */
    private List<SingleStrokeShape> shapes;

    /**
     * Cursor that will be used to carry out instructions
     */
    private CursorLogo cursor;

    /**
     * Builds an area with default values
     *
     * @param height the height of the area
     * @param width  the width of the area
     * @throws IllegalArgumentException throws this exception when height and/or width are negative
     */
    public DrawableAreaLogo(double height, double width) throws IllegalArgumentException{
        if(height < 0 || width < 0)
            throw new IllegalArgumentException("Illegal height and/or width of the drawing area, they should not be negative!");
        this.height = height;
        this.width = width;
        this.homePosition = new Point(height / 2, width / 2);
        this.color = new RGBColorLogo(255, 255, 255);
        this.shapes = new ArrayList<>();
    }

    @Override
    public RGBColor getAreaColor() {
        return color;
    }

    @Override
    public double getAreaWidth() {
        return width;
    }

    @Override
    public double getAreaHeight() {
        return height;
    }

    @Override
    public List<SingleStrokeShape> getDrawnShapes() {
        return shapes;
    }

    @Override
    public void drawShape(SingleStrokeShape newShape) {
        shapes.add(newShape);
    }

    public Point getHomePosition() {
        return homePosition;
    }

    public CursorLogo getCursor(){
        return cursor;
    }

    public void moveCursorBy(double distance){

        //calcola nuovo punto
        //crea linea
        //assegna nuova posizione al cursore
        //assegna nuova shape all'area
    }
}