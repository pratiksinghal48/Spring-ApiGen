package gen.api.mvc.builders.elements;

import java.util.Map;

import gen.api.mvc.builders.impl.AnnotationBuilder;

public class AnnotationElement {
	private Class<?> classType;
	private Map<String, String> params;
	
	public Class<?> getClassType() {
		return classType;
	}
	public void setClassType(Class<?> classType) {
		this.classType = classType;
	}
	public Map<String, String> getParams() {
		return params;
	}
	public void setParams(Map<String, String> params) {
		this.params = params;
	}
	
	public static AnnotationBuilder builder() {
		return new AnnotationBuilder(new AnnotationElement());
	}
	
}
