package global.exception.handling.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

@AllArgsConstructor
@Getter
public enum ErrorsEnum {

    BAD_REQUEST_EXCEPTION("IS1","Bad request exception"),
    ERROR_WHILE_PARSING_ERROR_MESSAGE("IS2","Error while parsing error message");

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
