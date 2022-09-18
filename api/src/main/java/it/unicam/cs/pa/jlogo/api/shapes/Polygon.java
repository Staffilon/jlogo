package it.unicam.cs.pa.jlogo.api.shapes;

import it.unicam.cs.pa.jlogo.api.colors.RGBColor;
import it.unicam.cs.pa.jlogo.api.exceptions.IllegalShapeException;

import java.util.List;

public class Polygon implements EnclosedShape{
    List<SingleStrokeShape> composingShapes;
    RGBColor fillColor;

    public Polygon(List<SingleStrokeShape> composingShapes, RGBColor fillColor)  {
        this.composingShapes = isEnclosedShape(composingShapes);
        this.fillColor = fillColor;
    }


    @Override
    public List<SingleStrokeShape> getComposingShapes() {
        return composingShapes;
    }

    @Override
    public RGBColor getFillColor() {
        return fillColor;
    }

    @Override
    public String getLogoFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append("Polygon ").append(" ").append(composingShapes.size()).append(fillColor.getLogoFormat());

        for (SingleStrokeShape shape: composingShapes) {
            sb.append("\n").append(shape.getStartPoint().getLogoFormat())
                    .append(" ").append(shape.getColor().getLogoFormat())
                    .append(" ").append(shape.getSize());
        }

        return sb.toString();
    }
}
