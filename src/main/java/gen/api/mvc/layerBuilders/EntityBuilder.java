package gen.api.mvc.layerBuilders;

import java.util.Date;

import gen.api.mvc.builders.IBuilder;
import gen.api.mvc.builders.elements.ClassElement;
import gen.api.mvc.builders.elements.Field;
import gen.api.mvc.builders.elements.Modifiers;
import gen.api.mvc.builders.impl.ClassBuilder;
import gen.api.mvc.exceptions.BuilderException;

public class EntityBuilder implements IBuilder<ClassElement> {

	private ClassBuilder builder;
	private String ENTITY_IDENTIFIER = "Entity";
	private Boolean ifIdField;
	private Boolean ifCreatedField;
	private Boolean ifUpdateField;

	public EntityBuilder() {
		init();
	}

	private void init() {
		if(builder == null) {
			builder = ClassElement.builder();
		}
	}

	public EntityBuilder addIdentifier(String identifier) {
		builder.addIdentifier(identifier + ENTITY_IDENTIFIER);
		return this;
	}

	public EntityBuilder addField(Field field) {
		builder.addField(field);
		return this;
	}

	public EntityBuilder addField(Class<?> classType, String identifier) {
		builder.addField(getField(classType, identifier));
		return this;
	}
	
	public void setIfIdField(boolean idField) {
		this.ifIdField = idField;
	}

	public void setIfCreatedField(boolean createdField) {
		this.ifCreatedField = createdField;
	}

	public void setIfUpdateField(boolean updateField) {
		this.ifUpdateField = updateField;
	}

	@Override
	public ClassElement build() throws BuilderException {
		validate();
		if(ifIdField == null || ifIdField) {
			builder.addField(getField(int.class, "id"));
		}
		if(ifCreatedField == null || ifCreatedField) {
			builder.addField(getField(Date.class, "created"));
		}
		if(ifUpdateField == null || ifUpdateField) {
			builder.addField(getField(Date.class, "updated"));
		}
		return builder.build();
	}

	private void validate() throws BuilderException {

	}

	private Field getField(Class<?> classType, String identifier) {
		try {
			return Field.builder()
					.addIdentifier(identifier)
					.addClassType(classType)
					.addModifier(Modifiers.PRIVATE)
					.setGetter(true)
					.setSetter(true)
					.build();
		} catch (BuilderException e) {
		}
		return null;
	}

}
