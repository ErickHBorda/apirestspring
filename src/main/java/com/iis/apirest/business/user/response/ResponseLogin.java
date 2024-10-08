package com.iis.apirest.business.user.response;

import com.iis.apirest.business.ResponseGeneral;

import lombok.Setter;

@Setter
public class ResponseLogin extends ResponseGeneral {
	public Object dto;
    public Object token;
}
