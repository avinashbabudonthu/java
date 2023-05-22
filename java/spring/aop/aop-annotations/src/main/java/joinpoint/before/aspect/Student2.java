package joinpoint.before.aspect;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student2 {

	private Long id;
	private String name;
	private Date joiningDate;
}
