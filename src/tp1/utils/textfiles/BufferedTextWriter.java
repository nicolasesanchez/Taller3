package tp1.utils.textfiles;

import java.io.*;
import java.nio.file.*;

public class BufferedTextWriter implements TextWriter {
    private BufferedWriter buf;

    public BufferedTextWriter(String line) {
        try {
            Path path = Paths.get(line);
            buf = new BufferedWriter(new FileWriter(path.toString()));
        } catch (IOException e) {
            e.getMessage();
        }
    }

    @Override
    public boolean isReady() {
        return buf != null;
    }

    @Override
    public void writeLine(String line) {
        try {
            buf.write(line);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    @Override
    public void close() {
        try {
            buf.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

}
