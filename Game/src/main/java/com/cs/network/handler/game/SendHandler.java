package com.cs.network.handler.game;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.cs.network.model.game.SocketVO;

/**
 * 傳送封包處理
 */
@Component
public class SendHandler {
	private static final Logger	LOG	= LoggerFactory.getLogger(SendHandler.class);

	/**
	 * 調用mina 傳送封包
	 * 
	 * @param session 玩家連線
	 * @param message 訊息內容
	 * @author Leo 最後更新時間:2015年3月18日 下午12:03:47
	 */
	public void messageSent(WebSocketSession session, String message) throws Exception {
		// 當消息被成功發送出去的時候，此方法被調用
		// JSONObject jso = new JSONObject();
		// jso.fromObject(message);
		LOG.info("發送訊息給 session[" + session.getId() + "] 內容:" + message.toString());
		session.sendMessage(new TextMessage(message));
	}

	/**
	 * 傳送訊息給玩家
	 * 
	 * @param session 玩家連線
	 * @param rsMethod 方法名稱
	 * @param message 訊息內容
	 * @author Leo 最後更新時間:2015年3月18日 下午12:03:47
	 */
	public void send(WebSocketSession session, String rsMethod, Object message) throws Exception {
		LOG.debug("send 發送訊息給 session[" + session.getId() + "] 方法:" + rsMethod);
		SocketVO socketVO = new SocketVO();
		socketVO.setMethodName(rsMethod);
		socketVO.setParamObject(message);
		JSONObject jso = JSONObject.fromObject(socketVO);
		this.messageSent(session, jso.toString());
	}

	/**
	 * 傳送大量資料訊息給玩家
	 * 
	 * @param session 玩家連線
	 * @param rsMethod 方法名稱
	 * @param message 訊息內容
	 * @param status 訊息狀態 0:沒有訊息 1:還有待接收訊息
	 * @author Leo 最後更新時間:2015年3月18日 下午12:03:47
	 */
	public void sendbypage(WebSocketSession session, String rsMethod, Object message, int status) throws Exception {
		LOG.debug("sendbypage 發送訊息給 session[" + session.getId() + "] 內容: 方法:" + rsMethod + " 狀態:" + status);
		SocketVO socketVO = new SocketVO();
		socketVO.setMethodName(rsMethod);
		JSONObject obj = new JSONObject();
		obj.put("data", message);
		obj.put("status", status);
		socketVO.setParamObject(obj.toString());
		JSONObject jso = JSONObject.fromObject(socketVO);
		this.messageSent(session, jso.toString());
	}

	/**
	 * 廣播訊息
	 * 
	 * @param message
	 * @throws IOException
	 */
	public void broadcast(final String message) throws IOException {
		LOG.debug("廣播 訊息內容:" + message);
		// Iterator<Entry<Long, WebSocketSession>> it = userSocketSessionMap
		// .entrySet().iterator();
		//
		// // 多线程群发
		// while (it.hasNext()) {
		//
		// final Entry<Long, WebSocketSession> entry = it.next();
		//
		// if (entry.getValue().isOpen()) {
		// // entry.getValue().sendMessage(message);
		// new Thread(new Runnable() {
		//
		// public void run() {
		// try {
		// if (entry.getValue().isOpen()) {
		// entry.getValue().sendMessage(message);
		// }
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
		//
		// }).start();
		// }
		//
		// }
	}
}
