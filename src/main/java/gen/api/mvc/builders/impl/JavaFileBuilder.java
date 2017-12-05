package gen.api.mvc.builders.impl;

import java.util.ArrayList;

import org.springframework.util.CollectionUtils;

import gen.api.mvc.builders.IBuilder;
import gen.api.mvc.builders.elements.JavaFile;
import gen.api.mvc.builders.elements.PackageElement;
import gen.api.mvc.exceptions.BuilderException;
import gen.api.mvc.exceptions.ExceptionMessages;

public class JavaFileBuilder implements IBuilder<JavaFile> {

	private JavaFile javaFile;

	public JavaFileBuilder(JavaFile javaFile) {
		this.javaFile = javaFile;
		init();
	}

	private void init() {
		if(this.javaFile == null) {
			this.javaFile = new JavaFile();
		}
		this.javaFile.setPackageElement(new ArrayList<>());
	}

	public JavaFileBuilder addPackage(PackageElement packageElement) {
		javaFile.getPackageElement().add(packageElement);
		return this;
	}

	@Override
	public JavaFile build() throws BuilderException {
		validate();
		return javaFile;
	}

	private void validate() throws BuilderException {
		if(CollectionUtils.isEmpty(javaFile.getPackageElement())) {
			throw new BuilderException(ExceptionMessages.PACKAGE_NOT_PRESENT);
		}
	}

}
