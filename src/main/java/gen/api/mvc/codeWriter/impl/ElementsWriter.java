package gen.api.mvc.codeWriter.impl;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.helger.jcodemodel.JAnnotationUse;
import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JFieldVar;
import com.helger.jcodemodel.JPackage;

import gen.api.mvc.builders.elements.AnnotationElement;
import gen.api.mvc.builders.elements.ClassElement;
import gen.api.mvc.builders.elements.FieldElement;

public class ElementsWriter {
	@SuppressWarnings("unchecked")
	public static JDefinedClass writeClass(JPackage pkg, ClassElement clsElement) throws JClassAlreadyExistsException {
		JDefinedClass cls = BaseElements.getClass(pkg, clsElement);
		List<FieldElement> fields = clsElement.getFields();
		if(!CollectionUtils.isEmpty(fields)) {
			for(FieldElement field : fields) {
				BaseElements.getField(cls, field);
			}
			for(FieldElement field : fields) {
				if(field.isHaveGetter()) {
					Snippets.getGetter(cls, (JFieldVar) field.getInstance());
				}
				if(field.isHaveSetter()) {
					Snippets.getSetter(cls, (JFieldVar) field.getInstance());
				}
			}
		}
		if(!CollectionUtils.isEmpty(clsElement.getAnnotations())) {
			for(AnnotationElement annotationElement : clsElement.getAnnotations()) {
				JAnnotationUse annotation = cls.annotate((Class<? extends Annotation>) annotationElement.getClassType());
				if(!CollectionUtils.isEmpty(annotationElement.getParams())) {
					for (Map.Entry<String, String> entry : annotationElement.getParams().entrySet()) {
						annotation.param(entry.getKey(), entry.getValue());
					}
				}
			}
		}
		return cls;
	}
	
	
}
