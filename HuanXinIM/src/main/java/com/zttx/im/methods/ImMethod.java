/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.methods</p>
 * <p>文件名：ImMethod.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月12日-上午11:40:39</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.methods;

import com.zttx.im.bean.response.Message;
import com.zttx.im.bean.response.Token;

/**<p>名称：ImMethod.java</p>
 * <p>描述：</p>
 * <pre>
 *         
 * </pre>
 * @author 鲍建明
 * @date 2015年3月12日 上午11:40:39
 * @version 1.0.0
 */
public enum ImMethod {
	/**
	 * 获取koen的方法
	 */
	TOKEN("/token", Token.class),
	REGISTER("/users", Message.class),
	SEND_MSG("/messages", Message.class),
	FIND_USER("/users/%s",Message.class ),
	RESET_PWD("/users/%s/password", Message.class),
	UPDATE_NICKNAME("/users/%s", Message.class),
	DELETE_USER("/users/%s", Message.class),
	USER_STATUS("/users/%s/status", Message.class);
	
	private String uri;
	private Class<?> resultClass;
	
	private ImMethod(String uri, Class<?> resultClass){
		this.uri = uri;
		this.resultClass = resultClass;
	}

	public String getUri() {
		return uri;
	}

	public Class<?> getResultClass() {
		return resultClass;
	}
	
	
}
