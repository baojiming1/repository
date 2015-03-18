/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.utils</p>
 * <p>文件名：IMProperties.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月12日-上午10:33:02</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.utils;

import java.util.ResourceBundle;

/**<p>名称：IMProperties.java</p>
 * <p>描述：</p>
 * <pre>
 *    读取IMProperties文件到内存中     
 * </pre>
 * @author 鲍建明
 * @date 2015年3月12日 上午10:33:02
 * @version 1.0.0
 */
public class IMProperties {

	private static ResourceBundle bundle;
	private static String REQUEST_URL;				//url
	private static String CLIENT_ID;				//client_id
	private static String CLIENT_SECRET;			//client_secret
	private static Integer AGAINCOUNT;				//重试的次数
	
	static{
		bundle = ResourceBundle.getBundle("im");
		REQUEST_URL = bundle.getString("url");
		CLIENT_ID = bundle.getString("client_id");
		CLIENT_SECRET = bundle.getString("client_secret");
		AGAINCOUNT = Integer.valueOf( bundle.getString("againCount") );
		AccessUtils.isNull(REQUEST_URL, "环信的请求前缀不能为空");
		AccessUtils.isNull(CLIENT_ID, "环信的client_id不能为空");
		AccessUtils.isNull(CLIENT_SECRET, "环信的client_secret不能为空");
		AccessUtils.isNull(AGAINCOUNT, "环信的重试机制次数不能为空");
	}
	
	public static String getUrl(){
		return REQUEST_URL;
	}
	
	public static String getClientId(){
		return CLIENT_ID;
	}
	
	public static String getClientSecret(){
		return CLIENT_SECRET;
	}
	
	public static Integer getAgainCount(){
		return AGAINCOUNT;
	}
	
}
