/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.utils</p>
 * <p>文件名：IMUtilsTest.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月12日-下午3:46:35</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.zttx.im.bean.request.IMUser;
import com.zttx.im.bean.request.RequestMessage;
import com.zttx.im.bean.response.Message;
import com.zttx.im.builder.MessageBuilder;
import com.zttx.im.methods.TargetType;

/**<p>名称：IMUtilsTest.java</p>
 * <p>描述：</p>
 * <pre>
 *         
 * </pre>
 * @author 鲍建明
 * @date 2015年3月12日 下午3:46:35
 * @version 1.0.0
 */
public class IMUtilsTest {

	/**
	 * Test method for {@link com.zttx.im.utils.IMUtils#getToken()}.
	 */
	@Test
	public void testGetToken() {
		/*Token token = IMUtils.getToken();
		System.out.println(JSON.toJSONString(token));	//5184000
*/		Long c = System.currentTimeMillis() + 5184000000L; 
		Date d = new Date(c);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String time = dateFormat.format(d);
		System.out.println(time);
		
		int t = 5184000 / 60  / 60 / 24;
		System.out.println(t);
	}

	/**
	 * Test method for {@link com.zttx.im.utils.IMUtils#register(com.zttx.im.bean.request.IMUser)}.
	 */
	@Test
	public void testRegister() {
		IMUser u = new IMUser();
		u.setUsername("imutils005");
		u.setNickname("imutils005");
		u.setPassword("111111");
		Message m = IMUtils.register(u);
		System.out.println(JSON.toJSONString(m));
	}

	/**
	 * Test method for {@link com.zttx.im.utils.IMUtils#getUser(java.lang.String)}.
	 */
	@Test
	public void testGetUser() {
		Message m =  IMUtils.getUser("imutils004");
		System.out.println(JSON.toJSONString(m));
	}

	/**
	 * Test method for {@link com.zttx.im.utils.IMUtils#resetPwd(java.lang.String)}.
	 */
	@Test
	public void testResetPwd() {
		Message m =  IMUtils.resetPwd("imutils004", "123123");
		System.out.println(JSON.toJSONString(m));
	}

	/**
	 * Test method for {@link com.zttx.im.utils.IMUtils#updateNickname(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUpdateNickname() {
		Message m = IMUtils.updateNickname("imutils004", "测试咦嘻嘻嘻嘻");
		System.out.println(JSON.toJSONString(m));
	}

	/**
	 * Test method for {@link com.zttx.im.utils.IMUtils#sendMsg(com.zttx.im.bean.request.RequestMessage)}.
	 */
	@Test
	public void testSendMsg() {
		RequestMessage msg = MessageBuilder.create().setGoTo(TargetType.USERS, "imutils001").setForm("imutils005").setTextMsg("测试一下想信息想想想").build();
		Message m = IMUtils.sendMsg(msg);
		System.out.println(JSON.toJSONString(m));
	}

	@Test
	public void testDelete(){
		Message msg = IMUtils.deleteUser("imutils005");
		System.out.println(JSON.toJSONString(msg));
	}
	
	@Test
	public void testStatus(){
		Message m = IMUtils.getUser("imutils005");
		System.out.println(JSON.toJSONString(m));
		Message msg = IMUtils.getUserStatus("imutils005");
		System.out.println(JSON.toJSONString(msg));
	}
}
