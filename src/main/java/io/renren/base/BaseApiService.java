package io.renren.base;

import org.springframework.stereotype.Component;

/**
 * API返回值调用方法
 * @param <T>
 */
@Component
public class BaseApiService<T> {

	/**
	 * 通用返回结果
	 * @param code 状态码
	 * @param msg   返回信息
	 * @param data 返回数据
	 * @return
	 */
	public BaseResponse<T> setResult(Integer code, String msg, T data) {
		return new BaseResponse<T>(code, msg, data);
	}

	/**
	 * 设置失败结果
	 * @param code  失败状态码
	 * @param msg  失败原因
	 * @return
	 */
	public BaseResponse<T> setResultError(Integer code, String msg) {
		return setResult(code, msg, null);
	}

	/**
	 * 设置失败原因（失败状态码 400）
	 * @param
	 * @return
	 */
	public BaseResponse<T> setResultErrorMsg(String msg) {
		return setResult(SystemEnum.FAIL.getCode(), msg, null);
	}

	/**
	 * 操作成功
	 * @param data 要返回的数据
	 * @return
	 */
	public BaseResponse<T> setResultSuccess(T data) {
		return setResult(SystemEnum.SUCCESS.getCode(), SystemEnum.SUCCESS.getMsg(), data);
	}

	/**
	 * 操作成功
	 * @return
	 */
	public BaseResponse<T> setResultSuccess() {
		return setResult(SystemEnum.SUCCESS.getCode(), SystemEnum.SUCCESS.getMsg(), null);
	}

	/**
	 * 操作成功
	 * @param msg 返回的信息
	 * @return
	 */
	public BaseResponse<T> setResultSuccessMsg(String msg) {
		return setResult(SystemEnum.SUCCESS.getCode(), msg, null);
	}

	/**
	 * 已在其他电脑登陆的错误码
	 * @return
	 */
	public BaseResponse<T> setResultLoginFail() {
		return setResult(SystemEnum.LOGIN_FAIL.getCode(), SystemEnum.LOGIN_FAIL.getMsg(), null);
	}

	/**
	 * 已在其他电脑登陆的错误码
	 * @param msg 返回信息
	 * @return
	 */
	public BaseResponse<T> setResultLoginFailMsg(String msg) {
		return setResult(SystemEnum.LOGIN_FAIL.getCode(), msg, null);
	}


	/**
	 * 参数校验错误
	 * @param msg
	 * @return
	 */
	public BaseResponse<T> setResultParamsErrorMsg(String msg) {
		return setResult(SystemEnum.PARAMS_FAIL.getCode(), msg, null);
	}


	// 调用数据库层判断
	public Boolean toDaoResult(int result) {
		return result > 0 ? true : false;
	}

	// 接口直接返回true 或者false
	public Boolean isSuccess(BaseResponse<?> baseResp) {
		if (baseResp == null) {
			return false;
		}
		if (baseResp.getCode()== SystemEnum.SUCCESS.getCode()) {
			return false;
		}
		return true;
	}

}
