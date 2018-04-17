package edu.ort.t3.tp1.ej2;

public class Empleado {
    private String nombre;
    private int edad;
    private static final int EDAD_MINIMA = 18;
    private static final int EDAD_MAXIMA = 65;

    public Empleado(String nombre, int edad) {
        try {
            if (nombre == null || (edad < EDAD_MINIMA || edad > EDAD_MAXIMA)) throw new IllegalArgumentException("Uno o varios argumentos son invalidos");

            this.nombre = nombre;
            this.edad = edad;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

}
