package gen.api.mvc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import gen.api.mvc.builders.elements.ClassElement;
import gen.api.mvc.builders.elements.Field;
import gen.api.mvc.builders.elements.JavaFile;
import gen.api.mvc.builders.elements.Modifiers;
import gen.api.mvc.builders.elements.PackageElement;
import gen.api.mvc.builders.impl.PackageBuilder;
import gen.api.mvc.codeWriter.ICodeWriter;
import gen.api.mvc.codeWriter.impl.CodeModelWriter;
import gen.api.mvc.layerBuilders.EntityBuilder;

public class App {
	public static void main(String[] args) throws Exception {
		
		
		List<String> fields = new ArrayList<>();
		fields.add("name");
		fields.add("address");
		fields.add("phoneNumber");
		ClassElement entity = EntityBuilder.getEntity(fields, "sample");
		
		Field field = Field.builder()
				.addIdentifier("sampleField")
				.addModifier(Modifiers.PRIVATE)
				.addClassType(entity)
				.setGetter(true)
				.setSetter(true)
				.build();
		ClassElement en = ClassElement.builder()
				.addIdentifier("anotherClass")
				.addField(field)
				.build();
		PackageBuilder entitiesPackageBuilder = PackageElement.builder().addName("api.exploritage.entites");
		entitiesPackageBuilder.addClass(entity);
		entitiesPackageBuilder.addClass(en);
		PackageBuilder mapperPackageBuilder = PackageElement.builder().addName("api.exploritage.mappers");
		Field f = Field.builder()
				.addIdentifier("entityField")
				.addModifier(Modifiers.PRIVATE)
				.addClassType(entity)
				.setGetter(true)
				.setSetter(true)
				.build();
		ClassElement e = ClassElement.builder()
				.addIdentifier("mapper")
				.addField(f)
				.build();
		mapperPackageBuilder.addClass(e);
		
		JavaFile javaFile = JavaFile.builder()
				.addPackage(entitiesPackageBuilder.build())
				.addPackage(mapperPackageBuilder.build())
				.build();
		
		ICodeWriter codeWriter = new CodeModelWriter(javaFile);
		codeWriter.makeCode();
		codeWriter.write(new File("/Users/pratik/codebase/workspace/"));
		
	}
}
