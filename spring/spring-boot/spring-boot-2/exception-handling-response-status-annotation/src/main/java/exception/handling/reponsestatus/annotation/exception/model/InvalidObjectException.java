package exception.handling.reponsestatus.annotation.exception.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid object")
public class InvalidObjectException extends RuntimeException {

	private static final long serialVersionUID = 3696553746558419203L;

}
