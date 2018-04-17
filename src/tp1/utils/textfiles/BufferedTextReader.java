package tp1.utils.textfiles;

import java.io.*;
import java.nio.file.*;

public class BufferedTextReader implements TextReader {
	private BufferedReader buf;
	
	public BufferedTextReader(String route) {
		try {
			route = Paths.get(route).toString();
			buf = new BufferedReader(new FileReader(route));
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
		try {
			buf.readLine();
		} catch (IOException e) {
		}
		return null;
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
