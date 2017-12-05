package gen.api.mvc.exceptions;

import gen.api.mvc.builders.elements.BaseElement;

@SuppressWarnings("serial")
public class BuilderException extends Exception {

	public BuilderException( BaseElement element, String message) {
		super(element.getIdentifier() + message);
	}
	
	public BuilderException(String message) {
		super(message);
	}
}
