package gen.api.mvc.builders.elements;

import java.util.List;

public abstract class BaseElement {

	protected String identifier;
	protected ClassType classType;
	protected List<Modifiers> modifiers;
	protected Object instance;
	
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public ClassType getClassType() {
		return classType;
	}
	public void setClassType(ClassType classType) {
		this.classType = classType;
	}
	public List<Modifiers> getModifiers() {
		return modifiers;
	}
	public void setModifiers(List<Modifiers> modifiers) {
		this.modifiers = modifiers;
	}
	public Object getInstance() {
		return instance;
	}
	public void setInstance(Object instance) {
		this.instance = instance;
	}
	
}