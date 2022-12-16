package com.bus.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AdminDTO {
	@NotNull(message ="Username cannot be null.")
	private String userName;
	@NotNull(message ="Password cannot be null.")
	private String password;

}
