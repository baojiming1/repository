/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.utils</p>
 * <p>文件名：AccessUtils.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月11日-下午2:41:02</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.utils;

import java.util.Collection;

/**<p>名称：AccessUtils.java</p>
 * <p>描述：</p>
 * <pre>
 *         
 * </pre>
 * @author 鲍建明
 * @date 2015年3月11日 下午2:41:02
 * @version 1.0.0
 */
public class AccessUtils {

	
	public static void isNull(String obj, String msg){
		if( obj == null || obj.trim().length() == 0)
			throw new NullPointerException(msg);
	}
	
	
	public static boolean isNotNull(String obj){
		return obj != null && obj.trim().length() != 0;
	}
	
	
	public static void isNull(Object[] arr, String msg){
		if( arr == null || arr.length == 0)
			throw new NullPointerException(msg);
		
	}
	
	
	/**
	 * 描述：
	 * <pre>
	 * 判断集合是否为空
	 * </pre>
	 * @param obj
	 * @param msg
	 */
	public static void isNull(Object obj, String msg){
		if( obj == null )
			throw new NullPointerException(msg);
	}
	
	/**
	 * 描述：
	 * <pre>
	 * 	判断集合是否为空
	 * </pre>
	 * @param coll
	 * @param msg
	 */
	public static void isNull(Collection<?> coll , String msg){
		if( coll == null || coll.size() == 0)
			throw new NullPointerException(msg);
	}
	
}
