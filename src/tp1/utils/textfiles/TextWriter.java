package tp1.utils.textfiles;

public interface TextWriter {
	
	public boolean isReady();
	
	public void writeLine(String line);
	
	public void close();

}
