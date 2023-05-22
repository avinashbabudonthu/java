package basic.authentication.authorization.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorModel {

	private String code;
	private String message;
	private String property;
	private String value;
	private Long timestamp;
	private Integer status;
	private String path;
	private String method;
}