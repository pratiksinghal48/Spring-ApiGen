package gen.api.mvc.codeWriter;

import java.io.File;
import java.io.IOException;

public interface ICodeWriter {
	public void makeCode();
	public void write(File file) throws IOException;
}