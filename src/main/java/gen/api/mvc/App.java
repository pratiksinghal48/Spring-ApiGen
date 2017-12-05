package gen.api.mvc;

import java.io.File;

import gen.api.mvc.builders.elements.ClassElement;
import gen.api.mvc.builders.elements.JavaFile;
import gen.api.mvc.builders.elements.PackageElement;
import gen.api.mvc.builders.impl.PackageBuilder;
import gen.api.mvc.codeWriter.ICodeWriter;
import gen.api.mvc.codeWriter.impl.CodeModelWriter;
import gen.api.mvc.layerBuilders.LayerBuilder;

public class App {
	public static void main(String[] args) throws Exception {
		
		ClassElement entity = LayerBuilder.entityBuilder()
				.addIdentifier("destination")
				.addField(String.class, "name")
				.addField(String.class, "address")
				.addField(String.class, "phoneNumber")
				.addField(double.class, "price")
				.build();
		
		PackageBuilder entitiesPackageBuilder = PackageElement.builder().addName("api.exploritage.entites");
		entitiesPackageBuilder.addClass(entity);
		
		JavaFile javaFile = JavaFile.builder()
				.addPackage(entitiesPackageBuilder.build())
				.build();
		
		ICodeWriter codeWriter = new CodeModelWriter(javaFile);
		codeWriter.makeCode();
		codeWriter.write(new File("/Users/pratik/codebase/workspace/"));
		
	}
}
