/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.bean</p>
 * <p>文件名：TokenManager.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月16日-上午10:38:21</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.zttx.im.bean.response.Token;
import com.zttx.im.utils.IMUtils;

/**<p>名称：TokenManager.java</p>
 * <p>描述：</p>
 * <pre>
 *         
 * </pre>
 * @author 鲍建明
 * @date 2015年3月16日 上午10:38:21
 * @version 1.0.0
 */
public class TokenManager {

	public static Map<String, Object> manager = new HashMap<>();
	public static long DEFAULT_TIME = TimeUnit.HOURS.toMillis(1);			//一个小时的过度期
	
	/**
	 * 描述：
	 * <pre>
	 * 	获取Token对象
	 * </pre>
	 * @return
	 */
	public static Token getToken(){
		return (Token) manager.get("token");
	}
	
	/**
	 * 描述：
	 * <pre>
	 * 判断Token是否过期
	 * </pre>
	 * @return
	 */
	public static boolean isExpires(){
		Long expires = (Long)manager.get("expires");
		Long currentTime = System.currentTimeMillis();
		if( (expires + DEFAULT_TIME) <= currentTime){
			return true;
		}
		return false;
	}
	
	//获取权限Token秘钥
	public static String getAuthorization(){
		Token token = getToken();
		if( token == null ){			//第一次
			token = initToken();
		}
		if( isExpires() ){				//过期
			token = initToken();
		}
		return token.getAccess_token();
		//return "YWMt2_oMvMuBEeS_CB8hRgkZSgAAAU1VV-QxYpWsyhX0_HlahjLHJX-CPYivmPI";
	}
	
	
	//初始化Token容器
	private static Token initToken(){
		Token token = IMUtils.getToken();
		manager.put("token", token);
		Long expires = System.currentTimeMillis() + token.getExpires_in();
		manager.put("expires", expires);
		return getToken();
	}
	
	
}
