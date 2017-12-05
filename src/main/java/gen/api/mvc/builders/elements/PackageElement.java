package gen.api.mvc.builders.elements;

import java.util.List;

import gen.api.mvc.builders.impl.PackageBuilder;

public class PackageElement extends BaseElement {
	private List<ClassElement> classElements;

	public List<ClassElement> getClassElements() {
		return classElements;
	}

	public void setClassElements(List<ClassElement> classElements) {
		this.classElements = classElements;
	}
	
	public static PackageBuilder builder() {
		return new PackageBuilder(new PackageElement());
	}
}
