package edu.ort.t3.tp1.ej1;

public class TP1Test1 {

    static int contador = 0;

    public static void main(String[] args) throws Exception {
        while (true) {
            try { // El post-incremento es cero la primera vez:
                if (contador++ == 0) throw new Exception();
                System.out.println("Sin captura de excepcion");
            } catch (Exception e) {
                System.err.println("Excepcion capturada");
            } finally {
                System.err.println("Inicio de clausula finally");
                if (contador == 2) break; // ...
            }
        }
    }

}
