package com.iis.apirest.business.person.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUpdate {
    private String idPerson;

	@NotBlank(message = "El nombre no puede estar vacío")
    private String firstName;

	@NotBlank(message = "El apellido no puede estar vacío")
	private String surName;

	@NotBlank(message = "El DNI es requerido")
    @Pattern(regexp = "\\d{8}", message = "El formato del DNI es incorrecto")
	private String dni;

	@NotNull(message = "El género no puede ser nulo")
	private Boolean gender;

	@NotBlank(message = "La fecha de nacimiento es obligatoria")
	private String birthDate;
}
