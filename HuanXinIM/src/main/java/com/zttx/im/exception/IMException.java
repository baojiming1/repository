/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.exception</p>
 * <p>文件名：IOException.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月16日-上午9:03:40</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.exception;

/**<p>名称：IOException.java</p>
 * <p>描述：</p>
 * <pre>
 *         
 * </pre>
 * @author 鲍建明
 * @date 2015年3月16日 上午9:03:40
 * @version 1.0.0
 */
public class IMException extends Exception{

	private static final long serialVersionUID = 3764214374151797836L;
	public IMException(){}
	
	public IMException(String msg){
		super(msg);
	}
	
}
