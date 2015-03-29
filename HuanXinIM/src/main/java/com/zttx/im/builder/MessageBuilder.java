/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.builder</p>
 * <p>文件名：RequestMessageBuilder.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月12日-下午3:15:45</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.builder;

import java.util.Arrays;

import com.zttx.im.bean.request.RequestMessage;
import com.zttx.im.bean.request.RequestMessage.M;
import com.zttx.im.methods.MessageType;
import com.zttx.im.methods.TargetType;
import com.zttx.im.utils.AccessUtils;

/**<p>名称：RequestMessageBuilder.java</p>
 * <p>描述：</p>
 * <pre>
 *        拼接RequestMessage对象 
 * </pre>
 * @author 鲍建明
 * @date 2015年3月12日 下午3:15:45
 * @version 1.0.0
 */
public class MessageBuilder<T> {

	private RequestMessage<T> message;
	
	public static <T> MessageBuilder<T> create(){
		return new MessageBuilder<T>();
	}
	
	MessageBuilder(){
		this.message = new RequestMessage<T>();
	}
	
	/**
	 * 描述：
	 * <pre>
	 * 设置发送人和类型
	 * </pre>
	 * @param target_type
	 * @param targets
	 * @return
	 */
	public MessageBuilder<T> setGoTo(TargetType target_type, String... targets){
		this.message.setTarget_type(target_type);
		this.message.setTarget( Arrays.asList(targets) );
		return this;
	}
	
	/**
	 * 描述：
	 * <pre>
	 * 设置信息发起者,不传默认为"admin"
	 * </pre>
	 * @param from
	 * @return
	 */
	public MessageBuilder<T> setForm(String from){
		this.message.setFrom(from);
		return this;
	}
	
	/**
	 * 描述：
	 * <pre>
	 * 设置扩展信息
	 * </pre>
	 * @param ext
	 * @return
	 */
	public MessageBuilder<T> setExt(T ext){
		this.message.setExt(ext);
		return this;
	}
	
	/**
	 * 描述：
	 * <pre>
	 * 	构建发送普通文本信息
	 * </pre>
	 * @param type
	 * @param msg
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MessageBuilder<T> setTextMsg( String msg){
		M m = message.new M();
		m.setType(MessageType.txt);
		m.setMsg(msg);
		this.message.setMsg(m);
		return this;
	}
	
	/**
	 * 描述：
	 * <pre>
	 * 构建信息对象
	 * </pre>
	 * @return
	 */
	public RequestMessage<T> build(){
		AccessUtils.isNull(message.getTarget_type(), "信息的发送类型不能为空");
		AccessUtils.isNull(message.getTarget(), "信息的接收者不能为空");
		AccessUtils.isNull(message.getMsg(), "信息内容对象不能为空");
		return this.message;
	}
	
	
	/**
	 * 描述：
	 * <pre>
	 * 构建图片信息对象
	 * </pre>
	 * @param url
	 * @param filename
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MessageBuilder<T> setImgMsg(String url, String filename){
		M m = message.new M();
		m.setType(MessageType.img);
		m.setUrl(url);
		m.setFilename(filename);
		this.message.setMsg(m);
		return this;
	}
	
	/**
	 * 描述：
	 * <pre>
	 * 设置透析消息
	 * </pre>
	 * @param action
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MessageBuilder<T> setAction(String action){
		M m = message.new M();
		m.setType(MessageType.cmd);
		m.setAction(action);
		this.message.setMsg(m);
		return this;
	}
	
}
