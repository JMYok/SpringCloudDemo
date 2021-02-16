package com.atguigu.spring.cloud.util;

public class ResultEntity<T> {
	public static final String SUCCESS = "SUCCESS";
	public static final String FAILED = "FAILED";
	public static final String NO_MESSAGE = "NO_MESSAGE";
	public static final String NO_DATA = "NO_DATA";
	
	private String result;
	private String message;
	private T data;

	/**
	 *  操作成功，不需要返回数据
	 * @return
	 */
	public static ResultEntity<String> successWithoutData() {
		return new ResultEntity<String>(SUCCESS, NO_MESSAGE, NO_DATA);
	}

	/**
	 * 操作成功，需要返回数据
	 * @param <E>
	 * @param data
	 * @return
	 */
	public static <E> ResultEntity<E> successWithData(E data) {
		return new ResultEntity<E>(SUCCESS, NO_MESSAGE, data);
	}

	/**
	 * 操作失败，返回错误消息
	 * @param <E>
	 * @param message
	 * @return
	 */
	public static <E> ResultEntity<E> failed(String message) {
		return new ResultEntity<E>(FAILED, message, null);
	}

	

	public ResultEntity(String result, String message, T data) {
		super();
		this.result = result;
		this.message = message;
		this.data = data;
	}

	public ResultEntity() {

	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
	
	
	
	
}
