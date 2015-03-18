/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.bean.request</p>
 * <p>文件名：TokenRequest.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月12日-上午10:42:21</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.bean.request;


/**<p>名称：TokenRequest.java</p>
 * <p>描述：</p>
 * <pre>
 *         
 * </pre>
 * @author 鲍建明
 * @date 2015年3月12日 上午10:42:21
 * @version 1.0.0
 */
public class TokenRequest extends DefalutRequestBody{

	private static final long serialVersionUID = -2285758447663915130L;
	private String grant_type;
	private String client_id;
	private String client_secret;
	
	public String getGrant_type() {
		return grant_type;
	}
	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getClient_secret() {
		return client_secret;
	}
	public void setClient_secret(String client_secret) {
		this.client_secret = client_secret;
	}
	
}
