package gen.api.mvc.builders;

import java.util.ArrayList;

import org.springframework.util.StringUtils;

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

	public FieldBuilder addClassType(Class<?> classType) {
		this.fieldInstance.setElementClassType(classType);
		return this;
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
			throw new BuilderException(ExceptionMessages.IDENTIFIER_NOT_PRESENT);
		}
		if(fieldInstance.getElementClassType() == null) {
			throw new BuilderException(ExceptionMessages.CLASS_TYPE_NOT_PRESENT);
		}
	}

}
