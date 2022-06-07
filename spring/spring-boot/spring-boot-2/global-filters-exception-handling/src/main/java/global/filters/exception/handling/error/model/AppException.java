package global.filters.exception.handling.error.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AppException extends RuntimeException {

	private static final long serialVersionUID = 4182294436606075029L;
	private Object errors;

	@Override
	public String getMessage() {
		return String.valueOf(errors);
	}
}
