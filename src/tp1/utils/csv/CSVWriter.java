package tp1.utils.csv;

import tp1.utils.textfiles.*;

import java.util.List;

public abstract class CSVWriter<ClassType> {
    private static final String CSV_EXTENSION = ".csv";
    private String header;

    public CSVWriter(String line) {
        this.header = line;
    }

    public void writeAll(String line, List<ClassType> list) {

    }

    private void writeHeader(TextWriter tw) {
        tw.writeLine(header);
    }

    private void writeItems(TextWriter tw, List<ClassType> list) {
        for (ClassType item : list) {
            tw.writeLine(item.toString());
        }
    }
}
