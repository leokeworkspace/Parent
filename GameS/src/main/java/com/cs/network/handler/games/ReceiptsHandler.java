package com.cs.network.handler.games;

import java.lang.reflect.Method;

import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cs.network.model.games.SocketVO;
import com.cs.service.games.GameService;

import net.sf.json.JSONObject;

/**
 * 依據封包內容反射處理方法
 * 
 * @author Leo
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
	 */
	public String receiptsObject(IoSession session, Object message) {
		// if (initDataPool.getGameSetting().getTestmode() == 1)
		// {
		// System.out.println("messagess:"+message.toString());
		// }
		JSONObject _jso = JSONObject.fromObject(message);
		SocketVO _socketVO = (SocketVO) JSONObject.toBean(_jso, SocketVO.class);
		try {
			Class<?> amfClass = Class.forName("cs.server.service.GameService");
			if (_socketVO.getParamObject() != null) {
				try {
					// System.out.println("socketVO.getMethodName():"+socketVO.getMethodName());
					Method method = amfClass.getMethod(_socketVO.getMethodName(), IoSession.class, Object.class);
					method.invoke(gameService, session, _socketVO.getParamObject());
				}
				catch (Exception e) {
					LOG.error(" No this Method have Object:" + _socketVO.getMethodName(), e);
				}
			}
			else {
				try {
					Method method = amfClass.getMethod(_socketVO.getMethodName(), IoSession.class);
					method.invoke(gameService, session);
				}
				catch (Exception e) {
					LOG.error(" No this Method no have Object:" + _socketVO.getMethodName(), e);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			LOG.error(" receiptsObject error :" + _socketVO.getMethodName(), e);
		}
		return null;
	}
}
