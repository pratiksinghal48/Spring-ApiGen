package gen.api.mvc.builders;

import gen.api.mvc.exceptions.BuilderException;

public interface IBuilder<T> {

	public T build() throws BuilderException;
}