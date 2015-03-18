/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.bean</p>
 * <p>文件名：ResponseBody.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月11日-下午2:12:14</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.bean.response;

import java.util.List;
import java.util.Map;

/**<p>名称：ResponseBody.java</p>
 * <p>描述：</p>
 * <pre>
 *         
 * </pre>
 * @author 鲍建明
 * @date 2015年3月11日 下午2:12:14
 * @version 1.0.0
 */
public class Message implements ResultMessage{

	private static final long serialVersionUID = 5366480257278238585L;
	private String action;
	private String application;
	private Map<String, Object> params;
	private String path;
	private String uri;
	private List<?> entities;
	private Object data;
	private Long timestamp;
	private Integer duration;
	private String organization;
	private String applicationName;
	
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public List<?> getEntities() {
		return entities;
	}
	public void setEntities(List<?> entities) {
		this.entities = entities;
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
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
