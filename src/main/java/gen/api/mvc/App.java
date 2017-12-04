package gen.api.mvc;

import java.io.File;

import gen.api.mvc.builders.CodeWriter;
import gen.api.mvc.builders.elements.ClassElement;
import gen.api.mvc.builders.elements.Field;
import gen.api.mvc.builders.elements.JavaFile;
import gen.api.mvc.builders.elements.Modifiers;
import gen.api.mvc.builders.elements.Pkg;

public class App 
{
    public static void main( String[] args ) throws Exception {
        Pkg pkg = new Pkg();
        pkg.setName("crud.api.exploritage");
        Field field = Field.builder()
        			.addIdentifier("id")
        			.addClassType(int.class)
        			.addModifier(Modifiers.PRIVATE)
        			.setGetter(true)
        			.setSetter(true)
        			.build();
        ClassElement classElement = ClassElement.builder()
        			.addPackage(pkg)
        			.addIdentifier("DestinationEntity")
        			.addField(field)
        			.addField("name", String.class, Modifiers.PRIVATE, true, true)
        			.build();
        JavaFile.builder(new CodeWriter()).addClass(classElement).build().write(new File("/Users/pratik/codebase/workspace/"));
    }
}
