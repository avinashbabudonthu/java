package basic.authentication.authorization.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseModel {

	private Long count;
	private Long totalCount;
	private Object result;
	private Double totalSum;
	private String key;

}