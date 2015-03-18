/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.exception</p>
 * <p>文件名：ExceptionMsg.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月16日-上午11:43:47</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.exception;

import java.io.Serializable;

/**<p>名称：ExceptionMsg.java</p>
 * <p>描述：</p>
 * <pre>
 *         
 * </pre>
 * @author 鲍建明
 * @date 2015年3月16日 上午11:43:47
 * @version 1.0.0
 */
public class ExceptionMsg implements Serializable{

	private static final long serialVersionUID = 7893851161983040530L;
	private String error;
	private Long timestamp;
	private Integer duration;
	private String exception;
	private String error_description;
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public String getError_description() {
		return error_description;
	}
	public void setError_description(String error_description) {
		this.error_description = error_description;
	}
	
	
}
