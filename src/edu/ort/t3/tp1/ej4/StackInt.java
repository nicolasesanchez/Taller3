package edu.ort.t3.tp1.ej4;

public class StackInt {
    private int maximo; // tamaño máximo de la pila se recibe por constructor
    private int[] pila; // la pila de enteros
    private int tope; // número de elementos actualmente en la pila

    public StackInt(int max) {
        this.maximo = max;
        pila = new int[maximo];
    }

    public void push(int num) {
        boolean pushed = false;
        int index = 0;

        while (!pushed) {
            try {
                if (index >= this.maximo) throw new ExcepcionDesbordamiento("Excepción desbordamiento");

                if (pila[index] == 0) {
                    pila[index] = num;
                    pushed = true;

                } else {
                    index++;
                }
            } catch (ExcepcionDesbordamiento e) {
                System.err.println(e.getMessage());
                break;
            }
        }
    }

    public int pop() {
        boolean poped = false;
        int index = 1;
        int num = 0;

        if (!this.isEmpty()) {
            while (!poped) {
                if (pila[this.maximo - index] != 0) {
                    num = pila[this.maximo - index];
                    poped = true;
                    pila[this.maximo - index] = 0;
                } else {
                    index++;
                }
            }
        }

        return num;
    }

    private boolean isEmpty() {
        int index = 0;

        while (index < this.maximo) {
            if (pila[index] == 0) {
                index++;
            } else {
                break;
            }
        }

        return index == this.maximo;
    }

    public static void main(String[] args) {
        StackInt pila = new StackInt(4);

        pila.push(2);
        pila.push(6);
        pila.push(2);
        pila.push(1);
        pila.pop();
        pila.push(9);
        pila.push(32);


    }

}


