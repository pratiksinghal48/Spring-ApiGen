package gen.api.mvc.layerGens;

import java.util.List;

import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JPackage;

import gen.api.mvc.elements.BaseElements;

public class EntityGens {
	
	public static JDefinedClass getEntity(JPackage pkg, List<String> fields) throws JClassAlreadyExistsException {
		String entityIdentifier = "sampleEntity";
		JDefinedClass entityClass = BaseElements.getClass(pkg, entityIdentifier);
		return entityClass;
	}
}
