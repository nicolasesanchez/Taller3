package tp1.ej3.entidades;

import tp1.utils.csv.CSVCompatible;

public class Articulo implements CSVCompatible {
    private static final String ERR_PRECIO_NEGATIVO = "El precio no puede ser negativo";
    private static final String ERR_STOCK_INSUFICIENTE = "Stock insuficiente";
    private static final String ERR_CANTIDAD_INVALIDA = "La cantidad debe ser mayor a 0";
    private static final String ERR_DESCRIPCION_VACIA= "La descripción no puede estar vacía";
    private static final String ERR_VALORES_INVALIDOS = "Valores inválidos";
    private static final String ERR_EN_DATO_RECIBIDO = "Error en un dato recibido: ";
    private static final String ERR_CANT_VALORES = "La cantidad de valores recibidos no coinciden con los esperados";
    private static final int CANT_ATRIBUTOS = 4;

    private String codigo;
    private String descripcion;
    private int stock;
    private double precio;

    public Articulo(String codigo, String descripcion, int stock, double precio) {

    }

    public Articulo(String algo){

    }

    private void setValues(String codigo, String desc, int stock, double precio) {

    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void incStock(int cant) {

    }

    public void decStock(int cant) {

    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toCSV() {
        return null;
    }
}
