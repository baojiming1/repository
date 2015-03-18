/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.bean</p>
 * <p>文件名：MessageBody.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月11日-下午3:37:17</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.bean;

import java.util.Map;

/**<p>名称：MessageBody.java</p>
 * <p>描述：</p>
 * <pre>
 *         
 * </pre>
 * @author 鲍建明
 * @date 2015年3月11日 下午3:37:17
 * @version 1.0.0
 */
public class MessageBody {

	private String target_type;
	private String[] target;
	private Map<String, Object> msg;
	private String from;
	private Map<String, Object> ext;
	
	public String getTarget_type() {
		return target_type;
	}
	public void setTarget_type(String target_type) {
		this.target_type = target_type;
	}
	public String[] getTarget() {
		return target;
	}
	public void setTarget(String[] target) {
		this.target = target;
	}
	public Map<String, Object> getMsg() {
		return msg;
	}
	public void setMsg(Map<String, Object> msg) {
		this.msg = msg;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public Map<String, Object> getExt() {
		return ext;
	}
	public void setExt(Map<String, Object> ext) {
		this.ext = ext;
	}
	
	/*"target_type" : "users", // users 给用户发消息, chatgroups 给群发消息
    "target" : ["u1", "u2", "u3"], // 注意这里需要用数组,数组长度建议不大于20, 即使只有一个用户,   
                                   // 也要用数组 ['u1'], 给用户发送时数组元素是用户名,给群组发送时  
                                   // 数组元素是groupid
    "msg" : {
        "type" : "txt",
        "msg" : "hello from rest" //消息内容，参考[聊天记录](http://developer.easemob.com/docs/emchat/rest/chatmessage.html)里的bodies内容
        },
    "from" : "jma2", //表示这个消息是谁发出来的, 可以没有这个属性, 那么就会显示是admin, 如果有的话, 则会显示是这个用户发出的    
    "ext" : { //扩展属性, 由app自己定义.可以没有这个字段，但是如果有，值不能是“ext:null“这种形式，否则出错
        "attr1" : "v1",
        "attr2" : "v2"
    }  */
	
}
