/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.handler</p>
 * <p>文件名：IMHandler.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月12日-上午11:06:18</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.handler;

import org.apache.http.HttpResponse;

import com.zttx.im.bean.response.ResultMessage;
import com.zttx.im.exception.IMException;

/**<p>名称：IMHandler.java</p>
 * <p>描述：</p>
 * <pre>
 *   
 * </pre>
 * @author 鲍建明
 * @date 2015年3月12日 上午11:06:18
 * @version 1.0.0
 */
public interface IMHandler {

	public ResultMessage handler(HttpResponse response, Class<?> resultClass) throws IMException;
}
