/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.bean.request</p>
 * <p>文件名：Message.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月12日-下午1:16:15</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.bean.request;

import java.util.List;

import com.zttx.im.methods.MessageType;
import com.zttx.im.methods.TargetType;

/**<p>名称：Message.java</p>
 * <p>描述：</p>
 * <pre>
 *         
 * </pre>
 * @author 鲍建明
 * @date 2015年3月12日 下午1:16:15
 * @version 1.0.0
 */
public class RequestMessage<T> extends DefalutRequestBody {

	private static final long serialVersionUID = 4366038398045149502L;
	
	/**
	 * 发送类型
	 */
	private TargetType target_type;
	/**
	 * 注意这里需要用数组,数组长度建议不大于20, 即使只有  
 		一个用户u1或者群组, 也要用数组形式 ['u1'], 给用户发  
 		送时数组元素是用户名,给群组发送时数组元素是groupid
	 */
	private List<String> target;
	
	/**
	 *	信息对象 
	 */
	private M msg;
	
	/**
	 * 表示这个消息是谁发出来的, 可以没有这个属性, 那么就会显示是admin, 如果有的话, 则会显示是这个用户发出的
	 */
	private String from;
	
	/**
	 * 扩展属性, 由app自己定义.可以没有这个字段，但是如果有，值不能是“ext:null“这种形式，否则出错
	 */
	private T ext;
	
	
	
	
	public TargetType getTarget_type() {
		return target_type;
	}




	public void setTarget_type(TargetType target_type) {
		this.target_type = target_type;
	}




	public List<String> getTarget() {
		return target;
	}




	public void setTarget(List<String> target) {
		this.target = target;
	}




	public M getMsg() {
		return msg;
	}




	public void setMsg(M msg) {
		this.msg = msg;
	}




	public String getFrom() {
		return from;
	}




	public void setFrom(String from) {
		this.from = from;
	}


	public T getExt() {
		return ext;
	}

	public void setExt(T ext) {
		this.ext = ext;
	}


	public class M {
		/**
		 * 信息的类型
		 */
		private MessageType type;
		
		/**
		 * 信息内容
		 * 支持类型：txt
		 */
		private String msg;
		
		/**
		 * 成功上传文件返回的uuid
		 * 支持类型：img , audio, video
		 */
		private String url;
		
		/**
		 * 指定一个文件名
		 * 支持类型：img , audio, video
		 */
		private String filename;
		
		/**
		 * 成功上传文件后返回的secret(机密)
		 * 支持类型：img , audio, video
		 */
		private String secret;
		
		/**
		 * 视频播放长度
		 * 支持类型：audio, video
		 */
		private Integer length;
		
		/**
		 * 视频文件大小
		 *  支持类型： video
		 */
		private Long file_length;
		
		/**
		 * 成功上传视频缩略图返回的uuid
		 * 支持类型： video
		 */
		private String thumb;
		
		/**
		 * 成功上传视频缩略图后返回的secret
		 * 支持类型： video
		 */
		private String thumb_secret;
		
		/**
		 * 支持类型： cmd
		 */
		private String action;

		public MessageType getType() {
			return type;
		}

		public void setType(MessageType type) {
			this.type = type;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getFilename() {
			return filename;
		}

		public void setFilename(String filename) {
			this.filename = filename;
		}

		public String getSecret() {
			return secret;
		}

		public void setSecret(String secret) {
			this.secret = secret;
		}

		public Integer getLength() {
			return length;
		}

		public void setLength(Integer length) {
			this.length = length;
		}

		public Long getFile_length() {
			return file_length;
		}

		public void setFile_length(Long file_length) {
			this.file_length = file_length;
		}

		public String getThumb() {
			return thumb;
		}

		public void setThumb(String thumb) {
			this.thumb = thumb;
		}

		public String getThumb_secret() {
			return thumb_secret;
		}

		public void setThumb_secret(String thumb_secret) {
			this.thumb_secret = thumb_secret;
		}

		public String getAction() {
			return action;
		}

		public void setAction(String action) {
			this.action = action;
		}
		
		
		
	}

}
