package com.cs.network.handler.game;

import java.io.IOException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.cs.network.model.game.SocketVO;
import com.cs.service.game.GameService;


//import com.ch.server.dataPool.InitDataPool;
import net.sf.json.JSONObject;

/**
 * 依據封包內容反射處理方法
 * 
 * @author Leo 最後更新時間:2015年3月18日 上午11:43:28
 */
@Component("ReceiptsHandler")
public class ReceiptsHandler {
	private static final Logger	LOG				= LoggerFactory.getLogger(ReceiptsHandler.class);
	@Autowired
	private GameService			gameService;
	
	private static final String	ClassForName	= "com.cs.service.game.GameService";

	// @Autowired
	// private InitDataPool initDataPool;
	/**
	 * 依據封包內容反射處理方法
	 * 
	 * @param session 玩家連線
	 * @param message 封包內容
	 * @author Leo 最後更新時間:2015年3月18日 上午11:43:28
	 */
	public void receiptsObject(WebSocketSession session, JSONObject rqJso) {
		// if (initDataPool.getGameSetting().getTestmode() == 1) {
		// LOG.debug("messagess:" + message.toString());
		// }
		JSONObject _jso = rqJso;
		SocketVO _socketVO = (SocketVO) JSONObject.toBean(_jso, SocketVO.class);
		try {
			Class<?> amfClass = Class.forName(ClassForName);
			if (_socketVO.getParamObject() != null) {
				try {
					// LOG.debug("socketVO.getMethodName():"+socketVO.getMethodName());
					Method method = amfClass.getMethod(_socketVO.getMethodName(), WebSocketSession.class, Object.class);
					method.invoke(gameService, session, _socketVO.getParamObject());
				}
				catch (Exception e) {
					LOG.error(" No this Method have Object:" + _socketVO.getMethodName(), e);
					session.sendMessage(new TextMessage(rqJso.toString() + " Error1"));
				}
			}
			else {
				try {
					Method method = amfClass.getMethod(_socketVO.getMethodName(), WebSocketSession.class);
					method.invoke(gameService, session);
				}
				catch (Exception e) {
					LOG.error(" No this Method no have Object:" + _socketVO.getMethodName(), e);
					session.sendMessage(new TextMessage(rqJso.toString() + " Error2"));
				}
			}
		}
		catch (Exception e) {
			LOG.error(" receiptsObject error :" + _socketVO.getMethodName(), e);
			try {
				session.sendMessage(new TextMessage(rqJso.toString() + " Error3"));
			}
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
