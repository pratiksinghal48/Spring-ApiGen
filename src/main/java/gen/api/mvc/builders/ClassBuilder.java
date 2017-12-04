package gen.api.mvc.builders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import gen.api.mvc.builders.elements.ClassElement;
import gen.api.mvc.builders.elements.Field;
import gen.api.mvc.builders.elements.Modifiers;
import gen.api.mvc.builders.elements.Pkg;
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
		classElement.setFields(new ArrayList<>());
		classElement.setMethods(new ArrayList<>());
	}
	
	public ClassBuilder addPackage(Pkg pkg) {
		classElement.setPkg(pkg);
		return this;
	}
	
	public ClassBuilder addIdentifier(String identifier) {
		classElement.setIdentifier(identifier);
		return this;
	}

	public ClassBuilder addField(Field field) {
		classElement.getFields().add(field);
		return this;
	}

	public ClassBuilder addField(List<Field> fields) {
		fields.addAll(fields);
		return this;
	}

	public ClassBuilder addField(String identifier, Class<?> fieldType, Modifiers modifiers) throws BuilderException {
		Field field = Field.builder()
				.addIdentifier(identifier)
				.addClassType(fieldType)
				.addModifier(modifiers)
				.build();
		return addField(field);
	}

	public ClassBuilder addField(String identifier, Class<?> fieldType, Modifiers modifiers, boolean haveGetter,
			boolean haveSetter) throws BuilderException {
		Field field = Field.builder()
				.addIdentifier(identifier)
				.addClassType(fieldType)
				.addModifier(modifiers)
				.setGetter(haveGetter)
				.setSetter(haveSetter)
				.build();
		return addField(field);
	}

//	public ClassBuilder addMethod(Method method) {
//		methods.add(method);
//		return this;
//	}
//
//	public ClassBuilder addMethod(String identifier, Class<?> fieldType, int modifiers) {
//		return addMethod(new Method(identifier, fieldType, modifiers));
//	}
	
	@Override
	public ClassElement build() throws BuilderException{
		validate();
		return classElement;
	}

	private void validate() throws BuilderException {
		if(classElement.getPkg() == null) {
			throw new BuilderException(ExceptionMessages.PACKAGE_NOT_PRESENT);
		}
		if(StringUtils.isEmpty(classElement.getIdentifier())) {
			throw new BuilderException(ExceptionMessages.IDENTIFIER_NOT_PRESENT);
		}
	}

}
