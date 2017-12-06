package gen.api.mvc.builders.elements;

import gen.api.mvc.builders.impl.FieldBuilder;

public class FieldElement extends BaseElement {
	
	private boolean haveGetter;
	private boolean haveSetter;
	
	public FieldElement(boolean haveGetter, boolean haveSetter) {
		super();
		this.haveGetter = haveGetter;
		this.haveSetter = haveSetter;
	}
	
	public FieldElement() {
		
	}
	
	public boolean isHaveGetter() {
		return haveGetter;
	}
	public void setHaveGetter(boolean haveGetter) {
		this.haveGetter = haveGetter;
	}
	public boolean isHaveSetter() {
		return haveSetter;
	}
	public void setHaveSetter(boolean haveSetter) {
		this.haveSetter = haveSetter;
	}
	public static FieldBuilder builder() {
		return new FieldBuilder(new FieldElement());
	}
}
