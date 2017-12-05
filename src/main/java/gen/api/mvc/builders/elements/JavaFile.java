package gen.api.mvc.builders.elements;

import java.util.List;

import gen.api.mvc.builders.impl.JavaFileBuilder;

public class JavaFile {
	private List<PackageElement> packageElement;

	public List<PackageElement> getPackageElement() {
		return packageElement;
	}

	public void setPackageElement(List<PackageElement> packageElement) {
		this.packageElement = packageElement;
	}


	public static JavaFileBuilder builder() {
		return new JavaFileBuilder(new JavaFile());
	}
	
}