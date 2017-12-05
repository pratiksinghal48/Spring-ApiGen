package gen.api.mvc.codeWriter.impl;

import java.io.File;
import java.io.IOException;

import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JCodeModel;
import com.helger.jcodemodel.JPackage;

import gen.api.mvc.builders.elements.ClassElement;
import gen.api.mvc.builders.elements.JavaFile;
import gen.api.mvc.builders.elements.PackageElement;
import gen.api.mvc.codeWriter.ICodeWriter;

public class CodeModelWriter implements ICodeWriter {
	
	private JCodeModel model;
	private JavaFile javaFile;
	
	public CodeModelWriter(JavaFile javaFile) {
		this.javaFile = javaFile;
	}

	@Override
	public void makeCode() {
		model = new JCodeModel();
		for(PackageElement packageElement : javaFile.getPackageElement()) {
			JPackage pkg = BaseElements.getPackage(model, packageElement.getIdentifier());
			for(ClassElement clsElement : packageElement.getClassElements()) {
				try {
					ElementsWriter.writeClass(pkg, clsElement);
				} catch (JClassAlreadyExistsException e) {
					// TODO throw exception here
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void write(File file) throws IOException {
		model.build(file);
	}

}
