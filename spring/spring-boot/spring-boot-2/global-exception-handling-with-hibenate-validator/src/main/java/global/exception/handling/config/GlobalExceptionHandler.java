package global.exception.handling.config;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	protected ResponseEntity<Object> handleException(AppException appException, WebRequest webRequest) {
		ExceptionModel exceptionModel = null;
		try {
			log.error(ErrorsEnum.BAD_REQUEST_EXCEPTION.getMessage(), appException);
			exceptionModel = ExceptionModel.builder().errors(appException.getErrors()).build();
		} catch (Exception e) {
			log.error(ErrorsEnum.ERROR_WHILE_PARSING_ERROR_MESSAGE.getMessage(), e);
			ErrorModel errorModel = ErrorModel.builder().code(ErrorsEnum.ERROR_WHILE_PARSING_ERROR_MESSAGE.getCode())
					.message(ErrorsEnum.ERROR_WHILE_PARSING_ERROR_MESSAGE.getMessage()).build();
			exceptionModel = ExceptionModel.builder().errors(errorModel).build();
		}

		HttpStatus httpStatus = null == appException.getHttpStatus() ? HttpStatus.BAD_REQUEST : appException.getHttpStatus();
		return handleExceptionInternal(appException, exceptionModel, new HttpHeaders(), httpStatus, webRequest);
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

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorModel errorModel = ErrorModel.builder().value(ex.getBindingResult())
				.timestamp(Timestamp.valueOf(LocalDateTime.now()).getTime()).status(HttpStatus.BAD_REQUEST.value())
				.build();

		return new ResponseEntity<>(errorModel, HttpStatus.BAD_REQUEST);
	}
}
