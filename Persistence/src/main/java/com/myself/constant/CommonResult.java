package com.myself.constant;

/**
 * @author zhanghong
 *
 */
public enum CommonResult {
	
	OPERATE_SUCCESS(1, "操作成功"),
	
	OPERATE_FALID(-1, "操作失败");
	
	private int code;
	
	private String msg;

	private CommonResult(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public String toString() {
		return "{\"code\": " + code + ", \"msg\": \"" + msg + "\"}";
	}

}
