package method.level.annotation.aspect;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student6 {

	private Long id;
	private String name;
	private Date joiningDate;
}
