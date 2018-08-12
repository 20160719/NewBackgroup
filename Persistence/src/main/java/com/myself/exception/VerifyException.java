package com.myself.exception;

/**
 * @author zhanghong
 *
 */
public class VerifyException extends ChangeException {

	private static final long serialVersionUID = 7888790450054357219L;

	public VerifyException(int code, String msg) {
		super(code, msg);
	}

}
