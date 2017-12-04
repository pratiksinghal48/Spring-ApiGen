package gen.api.mvc.builders.elements;

import gen.api.mvc.builders.FieldBuilder;

public class Field extends BaseElement {
	
	private boolean haveGetter;
	private boolean haveSetter;
	private Object fieldInstance;
	
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
	public Object getFieldInstance() {
		return fieldInstance;
	}
	public void setFieldInstance(Object fieldInstance) {
		this.fieldInstance = fieldInstance;
	}

	public static FieldBuilder builder() {
		return new FieldBuilder(new Field());
	}
}
