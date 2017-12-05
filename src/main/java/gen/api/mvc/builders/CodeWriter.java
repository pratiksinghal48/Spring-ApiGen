package gen.api.mvc.builders;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JCodeModel;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JFieldVar;
import com.helger.jcodemodel.JPackage;

import gen.api.mvc.builders.elements.ClassElement;
import gen.api.mvc.builders.elements.Field;
import gen.api.mvc.builders.elements.JavaFile;
import gen.api.mvc.codeWriter.BaseElements;
import gen.api.mvc.codeWriter.ClassElements;
import gen.api.mvc.codeWriter.ICodeWriter;

public class CodeWriter implements ICodeWriter {

	private JCodeModel model;

	@Override
	public void makeCode(JavaFile javaFile) {
		model = new JCodeModel();
		for(ClassElement clsElement : javaFile.getClassElement()) {
			JPackage pkg = BaseElements.getPackage(model, clsElement.getPkg().getName());
			JDefinedClass cls = null;
			try {
				cls = BaseElements.getClass(pkg, clsElement);
				clsElement.setInstance(cls);
			} catch (JClassAlreadyExistsException e) {
			}
			List<Field> fields = clsElement.getFields();
			for(Field field : fields) {
				JFieldVar f = BaseElements.getField(cls, field);
				field.setInstance(f);
			}
			for(Field field : fields) {
				if(field.isHaveGetter()) {
					ClassElements.getGetter(cls, (JFieldVar) field.getInstance());
				}
				if(field.isHaveSetter()) {
					ClassElements.getSetter(cls, (JFieldVar) field.getInstance());
				}
			}
		}
	}

	@Override
	public void write(File file) throws IOException {
		model.build(file);
	}

}
