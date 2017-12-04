package gen.api.mvc.builders.elements;

import java.io.File;
import java.io.IOException;

import gen.api.mvc.builders.ICodeWriter;
import gen.api.mvc.builders.JavaFileBuilder;

public class JavaFile {
	private ClassElement classElement;
	private ICodeWriter codeWriter; 

	public JavaFile(ICodeWriter codeWriter) {
		this.codeWriter = codeWriter;
	}

	public ClassElement getClassElement() {
		return classElement;
	}

	public void setClassElement(ClassElement classElement) {
		this.classElement = classElement;
	}
	
	public static JavaFileBuilder builder(ICodeWriter codeWriter) {
		return new JavaFileBuilder(new JavaFile(codeWriter));
	}
	
	public void write(File file) throws IOException {
		codeWriter.makeCode(this);
		codeWriter.write(file);
	}
}
