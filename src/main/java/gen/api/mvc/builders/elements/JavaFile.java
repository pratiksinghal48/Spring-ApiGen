package gen.api.mvc.builders.elements;

import java.util.ArrayList;
import java.util.List;

import gen.api.mvc.builders.impl.JavaFileBuilder;

public class JavaFile {
	private List<ClassElement> classElement;
	public JavaFile() {
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

	public static JavaFileBuilder builder() {
		return new JavaFileBuilder(new JavaFile());
	}
	
}