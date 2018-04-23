package tp1.utils.csv;

import tp1.ej3.entidades.Articulo;
import tp1.utils.textfiles.*;

import java.util.List;

public abstract class CSVReader<ClassType> {
    private static final String CSV_EXTENSION = ".csv";
    private static final String INVALID_CSV_ERROR_MSG = "invalid csv";
    private String header;

    public CSVReader(String line) {
        header = line;
    }

    public void readAll(String line, List<ClassType> list, ControlLevelError cle) {
        line += CSV_EXTENSION;
        TextReader tr = new BufferedTextReader(line);
        if (tr.isReady() && !list.isEmpty()) {
            readHeader(tr);
            readItems(tr, list, cle);
            tr.close();
        }

    }

    protected abstract ClassType fromCSV(String line);

    private void readHeader(TextReader tr) {
        tr.readLine();
    }

    private void readItems(TextReader tr, List<ClassType> list, ControlLevelError cle) {
        String line = tr.readLine();
        while (line != null) {
            list.add(fromCSV(line));
            line = tr.readLine();
        }
    }

}
