/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.bean</p>
 * <p>文件名：Token.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月11日-下午2:13:55</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.bean.response;

/**<p>名称：Token.java</p>
 * <p>描述：</p>
 * <pre>
 *      Token数据对象   
 * </pre>
 * @author 鲍建明
 * @date 2015年3月11日 下午2:13:55
 * @version 1.0.0
 */
public class Token implements ResultMessage {

	private static final long serialVersionUID = -5877262673684023185L;
	private String access_token;
	private Long expires_in;
	private String application;
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public Long getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
	
}
