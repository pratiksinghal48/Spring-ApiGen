package gen.api.mvc.builders.elements;

import java.util.List;

import gen.api.mvc.builders.impl.ClassBuilder;

public class ClassElement extends BaseElement {
	
	private List<FieldElement> fields;
	private List<MethodElement> methods;
	private List<AnnotationElement> annotations;

	public List<FieldElement> getFields() {
		return fields;
	}

	public void setFields(List<FieldElement> fields) {
		this.fields = fields;
	}

	public List<MethodElement> getMethods() {
		return methods;
	}

	public void setMethods(List<MethodElement> methods) {
		this.methods = methods;
	}

	public static ClassBuilder builder() {
		return new ClassBuilder(new ClassElement());
	}

	public List<AnnotationElement> getAnnotations() {
		return annotations;
	}

	public void setAnnotations(List<AnnotationElement> annotations) {
		this.annotations = annotations;
	}
}
