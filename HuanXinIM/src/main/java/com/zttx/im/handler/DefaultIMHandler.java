/**<p>项目名：</p>
 * <p>包名：	com.zttx.im.handler</p>
 * <p>文件名：DefaultIMHandler.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015年3月12日-上午11:08:08</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.zttx.im.handler;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.zttx.im.bean.response.ResultMessage;
import com.zttx.im.constant.IMConstant;
import com.zttx.im.exception.ExceptionMsg;
import com.zttx.im.exception.IMException;

/**<p>名称：DefaultIMHandler.java</p>
 * <p>描述：</p>
 * <pre>
 *     默认处理机制：
 *       处理IM请求后，对参数的解析，和请求失败后，启动重试机制的处理器        
 * </pre>
 * @author 鲍建明
 * @date 2015年3月12日 上午11:08:08
 * @version 1.0.0
 */
public class DefaultIMHandler implements IMHandler{

	private static Logger log = Logger.getLogger(DefaultIMHandler.class);
	
	@Override
	public ResultMessage handler(HttpResponse response, Class<?> resultClass) throws IMException {
		int code = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		try {
			String sEn = EntityUtils.toString(entity, IMConstant.UTF_8);
			if(code == 200){						//处理成功后的代码
				return (ResultMessage) JSON.parseObject(sEn, resultClass);
			}else {									//其他错误代码，暂时没定
				
				ExceptionMsg em = JSON.parseObject(sEn, ExceptionMsg.class);
				switch (em.getError()) {
				case "service_resource_not_found":
					log.error(sEn);
					return null;
				default:
					throw new IMException(sEn);
				}
				
				
			}
		} catch (Exception e) {
			throw new IMException(e.getMessage());
		}
	}

}
