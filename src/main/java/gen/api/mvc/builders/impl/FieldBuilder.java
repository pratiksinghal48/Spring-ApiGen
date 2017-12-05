package gen.api.mvc.builders.impl;

import java.util.ArrayList;

import org.springframework.util.StringUtils;

import gen.api.mvc.builders.IBuilder;
import gen.api.mvc.builders.elements.BaseElement;
import gen.api.mvc.builders.elements.ClassType;
import gen.api.mvc.builders.elements.Field;
import gen.api.mvc.builders.elements.Modifiers;
import gen.api.mvc.exceptions.BuilderException;
import gen.api.mvc.exceptions.ExceptionMessages;

public class FieldBuilder implements IBuilder<Field> {

	private Field fieldInstance;

	public FieldBuilder() {
		init();
	}

	public FieldBuilder(Field field) {
		this.fieldInstance = field;
		init();
	}

	private void init() {
		if(this.fieldInstance == null) {
			this.fieldInstance = new Field();
		}
		this.fieldInstance.setModifiers(new ArrayList<>());
	}

	public FieldBuilder addIdentifier(String identifier) {
		this.fieldInstance.setIdentifier(identifier);
		return this;
	}
	
	public FieldBuilder addClassType(ClassType classType) {
		this.fieldInstance.setClassType(classType);
		return this;
	}

	public FieldBuilder addClassType(BaseElement element) {
		return addClassType(new ClassType(element));
	}
	
	public FieldBuilder addClassType(Class<?> classType) {
		return addClassType(new ClassType(classType));
	}

	public FieldBuilder addModifier(Modifiers modifier) {
		this.fieldInstance.getModifiers().add(modifier);
		return this;
	}
	
	public FieldBuilder setGetter(boolean bool) {
		this.fieldInstance.setHaveGetter(bool);
		return this;
	}

	public FieldBuilder setSetter(boolean bool) {
		this.fieldInstance.setHaveSetter(bool);
		return this;
	}

	@Override
	public Field build() throws BuilderException {
		validate();
		return fieldInstance;
	}

	private void validate() throws BuilderException {
		if(StringUtils.isEmpty(fieldInstance.getIdentifier())) {
			throw new BuilderException(fieldInstance, ExceptionMessages.IDENTIFIER_NOT_PRESENT);
		}
		if(fieldInstance.getClassType() == null) {
			throw new BuilderException(fieldInstance, ExceptionMessages.CLASS_TYPE_NOT_PRESENT);
		}
	}

}
