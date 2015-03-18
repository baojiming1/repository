/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.builder</p>
 * <p>文件名：URLBuilder.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月12日-上午10:57:43</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.builder;

import com.zttx.im.methods.ImMethod;
import com.zttx.im.utils.AccessUtils;
import com.zttx.im.utils.IMProperties;

/**<p>名称：URLBuilder.java</p>
 * <p>描述：</p>
 * <pre>
 *         
 * </pre>
 * @author 鲍建明
 * @date 2015年3月12日 上午10:57:43
 * @version 1.0.0
 */
public class IMBuilder {

	private ImMethod imMethod;
	private String url;
	
	public static IMBuilder create(ImMethod imMethod){
		return new IMBuilder(imMethod);
	}
	
	IMBuilder(ImMethod imMethod){
		AccessUtils.isNull(imMethod, "ImMethod is must not null");
		this.imMethod = imMethod;
		this.url = IMProperties.getUrl() + imMethod.getUri();
	}
	
	public IMBuilder setFormatParams(String ... params){
		this.url = String.format(this.url, params);
		return this;
	}
	
	public boolean isHttps(){
		return this.url.contains("https://");
	}
	
	public Class<?> getResultClass(){
		return this.imMethod.getResultClass();
	}
	
	public String getUrl(){
		return this.url;
	}
	
	
}
