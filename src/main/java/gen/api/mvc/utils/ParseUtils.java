package gen.api.mvc.utils;

import org.springframework.util.ClassUtils;

public class ParseUtils {
	public static Class<?> parseClassType(String classType) {
		try {
			return ClassUtils.forName(classType, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
