/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.utils</p>
 * <p>文件名：HttpClientUtils.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月11日-下午2:15:05</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.utils;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.log4j.Logger;

import com.zttx.im.bean.request.RequestData;
import com.zttx.im.bean.response.ResultMessage;
import com.zttx.im.builder.IMBuilder;
import com.zttx.im.constant.IMConstant;
import com.zttx.im.exception.IMException;
import com.zttx.im.handler.DefaultIMHandler;
import com.zttx.im.methods.RequestMethod;

/**<p>名称：HttpClientUtils.java</p>
 * <p>描述：</p>
 * <pre>
 *         
 * </pre>
 * @author 鲍建明
 * @date 2015年3月11日 下午2:15:05
 * @version 1.0.0
 */
public class HttpClientUtils {

	private static Logger log = Logger.getLogger(HttpClientUtils.class);
	
	public final static String HTTPS = "https";
	public final static String UTF_8 = "UTF-8";
	public final static Integer AGAIN_COUNT = IMProperties.getAgainCount();
	
	
	/**
	 * 描述：
	 * <pre>
	 * 	发送HTTP请求方法
	 * </pre>
	 * @param builder
	 * @param requestData
	 * @param method
	 * @return
	 */
	public static ResultMessage sendHttp(IMBuilder builder, RequestData requestData,  RequestMethod method){
		HttpClient client = getClient(builder.isHttps());
		ResultMessage result = null;
		for (int i = 1; i <= AGAIN_COUNT; i++) {
			try {
				result = send(client, builder, requestData, method);
				break;
			} catch (ClientProtocolException e) {
				log.error("第" + i + "重试失败：" + e.getMessage());
				if(i == AGAIN_COUNT)
					throw new RuntimeException("还是没有办法连接上，请确认您的操作是否正确." + e.getMessage());;
			} catch (IOException e) {
				log.error("第" + i + "重试失败：" + e.getMessage());
				if(i == AGAIN_COUNT)
					throw new RuntimeException("还是没有办法连接上，请确认您的操作是否正确." + e.getMessage());;
			} catch (IMException e) {
				log.error("第" + i + "重试失败：" + e.getMessage());
				if(i == AGAIN_COUNT)
					throw new RuntimeException("连接环信失败，请检查环境或者检查您的参数问题." + e.getMessage());;
			}
		}
		return result;
		
	}
	
	//请求发送
	private static ResultMessage send(HttpClient client, IMBuilder builder, RequestData requestData,  RequestMethod method) throws ClientProtocolException, IOException, IMException{
		HttpResponse response = null;
		switch (method) {
			case POST:
				response = sendPost(client, builder.getUrl(), requestData);
				break;
			case DELETE:
				response = sendDelete(client, builder.getUrl(), requestData);
				break;
			case GET:
				response = sendGet(client, builder.getUrl(), requestData);
				break;
			case PUT:
				response = sendPut(client, builder.getUrl(), requestData);
				break;
			default:
				throw new RuntimeException("请正确的选择网络的请求类型");
		}
		return new DefaultIMHandler().handler(response, builder.getResultClass());
	}
	
	//发送POST
	private static HttpResponse sendPost(HttpClient client, String url, RequestData requestData) throws ClientProtocolException, IOException{
		HttpPost post = new HttpPost(url);
		post.setHeaders(requestData.toHeadArray());
		if( requestData.getRequestBody() != null ){
			post.setEntity(new StringEntity( requestData.getRequestBody().toJSONString(), IMConstant.UTF_8 ) );
		}
		return client.execute(post);
	}
	
	//发送GET
	private static HttpResponse sendGet(HttpClient client, String url, RequestData requestData) throws ClientProtocolException, IOException{
		HttpGet get = new HttpGet(url);
		get.setHeaders(requestData.toHeadArray());
		return client.execute(get);
	}
	
	//发送PUT
	private static HttpResponse sendPut( HttpClient client, String url, RequestData requestData ) throws ClientProtocolException, IOException{
		HttpPut put = new HttpPut(url);
		put.setHeaders( requestData.toHeadArray() );
		if( requestData.getRequestBody() != null){
			put.setEntity(new StringEntity(requestData.getRequestBody().toJSONString(), IMConstant.UTF_8) );
		}
		return client.execute(put);
	}
	
	//发送DELETE
	private static HttpResponse sendDelete( HttpClient client, String url, RequestData requestData ) throws ClientProtocolException, IOException{
		HttpDelete delete = new HttpDelete(url);
		delete.setHeaders(requestData.toHeadArray());
		return client.execute(delete);
	}
	
	//获取HTTP实体对象
	private static HttpClient getClient(boolean isSSL){
		CloseableHttpClient client = HttpClients.createDefault();
		if( isSSL ){
			TrustStrategy trust = new TrustStrategy(){
				@Override
				public boolean isTrusted(X509Certificate[] chain,
						String authType) throws CertificateException {
					return true;
				}
			};
			try {
				SSLContext sslContext = SSLContexts.custom().useTLS().loadTrustMaterial(null, trust).build();
				LayeredConnectionSocketFactory factory = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);    
				Registry<ConnectionSocketFactory> registryBuilder = RegistryBuilder.<ConnectionSocketFactory>create().register(HTTPS, factory).build(); 
				PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registryBuilder);
				client = HttpClients.custom().setConnectionManager(cm).build();
			} catch (Exception e) {
				log.error(e.getMessage());
				throw new RuntimeException("获取HTTPS请求失败" + e.getMessage());
			}
		}
		return client;
	}
	
	
	
}
