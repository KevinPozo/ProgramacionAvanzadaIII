package funcional;

import java.util.function.Supplier;

public class Case<T> {
	protected Supplier<Boolean> condicion;
	protected Result<T> accion;

	public Case(Supplier<Boolean> condicion, Result<T> accion) {
		this.condicion = condicion;
		this.accion = accion;
	}

	public static <T> Case<T> mcase(Supplier<Boolean> condicion, Result<T> accion) {
		return new Case<>(condicion, accion);
	}

	public static <T> DefaultCase<T> defaultCase(Result<T> accion) {
		return new DefaultCase<>(() -> true, accion);
	}

	@SafeVarargs
	public static <T> Result<T> match(DefaultCase<T> defaul, Case<T>... cases) {
		for (Case<T> acase : cases) {
			if (acase.condicion.get()) {
				return acase.accion;
			}
		}
		return defaul.accion;
	}
}

class DefaultCase<T> extends Case<T> {
	public DefaultCase(Supplier<Boolean> condicion, Result<T> accion) {
		super(condicion, accion);
	}
}
