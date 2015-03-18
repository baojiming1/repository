/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.bean.request</p>
 * <p>文件名：RequestParams.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月12日-下午4:14:15</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.bean.request;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**<p>名称：RequestParams.java</p>
 * <p>描述：</p>
 * <pre>
 *         
 * </pre>
 * @author 鲍建明
 * @date 2015年3月12日 下午4:14:15
 * @version 1.0.0
 */
public class RequestParams implements RequestBody{

	private static final long serialVersionUID = 6129531243117080996L;

	@Override
	public String toJSONString() {
		return JSON.toJSONString(this.params);
	}

	private Map<String, Object> params;
	
	public RequestParams(){
		this.params = new HashMap<String, Object>();
	}
	
	public void add(String k, Object v){
		params.put(k, v);
	}
	
	
}
