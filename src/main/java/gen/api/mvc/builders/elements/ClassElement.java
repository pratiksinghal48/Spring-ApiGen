package gen.api.mvc.builders.elements;

import java.util.List;

import gen.api.mvc.builders.ClassBuilder;

public class ClassElement extends BaseElement {
	
	private Pkg pkg;
	private List<Field> fields;
	private List<Method> methods;

	public Pkg getPkg() {
		return pkg;
	}

	public void setPkg(Pkg pkg) {
		this.pkg = pkg;
	}

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
