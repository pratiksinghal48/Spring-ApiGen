package gen.api.mvc.codeWriter.impl;

import com.helger.jcodemodel.AbstractJType;
import com.helger.jcodemodel.EClassType;
import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JCodeModel;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JFieldVar;
import com.helger.jcodemodel.JMethod;
import com.helger.jcodemodel.JPackage;

import gen.api.mvc.builders.elements.ClassElement;
import gen.api.mvc.builders.elements.ClassType;
import gen.api.mvc.builders.elements.Field;
import gen.api.mvc.codeWriter.Utils.Helpers;

public class BaseElements {

	public static JPackage getPackage(JCodeModel model, String identifier) {
		return model._package(identifier);
	}

	private static JDefinedClass getClass(JPackage pkg, String identifier, int modifiers, EClassType classType)
			throws JClassAlreadyExistsException {
		return pkg._class(modifiers, identifier, classType);
	}

	public static JDefinedClass getClass(JPackage pkg, String identifier, int modifiers)
			throws JClassAlreadyExistsException {
		return getClass(pkg, identifier, modifiers, EClassType.CLASS);
	}

	public static JDefinedClass getInterface(JPackage pkg, String identifier, int modifiers)
			throws JClassAlreadyExistsException {
		return getClass(pkg, identifier, modifiers, EClassType.INTERFACE);
	}

	public static JDefinedClass getEnum(JPackage pkg, String identifier, int modifiers)
			throws JClassAlreadyExistsException {
		return getClass(pkg, identifier, modifiers, EClassType.ENUM);
	}

	public static JFieldVar getField(JDefinedClass parentClass, String identifier, Class<?> fieldType, int modifiers) {
		return parentClass.field(modifiers, fieldType, identifier);
	}

	public static JFieldVar getField(JDefinedClass parentClass, String identifier, AbstractJType fieldType,
			int modifiers) {
		return parentClass.field(modifiers, fieldType, identifier);
	}

	public static JMethod getMethod(JDefinedClass parentClass, String identifier, Class<?> returnType, int modifiers) {
		return parentClass.method(modifiers, returnType, identifier);
	}

	public static JMethod getMethod(JDefinedClass parentClass, String identifier, AbstractJType returnType,
			int modifiers) {
		return parentClass.method(modifiers, returnType, identifier);
	}

	public static JDefinedClass getClass(JPackage pkg, ClassElement clsElement) throws JClassAlreadyExistsException {
		int modifier = Helpers.getModifier(clsElement.getModifiers());
		JDefinedClass cls = getClass(pkg, clsElement.getIdentifier(), modifier);
		clsElement.setInstance(cls);
		return cls;
	}

	public static JFieldVar getField(JDefinedClass parentClass, Field field) {
		ClassType classType = field.getClassType();
		int modifier = Helpers.getModifier(field.getModifiers());
		String identifier = field.getIdentifier();
		JFieldVar jFieldVar = null;
		if(classType.isPrimitive()) {
			jFieldVar = getField(parentClass, identifier, classType.getType(), modifier);
		} else {
			AbstractJType obj = (AbstractJType) classType.getBaseElement().getInstance();
			jFieldVar = getField(parentClass, identifier, obj, modifier);
		}
		field.setInstance(jFieldVar);
		return jFieldVar;

	}

}
