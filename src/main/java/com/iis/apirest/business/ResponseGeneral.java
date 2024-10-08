package com.iis.apirest.business;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseGeneral {
	private String type;
	private List<String> listMessage;

	public ResponseGeneral() {
		this.type = "error";
		this.listMessage = new ArrayList<>();
	}

	public void addResponseMesssage(String message) {
        this.listMessage.add(message);
    }

	public void success() {
		this.type = "success";
	}

	public void warning() {
		this.type = "warning";
	}

	public void error() {
		this.type = "error";
	}

	public void exception() {
		this.type = "exception";
	}
}


