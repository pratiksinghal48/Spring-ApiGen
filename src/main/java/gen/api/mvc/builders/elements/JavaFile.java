package gen.api.mvc.builders.elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gen.api.mvc.builders.JavaFileBuilder;
import gen.api.mvc.codeWriter.ICodeWriter;

public class JavaFile {
	private List<ClassElement> classElement;
	private ICodeWriter codeWriter; 

	public JavaFile(ICodeWriter codeWriter) {
		this.codeWriter = codeWriter;
		init();
	}
	
	private void init() {
		classElement = new ArrayList<>();
	}

	public List<ClassElement> getClassElement() {
		return classElement;
	}

	public void setClassElement(List<ClassElement> classElement) {
		this.classElement = classElement;
	}

	public ICodeWriter getCodeWriter() {
		return codeWriter;
	}

	public void setCodeWriter(ICodeWriter codeWriter) {
		this.codeWriter = codeWriter;
	}

	public static JavaFileBuilder builder(ICodeWriter codeWriter) {
		return new JavaFileBuilder(new JavaFile(codeWriter));
	}
	
	public void write(File file) throws IOException {
		codeWriter.makeCode(this);
		codeWriter.write(file);
	}
}
