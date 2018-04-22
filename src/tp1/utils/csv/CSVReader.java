package tp1.utils.csv;

import tp1.ej3.entidades.Articulo;
import tp1.utils.textfiles.*;

import java.util.List;

public abstract class CSVReader<ClassType> {
    private static final String CSV_EXTENSION = ".csv";
    private static final String INVALID_CSV_ERROR_MSG = "";
    private String header;

    public CSVReader(String line) {
        header = line;
    }

    public void readAll(String line, List<ClassType> list, ControlLevelError cle) {

    }

    protected abstract Articulo fromCSV(String line);

    private void readHeader(TextReader tr) {

    }

    private void readItems(TextReader tr, List<ClassType> list, ControlLevelError cle) {

    }

}
