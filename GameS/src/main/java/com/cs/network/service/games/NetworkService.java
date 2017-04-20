package com.cs.network.service.games;

import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cs.network.handler.games.CloseHandler;
import com.cs.network.handler.games.ReceiptsHandler;
import com.cs.network.handler.games.SendHandler;



/**
 * 接收&傳送 包封 服務 實作
 * @author Leo 
 */
@Controller
public class NetworkService{
	
	private static final Logger LOG = LoggerFactory.getLogger(NetworkService.class);
	
	@Autowired
	private ReceiptsHandler receiptsHandler;	
	@Autowired
	private SendHandler sendHandler;
	@Autowired
	private CloseHandler closeHandler;

	/**
	 * 依據封包內容反射處理方法
	 * @param session 玩家連線
	 * @param message 封包內容
	 */
	public void receipts(IoSession session, Object message) {
		receiptsHandler.receiptsObject(session, message);
	}

	/**
	 * 傳送封包
	 * @param session 玩家連線
	 * @param message 訊息內容
	 */
	public void send(IoSession session, Object message) {
		try {
			sendHandler.messageSent(session, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 玩家不再線上時 清除玩家連線
	 * @param session 玩家連線
	 */
	public void close(IoSession session) {
		try {
			closeHandler.clearUser(session);
//			System.out.println("close sessionID:"+session.getId());
		} catch (Exception e) {
			LOG.error("close error",e);
			e.printStackTrace();
		}
	}

}
