package global.filters.exception.handling.config;

import static global.filters.exception.handling.util.Constants.TRANSACTION_ID;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import global.filters.exception.handling.error.model.AppException;
import global.filters.exception.handling.error.model.ErrorModel;
import global.filters.exception.handling.error.model.ExceptionModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class GlobalErrorHandler implements ErrorController {

	@RequestMapping("/error")
	public ResponseEntity<ExceptionModel> handleError(final HttpServletRequest request,
			final HttpServletResponse response) {
		ExceptionModel exceptionModel = null;
		response.setHeader(TRANSACTION_ID, UUID.randomUUID().toString()); // Include transaction id in response header in error scenario

		Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
		try {
			if (exception instanceof AppException) {
				exceptionModel = ExceptionModel.builder().errors(((AppException) exception).getErrors()).build();
			} else {
				exceptionModel = ExceptionModel.builder().errors(exception.getMessage()).build();
			}
		} catch (Exception e) {
			log.error("Exception while parsing exception in global error handler", e);
			ErrorModel errorModel = ErrorModel.builder().code("CODE2")
					.message("Exception while parsing exception in global error handler").build();
			exceptionModel = ExceptionModel.builder().errors(errorModel).build();
		}

		return new ResponseEntity<ExceptionModel>(exceptionModel, HttpStatus.BAD_REQUEST);
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}