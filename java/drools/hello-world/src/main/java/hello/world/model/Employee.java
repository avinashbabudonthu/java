package hello.world.model;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {

	private String id;
	private String name;
	private String addressId;
	private Date recordInsertDate;
}
