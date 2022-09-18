package it.unicam.cs.pa.jlogo.api.shapes;

import it.unicam.cs.pa.jlogo.api.colors.RGBColor;
import it.unicam.cs.pa.jlogo.api.module.Point;

/**
 * This class represents a bidimentional line in the area of the logo application
 *
 * @author Stanislav Teghipco
 */
public class Line implements SingleStrokeShape {

    private Point startPoint;
    private Point endPoint;
    private int size;
    private RGBColor color;

    /**
     * Creates a bidimensional line with the given parameters
     *
     * @param startPoint starting point of the line
     * @param endPoint   ending point of the line
     * @param size       size of the line (thickness)
     * @param color
     */
    public Line(Point startPoint, Point endPoint, int size, RGBColor color) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.size = isSizeValid(size);
        this.color = color;
    }

    @Override
    public Point getStartPoint() {
        return startPoint;
    }

    @Override
    public Point getEndPoint() {
        return endPoint;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public RGBColor getColor() {
        return color;
    }

    @Override
    public String getLogoFormat() {
        String logoFormat;
        logoFormat = "LINE"
                + " " + startPoint.getLogoFormat()
                + " " + endPoint.getLogoFormat()
                + " " + color.getLogoFormat()
                + " " + size;
        return logoFormat;
    }
}