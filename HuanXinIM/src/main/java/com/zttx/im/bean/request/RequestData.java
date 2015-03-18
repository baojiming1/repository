/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.bean</p>
 * <p>文件名：RequestData.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月12日-上午9:52:07</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.bean.request;

import java.util.List;

import org.apache.http.Header;

import com.zttx.im.utils.AccessUtils;

/**<p>名称：RequestData.java</p>
 * <p>描述：</p>
 * <pre>
 *         
 * </pre>
 * @author 鲍建明
 * @date 2015年3月12日 上午9:52:07
 * @version 1.0.0
 */
public class RequestData {
	
	private List<Header> headers;
	private RequestBody requestBody;

	
	/**构造器
	 * <pre></pre>
	 * @param headers
	 */
	public RequestData(List<Header> headers, RequestBody requestBody) {
		super();
		this.headers = headers;
		this.requestBody = requestBody;
	}
	
	/**构造器
	 * <pre></pre>
	 * @param headers
	 */
	public RequestData(List<Header> headers) {
		super();
		this.headers = headers;
	}





	/**构造器
	 * <pre></pre>
	 */
	public RequestData() {
		super();
	}
	
	
	public RequestBody getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(RequestBody requestBody) {
		this.requestBody = requestBody;
	}
	
	public List<Header> getHeaders() {
		return headers;
	}

	public void setHeaders(List<Header> headers) {
		this.headers = headers;
	}


	public Header[] toHeadArray(){
		AccessUtils.isNull(headers, "RequestHeader must not null or null Collection");
		return this.headers.toArray(new Header[]{});
	}

}
