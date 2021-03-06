package com.cs.service.gamew;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import com.cs.db.service.gamew.UserService;
import com.cs.network.handler.gamew.SendHandler;

@Service
public class GameService {
	private static final Logger	LOG	= LoggerFactory.getLogger(GameService.class);
	@Autowired
	private SendHandler			sendHandler;
	@Autowired
	private UserService			userService;

	/**
	 * 建立玩家開通遊戲的帳號
	 * 
	 * @param session 玩家連線
	 * @param jsonIn 玩家傳入資料
	 * @throws Exception
	 */
	public void login(WebSocketSession session, Object jsonString) throws Exception {
		JSONObject _jsonIn = JSONObject.fromObject(jsonString);
		LOG.debug("_jsonIn:" + _jsonIn.toString());
		LOG.debug("login start");
		_jsonIn.put("rs", "RS 測試");
		// session.sendMessage(new TextMessage(_jsonIn.toString()));
		int count = userService.findUidCount("1");
		LOG.debug("count:" + count);
		LOG.debug("login end");
		sendHandler.messageSent(session, _jsonIn.toString());
	}
}
