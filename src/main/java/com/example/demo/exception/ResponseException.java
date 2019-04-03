package com.example.demo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ResponseException extends RuntimeException{

	private static final long serialVersionUID = -8195064679202935374L;
	private String respCode;
	private String respMsg;
}
