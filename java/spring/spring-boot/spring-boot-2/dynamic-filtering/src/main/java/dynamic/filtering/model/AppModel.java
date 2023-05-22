package dynamic.filtering.model;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("AppModelFilter")
public class AppModel {

	private String field1;
	private String field2;
	private String field3;
}
