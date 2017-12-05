package gen.api.mvc.builders.elements;

import gen.api.mvc.builders.impl.FieldBuilder;

public class Field extends BaseElement {
	
	private boolean haveGetter;
	private boolean haveSetter;
	
	public Field(boolean haveGetter, boolean haveSetter) {
		super();
		this.haveGetter = haveGetter;
		this.haveSetter = haveSetter;
	}
	
	public Field() {
		
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
		return new FieldBuilder(new Field());
	}
}
