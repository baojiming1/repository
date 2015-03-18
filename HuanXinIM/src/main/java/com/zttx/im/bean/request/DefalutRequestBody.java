/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.bean.request</p>
 * <p>文件名：DefalutRequestBody.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月12日-上午10:46:41</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.bean.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**<p>名称：DefalutRequestBody.java</p>
 * <p>描述：</p>
 * <pre>
 *         
 * </pre>
 * @author 鲍建明
 * @date 2015年3月12日 上午10:46:41
 * @version 1.0.0
 */
public abstract class DefalutRequestBody implements RequestBody {

	private static final long serialVersionUID = 2849955621720415120L;
	
	@JSONField(deserialize=false)
	public Object _this;
	
	public DefalutRequestBody(){
		_this = this;
	}
	
	@Override
	public String toJSONString() {
		return JSON.toJSONString(_this, SerializerFeature.WriteEnumUsingToString);
	}

}
