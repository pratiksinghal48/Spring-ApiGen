package gen.api.mvc.builders;

import gen.api.mvc.builders.elements.ClassElement;
import gen.api.mvc.builders.elements.JavaFile;
import gen.api.mvc.exceptions.BuilderException;
import gen.api.mvc.exceptions.ExceptionMessages;

public class JavaFileBuilder implements IBuilder<JavaFile>  {
	
	private JavaFile javaFile;
	
	public JavaFileBuilder(JavaFile javaFile) {
		this.javaFile = javaFile;
		init();
	}
	
	private void init() {
		if(this.javaFile == null) {
			this.javaFile = new JavaFile(new CodeWriter());
		}
	}
	
	public JavaFileBuilder addClass(ClassElement classElement) {
		javaFile.setClassElement(classElement);
		return this;
	}

	@Override
	public JavaFile build() throws BuilderException {
		validate();
		return javaFile;
	}

	private void validate()  throws BuilderException {
		if(javaFile.getClassElement() == null) {
			throw new BuilderException(ExceptionMessages.CLASS_ELEMENT_NOT_PRESENT);
		}
	}
	
}
