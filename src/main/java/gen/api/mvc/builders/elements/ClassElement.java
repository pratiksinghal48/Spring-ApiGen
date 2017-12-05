package gen.api.mvc.builders.elements;

import java.util.List;

import gen.api.mvc.builders.impl.ClassBuilder;

public class ClassElement extends BaseElement {
	
	private List<Field> fields;
	private List<Method> methods;

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public List<Method> getMethods() {
		return methods;
	}

	public void setMethods(List<Method> methods) {
		this.methods = methods;
	}

	public static ClassBuilder builder() {
		return new ClassBuilder(new ClassElement());
	}
}
