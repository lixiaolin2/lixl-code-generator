package io.renren.base;


/**
 * 响应吗
 * 功能说明:
 *
 * @version V1.0
 * @author qzq
 * @since  JDK1.6
 */
public enum SystemEnum {

	FAIL(400,"fail" ),
	PARAMS_FAIL(400,"fail" ),
	LOGIN_FAIL(401,"已在其他电脑登陆的错误码" ),
	SUCCESS(200,"操作成功!" ),
	PROCESSING(600,"处理中" ),
	;


	private Integer code;
	private String msg;
	SystemEnum(int code, String msg){
		this.code=code;
		this.msg=msg;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Long getLongCode(){
		return code.longValue();
	}
}
