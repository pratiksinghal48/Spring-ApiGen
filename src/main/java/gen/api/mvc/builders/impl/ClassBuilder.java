package gen.api.mvc.builders.impl;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import gen.api.mvc.builders.IBuilder;
import gen.api.mvc.builders.consts.Modifiers;
import gen.api.mvc.builders.elements.AnnotationElement;
import gen.api.mvc.builders.elements.ClassElement;
import gen.api.mvc.builders.elements.FieldElement;
import gen.api.mvc.exceptions.BuilderException;
import gen.api.mvc.exceptions.ExceptionMessages;

public class ClassBuilder implements IBuilder<ClassElement> {

	private ClassElement classElement;

	public ClassBuilder() {
		init();
	}
	
	public ClassBuilder(ClassElement classElement) {
		this.classElement = classElement;
		init();
	}

	private void init() {
		if(this.classElement == null) {
			this.classElement = new ClassElement();
		}
		classElement.setModifiers(new ArrayList<>());
		classElement.setFields(new ArrayList<>());
		classElement.setMethods(new ArrayList<>());
		classElement.setAnnotations(new ArrayList<>());
	}
	
	public ClassBuilder addIdentifier(String identifier) {
		classElement.setIdentifier(identifier);
		return this;
	}

	public ClassBuilder addField(FieldElement field) {
		classElement.getFields().add(field);
		return this;
	}

	public ClassBuilder addField(String identifier, Class<?> fieldType, Modifiers modifiers) throws BuilderException {
		FieldElement field = FieldElement.builder()
				.addIdentifier(identifier)
				.addClassType(fieldType)
				.addModifier(modifiers)
				.build();
		return addField(field);
	}

	public ClassBuilder addField(String identifier, Class<?> fieldType, Modifiers modifiers, boolean haveGetter,
			boolean haveSetter) throws BuilderException {
		FieldElement field = FieldElement.builder()
				.addIdentifier(identifier)
				.addClassType(fieldType)
				.addModifier(modifiers)
				.setGetter(haveGetter)
				.setSetter(haveSetter)
				.build();
		return addField(field);
	}
	
	public ClassBuilder addAnnotation(AnnotationElement tableAnnotation) {
		this.classElement.getAnnotations().add(tableAnnotation);
		return this;
	}
	
	public ClassBuilder addAnnotation(Class<? extends Annotation> classType) throws BuilderException {
		AnnotationElement annotationElement = AnnotationElement.builder().addClassType(classType).build();
		return addAnnotation(annotationElement);
	}

	@Override
	public ClassElement build() throws BuilderException{
		validate();
		if(CollectionUtils.isEmpty(classElement.getModifiers())) {
			classElement.getModifiers().add(Modifiers.PUBLIC);
		}
		return classElement;
	}

	private void validate() throws BuilderException {
		if(StringUtils.isEmpty(classElement.getIdentifier())) {
			throw new BuilderException(classElement, ExceptionMessages.IDENTIFIER_NOT_PRESENT);
		}
	}

}
