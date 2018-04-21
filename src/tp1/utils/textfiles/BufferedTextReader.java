package tp1.utils.textfiles;

import java.io.*;
import java.nio.file.*;

public class BufferedTextReader implements TextReader {
    private BufferedReader buf;

    public BufferedTextReader(String line) {
        try {

            Path path = Paths.get(new File(line).toString());
            buf = new BufferedReader(new FileReader(path.toString()));

        } catch (IOException e) {
            e.getMessage();
        }
    }

    @Override
    public boolean isReady() {
        return buf != null;
    }

    @Override
    public String readLine() {
        String line = null;
        try {
            line = buf.readLine();
        } catch (IOException e) {
            e.getMessage();
        }
        return line;
    }

    @Override
    public void close() {
        try {
            buf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
