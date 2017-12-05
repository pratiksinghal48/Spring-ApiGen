package gen.api.mvc.codeWriter;

import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JExpr;
import com.helger.jcodemodel.JFieldVar;
import com.helger.jcodemodel.JMethod;
import com.helger.jcodemodel.JMod;

public class ClassElements {
	
	public static JMethod getGetter(JDefinedClass parentClass, JFieldVar variable) {
		String getterName = "get" + variable.name();
		JMethod getter = BaseElements.getMethod(parentClass, getterName, variable.type(), JMod.PUBLIC);
		getter.body()._return(variable);
		return getter;
	}
	
	public static JMethod getSetter(JDefinedClass parentClass, JFieldVar variable) {
		String setterName = "set" + variable.name();
		JMethod setter = parentClass.method(JMod.PUBLIC, void.class, setterName);
		setter.param(variable.type(), variable.name());
		setter.body().assign(JExpr._this().ref(variable.name()), JExpr.ref(variable.name()));
		return setter;
	}
	
}
