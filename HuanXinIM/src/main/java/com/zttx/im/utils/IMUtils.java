/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.utils</p>
 * <p>文件名：IMUtils.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月11日-下午2:22:51</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.utils;

import com.zttx.im.bean.TokenManager;
import com.zttx.im.bean.request.IMUser;
import com.zttx.im.bean.request.RequestData;
import com.zttx.im.bean.request.RequestMessage;
import com.zttx.im.bean.request.TokenRequest;
import com.zttx.im.bean.response.Message;
import com.zttx.im.bean.response.Token;
import com.zttx.im.builder.IMBuilder;
import com.zttx.im.builder.RequestBuilder;
import com.zttx.im.methods.ImMethod;
import com.zttx.im.methods.RequestMethod;

/**<p>名称：IMUtils.java</p>
 * <p>描述：</p>
 * <pre>
 *         
 * </pre>
 * @author 鲍建明
 * @date 2015年3月11日 下午2:22:51
 * @version 1.0.0
 */
public class IMUtils {

	
	/**
	 * 描述：
	 * <pre>
	 * 获取APP管理员Token
	 * </pre>
	 */
	public static Token getToken(){
		TokenRequest requestBody = new TokenRequest();
		requestBody.setClient_id(IMProperties.getClientId());
		requestBody.setClient_secret(IMProperties.getClientSecret());
		requestBody.setGrant_type("client_credentials");
		RequestData requestData = RequestBuilder.create().setRequestBody(requestBody).build();
		IMBuilder builder = IMBuilder.create(ImMethod.TOKEN);
		return  (Token) HttpClientUtils.sendHttp( builder, requestData, RequestMethod.POST);
	}

	/**
	 * 描述：
	 * <pre>
	 * 	授权注册一个用户
	 * </pre>
	 * @param iMUser
	 * @return
	 */
	public static Message register(IMUser iMUser){
		AccessUtils.isNull(iMUser, "用户不能为空");
		AccessUtils.isNull(iMUser.getUsername(), "用户ID不能为空");
		AccessUtils.isNull(iMUser.getPassword(), "用户的密码不能为空");
		RequestData requestData = RequestBuilder.create().setRequestBody(iMUser).setAuthorizationHeader( TokenManager.getAuthorization() ).build();
		IMBuilder builder = IMBuilder.create(ImMethod.REGISTER);
		return (Message) HttpClientUtils.sendHttp(builder, requestData, RequestMethod.POST);
	}
	
	
	/**
	 * 描述：
	 * <pre>
	 * 	获取一个IM用户
	 * </pre>
	 * @param userName
	 * @return
	 */
	public static Message getUser(String userName){
		AccessUtils.isNull(userName, "用户ID不能为空");
		RequestData requestData = RequestBuilder.create().setAuthorizationHeader( TokenManager.getAuthorization() ).build();
		IMBuilder builder = IMBuilder.create(ImMethod.FIND_USER).setFormatParams(userName);
		return (Message) HttpClientUtils.sendHttp(builder, requestData, RequestMethod.GET);
	}
	

	/**
	 * 描述：
	 * <pre>
	 * 重置IM用户密码
	 * </pre>
	 * @param userName
	 * @return
	 */
	public static Message resetPwd(String userName, String newpassword){
		AccessUtils.isNull(userName, "用户ID不能为空");
		AccessUtils.isNull(newpassword, "用户的新密码不能为空");
		RequestData requestData = RequestBuilder.create().setAuthorizationHeader( TokenManager.getAuthorization() ).setRequestParams("newpassword", newpassword).build();
		IMBuilder builder = IMBuilder.create(ImMethod.RESET_PWD).setFormatParams(userName);
		return (Message) HttpClientUtils.sendHttp(builder, requestData, RequestMethod.PUT);
	}
	
	/**
	 * 描述：
	 * <pre>
	 * 	修改用户昵称
	 * </pre>
	 * @param nickname
	 * @return
	 */
	public static Message updateNickname(String userName, String nickname){
		AccessUtils.isNull(userName, "用户ID不能为空");
		AccessUtils.isNull(nickname, "用户的新昵称不能为空");
		RequestData requestData = RequestBuilder.create().setAuthorizationHeader( TokenManager.getAuthorization() ).setRequestParams("nickname", nickname).build();
		IMBuilder builder = IMBuilder.create(ImMethod.UPDATE_NICKNAME).setFormatParams(userName);
		return (Message) HttpClientUtils.sendHttp(builder, requestData, RequestMethod.PUT);
	} 
	
	/**
	 * 描述：
	 * <pre>
	 * 删除IM用户
	 * </pre>
	 * @param userName
	 * @return
	 */
	public static Message deleteUser(String userName){
		AccessUtils.isNull(userName, "用户ID不能为空");
		RequestData requestData = RequestBuilder.create().setAuthorizationHeader( TokenManager.getAuthorization() ).build();
		IMBuilder builder = IMBuilder.create(ImMethod.DELETE_USER).setFormatParams(userName);
		return (Message) HttpClientUtils.sendHttp(builder, requestData, RequestMethod.DELETE);
	} 
	
	/**
	 * 描述：
	 * <pre>
	 * 获取用户的在线状态
	 * </pre>
	 * @param userName
	 * @return
	 */
	public static Message getUserStatus(String userName){
		AccessUtils.isNull(userName, "用户ID不能为空");
		RequestData requestData = RequestBuilder.create().setAuthorizationHeader( TokenManager.getAuthorization() ).build();
		IMBuilder builder = IMBuilder.create(ImMethod.USER_STATUS).setFormatParams(userName);
		return (Message) HttpClientUtils.sendHttp(builder, requestData, RequestMethod.GET);
	}
	
	
	/**
	 * 描述：
	 * <pre>
	 * 发送信息
	 * </pre>
	 * @param msg 可以使用   @MessageBuilder 来拼接RequestMessage对象
	 * @return
	 */
	public static Message sendMsg(RequestMessage<?> msg){
		RequestData requestData = RequestBuilder.create().setRequestBody(msg).setAuthorizationHeader( TokenManager.getAuthorization() ).build();
		IMBuilder builder = IMBuilder.create(ImMethod.SEND_MSG);
		return  (Message) HttpClientUtils.sendHttp(builder, requestData, RequestMethod.POST);
	}
	
	
	
	
}
