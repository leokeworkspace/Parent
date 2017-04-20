package com.cs.network.handler.games;

import net.sf.json.JSONObject;

import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cs.data.dataPool.games.InitUserDataPool;
import com.cs.network.model.games.SocketVO;

/**
 * 清除不在線玩家資料
 * 
 * @author Leo
 */
@Component("CloseHandler")
public class CloseHandler {
	private static final Logger	LOG	= LoggerFactory.getLogger(CloseHandler.class);
	@Autowired
	private InitUserDataPool	initDataPool;

	/**
	 * 玩家不再線上時 清除玩家連線
	 * 
	 * @param session 玩家連線
	 */
	public void clearUser(IoSession session) throws Exception {
		try {
			SocketVO _socketVO = new SocketVO();
			_socketVO.setMethodName("closeSocketS2C");
			_socketVO.setParamObject(null);
			JSONObject jso = JSONObject.fromObject(_socketVO);
			session.write(jso.toString());
			// initDataPool.clearUser(session, (String)session.getAttribute("userId"));
			LOG.info("clearUser userID:" + (String) session.getAttribute("userId"));
			session.close(true);
		}
		catch (Exception e) {
			LOG.error("clearUser user no systemDataPool :" + (String) session.getAttribute("userId"), e);
			// System.out.println("clearUser user no systemDataPool :"+(String)session.getAttribute("userId"));
			session.close(true);
		}
	}
}
