package global.exception.handling.error.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AppException extends RuntimeException {

	private static final long serialVersionUID = 4182294436606075029L;
	private Object errors;
	private HttpStatus httpStatus;

	@Override
	public String getMessage() {
		return String.valueOf(errors);
	}
}