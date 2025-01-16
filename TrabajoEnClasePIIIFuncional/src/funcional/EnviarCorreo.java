package funcional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;

public class EnviarCorreo {

	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-z0-9._%-+]+@[a-z0-9.-]+\\.[a-z]{2,4}$");
	// Predicates y Consumers:
	// -----------------------------------------------------
	private final Predicate<String> isValidEmail = email -> EMAIL_PATTERN.matcher(email).matches();

	private final Consumer<String> sendVerificationEmail = email -> System.out
			.println("Correo de verificación enviado a: " + email);

	private final Consumer<String> handleError = email -> System.out.println("Error: email " + email + " inválido");

	public void validateEmail(String email) {
		(isValidEmail.test(email) ? sendVerificationEmail : handleError).accept(email);
	}

	// -------------------------------------------------------
	Effect<String> success = s -> System.out.println("Enviar correo de confirmación a: " + s);
	Effect<String> failure = s -> System.out.println("Error: " + s);

	private final Function<String, Result<String>> emailCheck = email -> Case.match(
			Case.defaultCase(Result.failure("El correo electrónico es inválido")),
			Case.mcase(() -> email == null, Result.failure("Correo no puede ser nulo")),
			Case.mcase(() -> email != null && email.isEmpty(), Result.failure("Correo no puede ser vacío")),
			Case.mcase(() -> email != null && EMAIL_PATTERN.matcher(email).matches(),
					Result.success("Correo electrónico aceptado: " + email)));

	public Supplier<Void> validate(String email) {
		Result<String> resultado = emailCheck.apply(email);
		return resultado instanceof Success ? () -> {
			success.apply(email);
			return null;
		} : () -> {
			failure.apply(email);
			return null;
		};
	}

}
