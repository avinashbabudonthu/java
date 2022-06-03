package hello.world.model;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

	private String id;
	private String street;
	private Date recordInsertDate;
}
