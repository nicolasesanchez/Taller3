package tp1.utils.textfiles;

public interface TextWriter {
	
	boolean isReady();
	
	void writeLine(String line);
	
	void close();

}
