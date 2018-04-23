package tp1.ej3.entidades;

import tp1.utils.csv.CSVReader;

public class ArticuloReader extends CSVReader {

    public ArticuloReader() {
        super("?");
    }

    @Override
    protected Articulo fromCSV(String line) {
        return new Articulo(line);
    }
}
