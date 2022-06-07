package global.exception.handling.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import global.exception.handling.error.model.AppException;
import global.exception.handling.error.model.ErrorModel;
import global.exception.handling.error.model.ExceptionModel;
import global.exception.handling.util.ErrorsEnum;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { AppException.class })
	protected ResponseEntity<Object> handleException(AppException runtimeException, WebRequest webRequest) {
		ExceptionModel exceptionModel = null;
		try {
			log.error(ErrorsEnum.BAD_REQUEST_EXCEPTION.getMessage(), runtimeException);
			exceptionModel = ExceptionModel.builder().errors(runtimeException.getErrors()).build();
		} catch (Exception e) {
			log.error(ErrorsEnum.ERROR_WHILE_PARSING_ERROR_MESSAGE.getMessage(), e);
			ErrorModel errorModel = ErrorModel.builder().code(ErrorsEnum.ERROR_WHILE_PARSING_ERROR_MESSAGE.getCode())
					.message(ErrorsEnum.ERROR_WHILE_PARSING_ERROR_MESSAGE.getMessage()).build();
			exceptionModel = ExceptionModel.builder().errors(errorModel).build();
		}

		return handleExceptionInternal(runtimeException, exceptionModel, new HttpHeaders(), HttpStatus.BAD_REQUEST,
				webRequest);
	}

	/**
	 * Global exception other than above 3 exceptions
	 * @param
	 *
	 * @return
	 */
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> otherExceptions(Exception exception, WebRequest webRequest) {
		log.error(ErrorsEnum.BAD_REQUEST_EXCEPTION.getMessage(), exception);
		ExceptionModel exceptionModel = ExceptionModel.builder()
				.errors(exception.getClass().getName() + " : " + exception.getMessage()).build();
		return handleExceptionInternal(exception, exceptionModel, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,
				webRequest);
	}
}
