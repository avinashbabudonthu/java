package global.exception.handling.util;

import java.time.LocalDateTime;
import java.util.function.Supplier;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import global.exception.handling.error.model.AppException;
import global.exception.handling.error.model.ErrorModel;

@Component
public class Utils {

	@Autowired
	private HttpServletRequest httpServletRequest;

	public final Supplier<? extends RuntimeException> buildAppException(final String code, final String message,
			Object value, final String... propertiesToBeDotSeperated) throws Exception {
		return () -> {
			// @formatter:off
            ErrorModel errorModel = ErrorModel.builder()
                    .code(code)
                    .message(message)
                    .value(value)
                    .timestamp(LocalDateTime.now())
                    .status(HttpStatus.BAD_REQUEST.value())
                    .property(buildDotSepratedString(propertiesToBeDotSeperated))
                    .path(httpServletRequest.getRequestURI())
                    .method(httpServletRequest.getMethod())
                    .build();
            // @formatter:on
			throw AppException.builder().errors(errorModel).build();
		};
	}

	public String buildDotSepratedString(final String... varArgs) {
		String result = Constants.EMPTY_STRING;
		if (ArrayUtils.isNotEmpty(varArgs)) {
			result = String.join(Constants.DOT, varArgs);
		}

		return result;
	}
}
