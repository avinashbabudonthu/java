package properties.injection;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {

	private Long id;
	private String name;
}