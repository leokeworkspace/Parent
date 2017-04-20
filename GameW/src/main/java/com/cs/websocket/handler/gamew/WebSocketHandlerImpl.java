package com.cs.websocket.handler.gamew;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.cs.network.handler.gamew.ReceiptsHandler;

/**
 * webSocket處理程式
 * 
 * @author childhood-leo
 */
@Component
public class WebSocketHandlerImpl implements WebSocketHandler {
	private static final Logger	LOG	= LoggerFactory.getLogger(WebSocketHandlerImpl.class);
	@Autowired
	private ReceiptsHandler		receiptsHandler;

	/**
	 * 建立连接后
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		LOG.debug("afterConnectionEstablished:" + session.getId());
		LOG.debug("建立连接后 afterConnectionEstablished:" + session.getId());
	}

	/**
	 * 消息处理，在客户端通过Websocket API发送的消息会经过这里，然后进行相应的处理
	 */
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		if (message.getPayloadLength() == 0)
			return;
		LOG.debug("handleMessage:" + session.getId() + " message:" + message.getPayload().toString());
		try {
			JSONObject rqJso = JSONObject.fromObject(message.getPayload().toString());
			receiptsHandler.receiptsObject(session, rqJso);
		}
		catch (net.sf.json.JSONException e) {
			LOG.error(" message format error:" + message.getPayload().toString(), e);
		}
	}

	/**
	 * 消息传输错误处理
	 */
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		LOG.error("handleTransportError:" + session.getId());
	}

	/**
	 * 連線關閉
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		LOG.debug("Websocket:" + session.getId() + "已经关闭");
	}

	/**
	 * 是否分段发送消息
	 * 
	 * @return
	 */
	@Override
	public boolean supportsPartialMessages() {
		return false;
	}
	// /**
	// * 收到客户端消息
	// * @param session
	// * @param message
	// * @throws Exception
	// */
	// public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	// String inquiryId = MapUtils.getString(session.getAttributes(), "inquiryId");
	// int empNo = MapUtils.getInteger(session.getAttributes(), "empNo");
	// TelSocketSessionUtils.sendMessage(inquiryId, empNo, "【来自服务器的复读机】：" + message.getPayload().toString());
	// }
}