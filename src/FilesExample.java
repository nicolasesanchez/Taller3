import java.io.*;

public class FilesExample {
    public static void main(String args[]) throws IOException {
        File file = new File("/Users/nicsanchez/Downloads/hola.txt"); //instancia una ruta

        if (!file.exists()) {
            FileWriter a = new FileWriter(file);
            a.write("hola mundo");
            a.close();

            FileReader b = new FileReader(file);

            int c;
            while ((c = b.read()) != -1) {
                System.out.print((char) c);
            }

            b.close();
        }

    }
}
