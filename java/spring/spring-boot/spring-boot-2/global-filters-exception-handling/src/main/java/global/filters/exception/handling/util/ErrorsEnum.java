package global.filters.exception.handling.util;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorsEnum {

	// @formatter:off
	REQUEST_HEADER_MISSING("CODE1", "Missing request header")
	;
	// @formatter:on

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
