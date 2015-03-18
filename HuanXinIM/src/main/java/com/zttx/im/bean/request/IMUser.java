/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.bean.request</p>
 * <p>文件名：IMUser.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月12日-上午11:56:24</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.bean.request;

/**<p>名称：IMUser.java</p>
 * <p>描述：</p>
 * <pre>
 *         
 * </pre>
 * @author 鲍建明
 * @date 2015年3月12日 上午11:56:24
 * @version 1.0.0
 */
public class IMUser extends DefalutRequestBody{
	
	private static final long serialVersionUID = -2384665724060755271L;
	private String username;
	private String password;
	private String nickname;			// IOS 推送时需要显示
	
	public IMUser(){}
	
	public IMUser(String nickname){
		this.nickname = nickname;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	
	
}
