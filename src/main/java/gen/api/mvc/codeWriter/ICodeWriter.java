package gen.api.mvc.codeWriter;

import java.io.File;
import java.io.IOException;

import gen.api.mvc.builders.elements.JavaFile;

public interface ICodeWriter {
	public void makeCode(JavaFile javaFile);
	public void write(File file) throws IOException;
}