package exception.handling.reponsestatus.annotation.utils;

import java.util.function.Supplier;

import org.springframework.stereotype.Component;

import exception.handling.reponsestatus.annotation.exception.model.InvalidObjectException;
import exception.handling.reponsestatus.annotation.exception.model.ObjectNotFoundException;

@Component
public class Utils {

	public Supplier<? extends ObjectNotFoundException> throwObjectNotFound() {
		return () -> {
			return new ObjectNotFoundException();
		};
	}

	public Supplier<? extends InvalidObjectException> throwInvalidObjectException() {
		return () -> {
			return new InvalidObjectException();
		};
	}
}
