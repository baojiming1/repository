/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.utils</p>
 * <p>文件名：HttpClientUtilsTest.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月11日-下午3:40:13</p>
 * Copyright (c) 2015singno公司-版权所有
 *//*
package com.zttx.im.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.zttx.im.bean.MessageBody;
import com.zttx.im.bean.request.RequestHeader;
import com.zttx.im.methods.RequestMethod;

*//**<p>名称：HttpClientUtilsTest.java</p>
 * <p>描述：</p>
 * <pre>
 *         
 * </pre>
 * @author 鲍建明
 * @date 2015年3月11日 下午3:40:13
 * @version 1.0.0
 *//*
public class HttpClientUtilsTest {

	@Test
	public void getToken() throws Exception {
		RequestHeader h = new RequestHeader();
		h.setContentType("application/json");
		Map<String, String> data = new HashMap<>();
		data.put("grant_type", "client_credentials");
		data.put("client_id", "YXA601NWcMebEeSVKiW8cb_Qlg");
		data.put("client_secret", "YXA6A_m3L4tMV90in0ZYAZbuZf0X0B4");
		URL url = new URL("http://a1.easemob.com/txsb8637/yueguang/token");
		String dataBody = JSON.toJSONString(data);
		HttpResponse response = HttpClientUtils.sendHttps(url, h, dataBody, RequestMethod.POST);
		System.out.println(JSON.toJSON(response));
		HttpEntity entity = response.getEntity();
		System.out.println(EntityUtils.toString(entity));
	}

	@Test
	public void regisetr() throws Exception{
		RequestHeader h = new RequestHeader();
		h.setContentType("application/json");
		h.setAuthorization("Bearer YWMtmDGZvMe-EeS3eLVeTenIpAAAAU08rwoRjTxnkfFG9jke3VMBoK21GTGhmfo");
		Map<String, String> data = new HashMap<>();
		data.put("username", "txsb_user_003");
		data.put("password", "txsb_user_003");
		data.put("nickname", "天下商帮测试用户3号");
		URL url = new URL("https://a1.easemob.com/txsb8637/yueguang/users");
		String dataBody = JSON.toJSONString(data);
		HttpResponse response = HttpClientUtils.sendHttps(url, h, dataBody, RequestMethod.POST);
		HttpEntity entity = response.getEntity();
		System.out.println(EntityUtils.toString(entity, "UTF-8"));
	}
	
	// 添加到黑名单
	@Test
	public void addHei() throws Exception{
		RequestHeader h = new RequestHeader();
		h.setContentType("application/json");
		h.setAuthorization("Bearer YWMtmDGZvMe-EeS3eLVeTenIpAAAAU08rwoRjTxnkfFG9jke3VMBoK21GTGhmfo");
		Map<String, Object> data = new HashMap<>();
		String[] s = new String[]{"txsb_user_002"};
		data.put("usernames", s);
		URL url = new URL("http://a1.easemob.com/txsb8637/yueguang/users/txsb_user_001/blocks/users");
		String dataBody = JSON.toJSONString(data);
		HttpResponse response = HttpClientUtils.sendHttps(url, h, dataBody, RequestMethod.POST);
		HttpEntity entity = response.getEntity();
		System.out.println(EntityUtils.toString(entity, "UTF-8"));
	}
	
	//发送文本信息
	@Test
	public void sendTextMsg() throws Exception{
		RequestHeader h = new RequestHeader();
		h.setContentType("application/json");
		h.setAuthorization("Bearer YWMtmDGZvMe-EeS3eLVeTenIpAAAAU08rwoRjTxnkfFG9jke3VMBoK21GTGhmfo");
		Map<String, Object> msg = new HashMap<>();
		msg.put("type", "txt");
		msg.put("msg", "我是测试君002");
		MessageBody data = new MessageBody();
		
		data.setTarget_type("users");
		data.setTarget(new String[]{"txsb_user_002"});
		data.setFrom("txsb_user_001");
		data.setMsg(msg);
		URL url = new URL("http://a1.easemob.com/txsb8637/yueguang/messages");
		String dataBody = JSON.toJSONString(data);
		HttpResponse response = HttpClientUtils.sendHttps(url, h, dataBody, RequestMethod.POST);
		HttpEntity entity = response.getEntity();
		System.out.println(EntityUtils.toString(entity, "UTF-8"));
	}
	
	//获取离线消息
	@Test
	public void getTextMsg() throws Exception{
		RequestHeader h = new RequestHeader();
		h.setContentType("application/json");
		h.setAuthorization("Bearer YWMtmDGZvMe-EeS3eLVeTenIpAAAAU08rwoRjTxnkfFG9jke3VMBoK21GTGhmfo");
		URL url = new URL("http://a1.easemob.com/txsb8637/yueguang/users/txsb_user_002/offline_msg_count");
		HttpResponse response = HttpClientUtils.sendGet(url, h, null, RequestMethod.POST);
		HttpEntity entity = response.getEntity();
		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println(EntityUtils.toString(entity, "UTF-8"));
	}
	
	@Test
	public void getMsg() throws Exception{
		RequestHeader h = new RequestHeader();
		h.setContentType("application/json");
		h.setAuthorization("Bearer YWMtmDGZvMe-EeS3eLVeTenIpAAAAU08rwoRjTxnkfFG9jke3VMBoK21GTGhmfo");
		URL url = new URL("http://a1.easemob.com/txsb8637/yueguang/chatmessages");
		HttpResponse response = HttpClientUtils.sendGet(url, h, null, RequestMethod.POST);
		HttpEntity entity = response.getEntity();
		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println(EntityUtils.toString(entity, "UTF-8"));
		
	}
	
	@Test
	public void getHeiMingDan() throws Exception{
		RequestHeader h = new RequestHeader();
		h.setContentType("application/json");
		h.setAuthorization("Bearer YWMtmDGZvMe-EeS3eLVeTenIpAAAAU08rwoRjTxnkfFG9jke3VMBoK21GTGhmfo");
		URL url = new URL("https://a1.easemob.com/txsb8637/yueguang/users/txsb_user_001/blocks/users");
		HttpResponse response = HttpClientUtils.sendGet(url, h, null, RequestMethod.POST);
		HttpEntity entity = response.getEntity();
		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println(EntityUtils.toString(entity, "UTF-8"));
	}
}
*/