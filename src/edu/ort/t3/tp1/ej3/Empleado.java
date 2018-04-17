package edu.ort.t3.tp1.ej3;

public class Empleado {
    private String nombre;
    private int edad;
    private static final int EDAD_MINIMA = 18;
    private static final int EDAD_MAXIMA = 65;

    //Jose es menor de edad no puede trabajar, ingrese edad mayor de 18
    //Pedro es jubilado no puede trabajar, ingrese edad menor de 65
    //el nombre no puede ser nulo

    public Empleado(String nombre, int edad) {
        try {
            if (nombre == null) throw new IllegalArgumentException("El nombre no puede ser null");

            if (edad < EDAD_MINIMA || edad > EDAD_MAXIMA)
                throw new RangoEdadInvalidException("no puede trabajar porque es menor de edad o es jubilado");

            this.nombre = nombre;
            this.edad = edad;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (RangoEdadInvalidException e) {
            System.err.println(e.getMessage(nombre + " "));
        }
    }

}
