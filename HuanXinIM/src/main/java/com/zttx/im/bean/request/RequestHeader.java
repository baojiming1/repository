/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.bean</p>
 * <p>文件名：RequestHeader.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月11日-下午2:09:21</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.bean.request;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import com.zttx.im.utils.AccessUtils;

/**<p>名称：RequestHeader.java</p>
 * <p>描述：</p>
 * <pre>
 *    请求头部数据     
 * </pre>
 * @author 鲍建明
 * @date 2015年3月11日 下午2:09:21
 * @version 1.0.0
 */
public class RequestHeader {
	
	private String ContentType;
	private String authorization;
	
	
	/**构造器
	 * <pre></pre>
	 * @param contentType
	 */
	public RequestHeader(String contentType) {
		super();
		ContentType = contentType;
	}


	/**构造器
	 * <pre></pre>
	 */
	public RequestHeader() {
		super();
	}

	/**构造器
	 * <pre></pre>
	 * @param contentType
	 * @param authorization
	 */
	public RequestHeader(String contentType, String authorization) {
		super();
		ContentType = contentType;
		this.authorization = authorization;
	}
	
	
	
	public String getContentType() {
		return ContentType;
	}
	public void setContentType(String contentType) {
		ContentType = contentType;
	}
	public String getAuthorization() {
		return authorization;
	}
	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}
	
	public List<Header> toHeader(){
		List<Header> headers = new ArrayList<>();
		if( AccessUtils.isNotNull(ContentType) ){
			headers.add(new BasicHeader("Content-Type", getContentType()));
		}
		if( AccessUtils.isNotNull(authorization)){
			headers.add(new BasicHeader("Authorization", getAuthorization()));
		}
		return headers;
	}
	
}
