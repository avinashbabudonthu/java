package basic.authentication.authorization.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import basic.authentication.authorization.entity.ClientEntity;
import basic.authentication.authorization.entity.UserEntity;
import basic.authentication.authorization.model.AppException;
import basic.authentication.authorization.model.ErrorModel;
import basic.authentication.authorization.model.ResponseModel;
import basic.authentication.authorization.model.UserModel;

@Component
public class Utils {

	@Autowired
	private HttpServletRequest httpServletRequest;

	@Autowired
	@Qualifier("userPricipal")
	private UserModel userModel;

	public final Supplier<? extends RuntimeException> buildAppException(final String code, final String message,
			String value, final String... propertiesToBeDotSeperated) throws Exception {
		return () -> {
			// @formatter:off
			ErrorModel errorModel = ErrorModel.builder()
					.code(code)
					.message(message)
					.value(value)
					.timestamp(Timestamp.valueOf(LocalDateTime.now()).getTime())
					.status(HttpStatus.BAD_REQUEST.value())
					.property(buildDotSepratedString(propertiesToBeDotSeperated))
					.path(Objects.nonNull(httpServletRequest)?httpServletRequest.getRequestURI():null)
					.method(Objects.nonNull(httpServletRequest)?httpServletRequest.getMethod():null)
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

	public UserEntity getUserEntity() {
		return userModel.buildEntity();
	}

	public ClientEntity getClientEntity() {
		return userModel.getClientModel().buildEntity();
	}

	public String getClientId() {
		return getClientEntity().getId();
	}

	public ResponseModel buildResponseModel(Object result, Object count, Object totalCount) {
		count = Optional.ofNullable(count).orElse("-1");
		totalCount = Optional.ofNullable(totalCount).orElse("-1");
		return ResponseModel.builder().result(result).count(Long.valueOf(count.toString()))
				.totalCount(Long.valueOf(totalCount.toString())).build();
	}
}
