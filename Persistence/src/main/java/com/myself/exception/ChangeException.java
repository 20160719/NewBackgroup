package com.myself.exception;

/**
 * @author zhanghong
 *
 */
public class ChangeException extends Exception {

	private static final long serialVersionUID = 909516899516859198L;
	
	private int code;

	public ChangeException(int code, String msg) {
		super(msg);
		this.code = code;
	}

	@Override
	public String toString() {
		return "{\"code\": " + code + ", \"msg\": \"" + super.getMessage() + "\"}";
	}

}
