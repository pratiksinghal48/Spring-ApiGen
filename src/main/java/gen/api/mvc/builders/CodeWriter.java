package gen.api.mvc.builders;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JCodeModel;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JFieldVar;
import com.helger.jcodemodel.JMod;
import com.helger.jcodemodel.JPackage;

import gen.api.mvc.builders.elements.Field;
import gen.api.mvc.builders.elements.JavaFile;
import gen.api.mvc.builders.elements.Modifiers;
import gen.api.mvc.elements.BaseElements;
import gen.api.mvc.elements.ClassElements;

public class CodeWriter implements ICodeWriter {

	private JCodeModel model;

	@Override
	public void makeCode(JavaFile javaFile) {
		model = new JCodeModel();
		JPackage pkg = BaseElements.getPackage(model, javaFile.getClassElement().getPkg().getName());
		JDefinedClass cls = null;
		try {
			cls = BaseElements.getClass(pkg, javaFile.getClassElement().getIdentifier());
		} catch (JClassAlreadyExistsException e) {
		}
		List<Field> fields = javaFile.getClassElement().getFields();
		for(Field field : fields) {
			field.setFieldInstance(
					BaseElements.getField(cls, field.getIdentifier(), field.getElementClassType(),
							getModifier(field.getModifiers())));
		}
		for(Field field : fields) {
			if(field.isHaveGetter()) {
				ClassElements.getGetter(cls, (JFieldVar) field.getFieldInstance());
			}
			if(field.isHaveSetter()) {
				ClassElements.getSetter(cls, (JFieldVar) field.getFieldInstance());
			}
		}
	}

	@Override
	public void write(File file) throws IOException {
		model.build(file);
	}

	private int getModifier(Modifiers modifier) {
		switch(modifier) {
		case PRIVATE:
			return JMod.PRIVATE;
		case STATIC:
			return JMod.STATIC;
		case ABSTRACT:
			return JMod.ABSTRACT;
		case DEFAULT:
			return JMod.DEFAULT;
		case FINAL:
			return JMod.FINAL;
		case NATIVE:
			return JMod.NATIVE;
		case PROTECTED:
			return JMod.PROTECTED;
		case PUBLIC:
			return JMod.PUBLIC;
		case STRICTFP:
			return JMod.STRICTFP;
		case SYNCHRONIZED:
			return JMod.SYNCHRONIZED;
		case TRANSIENT:
			return JMod.TRANSIENT;
		case VOLATILE:
			return JMod.VOLATILE;
		default:
			return JMod.NONE;
		}
	}

	private int getModifier(List<Modifiers> modifiers) {
		int response = getModifier(Modifiers.NONE);
		for(Modifiers modifier : modifiers) {
			response = response | getModifier(modifier);
		}
		return response;
	}

}
