package gen.api.mvc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import gen.api.mvc.builders.elements.ClassElement;
import gen.api.mvc.builders.elements.Field;
import gen.api.mvc.builders.elements.JavaFile;
import gen.api.mvc.builders.elements.Modifiers;
import gen.api.mvc.builders.elements.Pkg;
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
		
		Pkg pkg = new Pkg();
		pkg.setName("crud.api.exploritage.entites");
		Field field = Field.builder()
				.addIdentifier("sampleField")
				.addModifier(Modifiers.PRIVATE)
				.addClassType(entity)
				.setGetter(true)
				.setSetter(true)
				.build();
		ClassElement en = ClassElement.builder()
				.addPackage(pkg)
				.addIdentifier("anotherClass")
				.addField(field)
				.build();
		
		JavaFile javaFile = JavaFile.builder()
				.addClass(entity)
				.addClass(en)
				.build();
		
		ICodeWriter codeWriter = new CodeModelWriter(javaFile);
		codeWriter.makeCode();
		codeWriter.write(new File("/Users/pratik/codebase/workspace/"));
		
	}
}
