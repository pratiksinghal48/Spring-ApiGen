package gen.api.mvc.builders.elements;

import java.util.List;

public abstract class BaseElement {

	protected String identifier;
	protected Class<?> elementClassType;
	protected List<Modifiers> modifiers;
	
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public Class<?> getElementClassType() {
		return elementClassType;
	}
	public void setElementClassType(Class<?> elementClassType) {
		this.elementClassType = elementClassType;
	}
	public List<Modifiers> getModifiers() {
		return modifiers;
	}
	public void setModifiers(List<Modifiers> modifiers) {
		this.modifiers = modifiers;
	}
	
}