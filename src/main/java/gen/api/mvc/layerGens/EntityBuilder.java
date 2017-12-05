package gen.api.mvc.layerGens;

import java.util.List;

import gen.api.mvc.builders.ClassBuilder;
import gen.api.mvc.builders.IBuilder;
import gen.api.mvc.builders.elements.ClassElement;
import gen.api.mvc.builders.elements.Field;
import gen.api.mvc.builders.elements.Modifiers;
import gen.api.mvc.builders.elements.Pkg;
import gen.api.mvc.exceptions.BuilderException;

public class EntityBuilder implements IBuilder<ClassElement> {
	
	private ClassElement entity;
	
	public static ClassElement getEntity(List<String> fieldsToBe, String name) throws BuilderException {
		String entityIdentifier = name + "Entity";
		ClassBuilder builder = ClassElement.builder();
		Pkg pkg = new Pkg();
        pkg.setName("crud.api.exploritage.entites");
        builder.addPackage(pkg);
		for(String fieldToBe : fieldsToBe) {
			Field field = Field.builder()
					.addIdentifier(fieldToBe)
					.addClassType(String.class)
					.addModifier(Modifiers.PRIVATE)
					.setGetter(true)
					.setSetter(true)
					.build();
			builder.addField(field);
		}
		ClassElement entityClass = builder
				.addIdentifier(entityIdentifier)
				.build();
		return entityClass;
	}

	@Override
	public ClassElement build() throws BuilderException {
		return null;
	}
}
