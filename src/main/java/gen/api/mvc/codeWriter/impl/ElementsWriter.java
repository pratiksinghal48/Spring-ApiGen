package gen.api.mvc.codeWriter.impl;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JFieldVar;
import com.helger.jcodemodel.JPackage;

import gen.api.mvc.builders.elements.ClassElement;
import gen.api.mvc.builders.elements.Field;

public class ElementsWriter {
	public static JDefinedClass writeClass(JPackage pkg, ClassElement clsElement) throws JClassAlreadyExistsException {
		JDefinedClass cls = BaseElements.getClass(pkg, clsElement);
		List<Field> fields = clsElement.getFields();
		if(!CollectionUtils.isEmpty(fields)) {
			for(Field field : fields) {
				BaseElements.getField(cls, field);
			}
			for(Field field : fields) {
				if(field.isHaveGetter()) {
					Snippets.getGetter(cls, (JFieldVar) field.getInstance());
				}
				if(field.isHaveSetter()) {
					Snippets.getSetter(cls, (JFieldVar) field.getInstance());
				}
			}
		}
		return cls;
	}
	
	
}
