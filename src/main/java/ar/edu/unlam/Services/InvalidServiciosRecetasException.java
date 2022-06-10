package ar.edu.unlam.Services;

public class InvalidServiciosRecetasException extends Exception{
    public InvalidServiciosRecetasException (String errorMessage) {
        super(errorMessage);
    }
}
