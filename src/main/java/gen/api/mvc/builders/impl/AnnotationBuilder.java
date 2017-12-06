package gen.api.mvc.builders.impl;

import java.util.HashMap;

import org.springframework.util.CollectionUtils;

import gen.api.mvc.builders.IBuilder;
import gen.api.mvc.builders.elements.AnnotationElement;
import gen.api.mvc.exceptions.BuilderException;

public class AnnotationBuilder implements IBuilder<AnnotationElement> {
	
	private AnnotationElement annotationElement;

	public AnnotationBuilder(AnnotationElement annotationElement) {
		this.annotationElement = annotationElement;
		init();
	}
	
	public AnnotationBuilder addClassType(Class<?> classType) {
		this.annotationElement.setClassType(classType);
		return this;
	}
	
	public AnnotationBuilder addClassType(String key, String value) {
		this.annotationElement.getParams().put(key, value);
		return this;
	}

	private void init() {
		if(this.annotationElement == null) {
			this.annotationElement = new AnnotationElement();
		}
		if(CollectionUtils.isEmpty(this.annotationElement.getParams())) {
			this.annotationElement.setParams(new HashMap<>());
		}
	}

	@Override
	public AnnotationElement build() throws BuilderException {
		validate();
		return this.annotationElement;
	}

	private void validate() throws BuilderException {
	}

}
