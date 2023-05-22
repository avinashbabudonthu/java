package com.lang3;

import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	private String name;
	private String address;

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("name", name).append("address", address).toString();
	}
}
