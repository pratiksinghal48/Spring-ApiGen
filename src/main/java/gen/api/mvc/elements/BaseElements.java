package gen.api.mvc.elements;

import com.helger.jcodemodel.AbstractJType;
import com.helger.jcodemodel.EClassType;
import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JCodeModel;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JFieldVar;
import com.helger.jcodemodel.JMethod;
import com.helger.jcodemodel.JMod;
import com.helger.jcodemodel.JPackage;

public class BaseElements {
	
	public static JPackage getPackage(JCodeModel model, String identifier) {
		return model._package(identifier);
	}
	
	private static JDefinedClass getClass(JPackage pkg, String identifier, int modifiers, EClassType classType) throws JClassAlreadyExistsException {
		return pkg._class(modifiers, identifier, classType);
	}
	
	public static JDefinedClass getClass(JPackage pkg, String identifier, int modifiers) throws JClassAlreadyExistsException {
		return getClass(pkg, identifier, modifiers, EClassType.CLASS);
	}
	
	public static JDefinedClass getClass(JPackage pkg, String identifier) throws JClassAlreadyExistsException {
		return getClass(pkg, identifier, JMod.PUBLIC);
	}
	
	public static JDefinedClass getInterface(JPackage pkg, String identifier, int modifiers) throws JClassAlreadyExistsException {
		return getClass(pkg, identifier, modifiers, EClassType.INTERFACE);
	}
	
	public static JDefinedClass getInterface(JPackage pkg, String identifier) throws JClassAlreadyExistsException {
		return getInterface(pkg, identifier, JMod.PUBLIC);
	}
	
	public static JDefinedClass getEnum(JPackage pkg, String identifier, int modifiers) throws JClassAlreadyExistsException {
		return getClass(pkg, identifier, modifiers, EClassType.ENUM);
	}
	
	public static JDefinedClass getEnum(JPackage pkg, String identifier) throws JClassAlreadyExistsException {
		return getEnum(pkg, identifier, JMod.PUBLIC);
	}
	
	public static JFieldVar getField(JDefinedClass parentClass, String identifier, Class<?> fieldType, int modifiers ) {
		return parentClass.field(modifiers, fieldType, identifier);
	}
	
	public static JFieldVar getField(JDefinedClass parentClass, String identifier, Class<?> fieldType) {
		return getField(parentClass, identifier, fieldType, JMod.PRIVATE);
	}
	
	public static JFieldVar getField(JDefinedClass parentClass, String identifier, AbstractJType fieldType, int modifiers ) {
		return parentClass.field(modifiers, fieldType, identifier);
	}
	
	public static JFieldVar getField(JDefinedClass parentClass, String identifier, AbstractJType fieldType) {
		return getField(parentClass, identifier, fieldType, JMod.PRIVATE);
	}

	public static JMethod getMethod(JDefinedClass parentClass, String identifier, Class<?> returnType, int modifiers) {
		return parentClass.method(modifiers, returnType, identifier);
	}
	
	public static JMethod getMethod(JDefinedClass parentClass, String identifier, Class<?> returnType) {
		return parentClass.method(JMod.PUBLIC, returnType, identifier);
	}
	
	public static JMethod getMethod(JDefinedClass parentClass, String identifier, AbstractJType returnType, int modifiers) {
		return parentClass.method(modifiers, returnType, identifier);
	}
	
	public static JMethod getMethod(JDefinedClass parentClass, String identifier, AbstractJType returnType) {
		return parentClass.method(JMod.PUBLIC, returnType, identifier);
	}
	
}
