package tp1.utils.textfiles;

import java.io.*;
import java.nio.file.*;

public class Adsads {

    public void asdf() {
        Path p = Paths.get(this.toString());

        System.out.println(p.toAbsolutePath().toString());
    }

    @Override
    public String toString() {
        return "Adsads{}";
    }

    public static void main(String[] args) {
        /*String line = null;

        BufferedReader buf = null;

        try {

            Path path = Paths.get(line);
            buf = new BufferedReader(new FileReader(path.toAbsolutePath().toString()));
        } catch (IOException e) {
            e.getMessage();
        }*/

        Adsads a = new Adsads();

        a.asdf();

    }
}
