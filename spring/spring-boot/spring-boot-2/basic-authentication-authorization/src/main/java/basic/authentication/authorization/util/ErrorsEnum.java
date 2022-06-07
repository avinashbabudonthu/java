package basic.authentication.authorization.util;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorsEnum {

	//@formatter:off
	ERROR_GENERATING_PRIMARY_KEY_GENERATING_USING_UUID("ERROR1", "Error while generating primary key. Generating random number using UUID"),
	NULL_OBJECT("ERROR2", "Object can not be null"),
	OBJECT_NOT_FOUND("ERROR3", "Object not found"),
	NULL_PROPERTY("ERROR4","Property can not be null"),
	DUPLICATE_OBJECT_FOUND("ERROR5", "Duplicate entry found")
	;
	//@formatter:on

	private String code;
	private String message;

	public String formatString(Object... values) {
		String result = Constants.EMPTY_STRING;
		if (StringUtils.isNotEmpty(this.message) && ArrayUtils.isEmpty(values)) {
			result = this.message;
		} else if (StringUtils.isNotEmpty(this.message) && ArrayUtils.isNotEmpty(values)) {
			result = String.format(this.message, values);
		}

		return result;
	}
}
