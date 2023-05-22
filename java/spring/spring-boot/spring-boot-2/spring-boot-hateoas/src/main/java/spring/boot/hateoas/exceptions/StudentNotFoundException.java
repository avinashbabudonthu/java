package spring.boot.hateoas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Student not found by id")
public class StudentNotFoundException extends RuntimeException {
}
