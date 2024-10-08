package com.iis.apirest.business.user.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestLogin {
    @NotBlank(message = "El campo User es requerido.")
	private String nameUser;

	@NotBlank(message = "El campo Password es requerido.")
	private String password;
}
