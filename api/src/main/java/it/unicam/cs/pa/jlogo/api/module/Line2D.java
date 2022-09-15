package it.unicam.cs.pa.jlogo.api.module;

/**
 * This class represents a bidimentional line in the area of the logo application
 *
 * @author Stanislav Teghipco
 */
public class Line2D implements Shape2D {

    private Point2D startPoint;
    private Point2D endPoint;
    private int size;

    /**
     * Creates a bidimensional line with the given parameters
     *
     * @param startPoint starting point of the line
     * @param endPoint   ending point of the line
     * @param size       size of the line (thickness)
     */
    public Line2D(Point2D startPoint, Point2D endPoint, int size) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.size = isSizeValid(size);
    }

    @Override
    public Point2D getStartPoint() {
        return startPoint;
    }

    @Override
    public Point2D getEndPoint() {
        return endPoint;
    }

    @Override
    public int getSize() {
        return size;
    }
}
