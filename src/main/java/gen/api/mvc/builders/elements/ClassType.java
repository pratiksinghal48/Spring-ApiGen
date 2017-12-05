package gen.api.mvc.builders.elements;

public class ClassType {
	
	private boolean isPrimitive;
	private Class<?> type;
	private BaseElement baseElement;

	public ClassType(Class<?> classType) {
		this.type = classType;
		this.isPrimitive = true;
	}

	public ClassType(BaseElement baseElement) {
		this.baseElement = baseElement;
		this.isPrimitive = false;
	}

	public Class<?> getType() {
		return type;
	}

	public void setType(Class<?> type) {
		this.type = type;
		this.isPrimitive = true;
	}

	public BaseElement getBaseElement() {
		return baseElement;
	}

	public void setBaseElement(BaseElement baseElement) {
		this.baseElement = baseElement;
		this.isPrimitive = false;
	}

	public boolean isPrimitive() {
		return isPrimitive;
	}
	
}
