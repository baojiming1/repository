/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.builder</p>
 * <p>文件名：RequestBuilder.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月12日-上午9:37:22</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.builder;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import com.zttx.im.bean.request.RequestBody;
import com.zttx.im.bean.request.RequestData;
import com.zttx.im.bean.request.RequestHeader;
import com.zttx.im.bean.request.RequestParams;
import com.zttx.im.constant.IMConstant;
import com.zttx.im.utils.AccessUtils;

/**<p>名称：RequestBuilder.java</p>
 * <p>描述：</p>
 * <pre>
 *         
 * </pre>
 * @author 鲍建明
 * @date 2015年3月12日 上午9:37:22
 * @version 1.0.0
 */
public final class RequestBuilder {

	
	private RequestHeader requestHeader;
	
	private RequestBody requestBody;
	
	public static  RequestBuilder create(){
		return new RequestBuilder();
	}
	
	RequestBuilder(){
		this.requestHeader = new RequestHeader(IMConstant.HEAD_JSON_VALUE);
	}
	
	
	/**
	 * 描述：
	 * <pre>
	 * 设置验证信息
	 * </pre>
	 * @return
	 */
	public RequestBuilder setAuthorizationHeader(String authorization){
		this.requestHeader.setAuthorization("Bearer " + authorization);
		return this;
	}
	
	
	/**
	 * 描述：
	 * <pre>
	 * 	设置请求参数
	 * </pre>
	 * @param k
	 * @param v
	 * @return
	 */
	public RequestBuilder setRequestParams(String k, Object v){
		RequestParams params = new RequestParams();
		params.add(k, v);
		this.requestBody = params;
		return this;
	}
	
	/**
	 * 描述：
	 * <pre>
	 * 	设置请求参数体
	 * </pre>
	 * @param requestBody
	 * @return
	 */
	public RequestBuilder setRequestBody(RequestBody requestBody){
		this.requestBody = requestBody;
		return this;
	}
	
	/**
	 * 描述：
	 * <pre>
	 * 	构建请求数据体对象
	 * </pre>
	 * @return
	 */
	public RequestData build(){
		List<Header> headers = getHeader();
		if( this.requestBody == null ){
			return new RequestData(headers);
		}
		return new RequestData(headers, requestBody);
	}
	
	
	
	
	
	//转换请求头信息
	private List<Header> getHeader(){
		List<Header> headers = new ArrayList<>();
		headers.add(new BasicHeader(IMConstant.HEAD_JSON_KEY, this.requestHeader.getContentType() ));
		if( AccessUtils.isNotNull(requestHeader.getAuthorization()) ){
			headers.add(new BasicHeader(IMConstant.HEAD_AUTHORIZATION_KEY, requestHeader.getAuthorization()  ));
		}
		return headers;
	}
	
	
	
}
