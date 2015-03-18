/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.bean</p>
 * <p>文件名：ResponseBody.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月12日-上午9:38:38</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.bean.request;

import java.io.Serializable;

/**<p>名称：ResponseBody.java</p>
 * <p>描述：</p>
 * <pre>
 *         
 * </pre>
 * @author 鲍建明
 * @date 2015年3月12日 上午9:38:38
 * @version 1.0.0
 */
public interface RequestBody extends Serializable {

	/**
	 * 描述：
	 * <pre>
	 * 	转成JSON字符串
	 * </pre>
	 * @return
	 */
	public String toJSONString();
}
