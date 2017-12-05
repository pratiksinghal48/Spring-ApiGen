package gen.api.mvc.codeWriter.Utils;

import java.util.List;

import com.helger.jcodemodel.JMod;

import gen.api.mvc.builders.elements.Modifiers;

public class Helpers {
	
	public static int getModifier(Modifiers modifier) {
		switch(modifier) {
		case PRIVATE:
			return JMod.PRIVATE;
		case STATIC:
			return JMod.STATIC;
		case ABSTRACT:
			return JMod.ABSTRACT;
		case DEFAULT:
			return JMod.DEFAULT;
		case FINAL:
			return JMod.FINAL;
		case NATIVE:
			return JMod.NATIVE;
		case PROTECTED:
			return JMod.PROTECTED;
		case PUBLIC:
			return JMod.PUBLIC;
		case STRICTFP:
			return JMod.STRICTFP;
		case SYNCHRONIZED:
			return JMod.SYNCHRONIZED;
		case TRANSIENT:
			return JMod.TRANSIENT;
		case VOLATILE:
			return JMod.VOLATILE;
		default:
			return JMod.NONE;
		}
	}

	public static int getModifier(List<Modifiers> modifiers) {
		int response = getModifier(Modifiers.NONE);
		for(Modifiers modifier : modifiers) {
			response = response | getModifier(modifier);
		}
		return response;
	}
}
