package tp1.utils.textfiles;

import java.nio.file.*;

public class Program {

    public static void main(String[] args) {

        Path localPath = Paths.get("");
        Path programPath = Paths.get("/src/tp1/utils/textfiles/Program.java");
        Path savingPath = Paths.get("/src/tp1/utils/textfiles/Program.txt");

        String route = (localPath.toAbsolutePath().toString() + programPath.toString());
        String newFile = (localPath.toAbsolutePath().toString() + savingPath.toString());

        BufferedTextReader br = new BufferedTextReader(route);
        BufferedTextWriter bw = new BufferedTextWriter(newFile);

        if (br.isReady()) {
            String firstLine = br.readLine();

            if (firstLine != null && bw.isReady()) {
                bw.writeLine(firstLine);
            }
        }

        br.close();
        bw.close();

    }
}
