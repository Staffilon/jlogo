package it.unicam.cs.pa.jlogo.api.exceptions;

/**
 * This class represents a custom exception used to handle illegal enclosed shapes
 *
 * @author Stanislav Teghipco
 */
public class IllegalShapeException extends RuntimeException{

    public IllegalShapeException(String errorMessage){
        super(errorMessage);
    }
}
