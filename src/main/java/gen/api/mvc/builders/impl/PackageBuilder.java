package gen.api.mvc.builders.impl;

import java.util.ArrayList;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import gen.api.mvc.builders.IBuilder;
import gen.api.mvc.builders.elements.ClassElement;
import gen.api.mvc.builders.elements.PackageElement;
import gen.api.mvc.exceptions.BuilderException;
import gen.api.mvc.exceptions.ExceptionMessages;

public class PackageBuilder implements IBuilder<PackageElement> {

	private PackageElement packageElement;

	public PackageBuilder(PackageElement packageElement) {
		this.packageElement = packageElement;
		init();
	}
	
	private void init() {
		if(this.packageElement == null) {
			this.packageElement = new PackageElement();
		}
		this.packageElement.setClassElements(new ArrayList<>());
	}

	public PackageBuilder addName(String name) {
		packageElement.setIdentifier(name);
		return this;
	}
	
	public PackageBuilder addClass(ClassElement classElement) {
		this.packageElement.getClassElements().add(classElement);
		return this;
	}

	@Override
	public PackageElement build() throws BuilderException {
		validate();
		return packageElement;
	}

	private void validate() throws BuilderException {
		if(StringUtils.isEmpty(packageElement.getIdentifier())) {
			throw new BuilderException(ExceptionMessages.IDENTIFIER_NOT_PRESENT);
		}
		if(CollectionUtils.isEmpty(packageElement.getClassElements())) {
			throw new BuilderException(ExceptionMessages.CLASS_ELEMENT_NOT_PRESENT);
		}
	}

}
