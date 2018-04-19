package tp1.utils.textfiles;

public class Program {

    public static void main(String[] args) {
        String route = "/Users/nicsanchez/Downloads/hola.txt";

        BufferedTextReader br = new BufferedTextReader(route);

        BufferedTextWriter bw = new BufferedTextWriter(route);

        if (bw.isReady()) {
            bw.writeLine("hola mundo ahre\n");
            bw.writeLine("esto es otra linea");
            bw.close();
        }

        System.out.println(br.readLine());

        br.close();
    }
}
