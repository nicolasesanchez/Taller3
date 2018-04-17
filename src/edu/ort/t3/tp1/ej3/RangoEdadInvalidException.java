package edu.ort.t3.tp1.ej3;

public class RangoEdadInvalidException extends Exception {

    public RangoEdadInvalidException(String message) {
        super(message);
    }

    public String getMessage(String name) {
        return name + super.getMessage();
    }

}
