package com.cs.network.handler.games;



import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cs.network.service.games.NetworkService;



/**
 * 處理 Socket 通訊
 * @author Leo 
 */
public class CalculatorHandler extends IoHandlerAdapter {
	
	//紀錄log
	private static final Logger LOG = LoggerFactory.getLogger(CalculatorHandler.class);
	
	//接收&傳送 包封 服務
	@Autowired
	private NetworkService networkService;
	/**
	 * 通信過程中 有錯誤發生(接收的封包格式有錯誤)，此方法被調用
	 * @param session socket連線
	 * @param cause 例外訊息
	 */
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception
	{
		LOG.warn("通信過程中 有錯誤發生 close ip =>["+session.getRemoteAddress()+"]:" , cause);
		//networkService.close(session);        
	}
    
	/**
	 * 當連接被關閉的時候，此方法被調用
	 * @param session socket連線
	 */
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		//networkService.close(session);
		LOG.info("session["+session.getId()+"] 關閉");
    }
    
	/**
	 * 方法是由 io 處理線程來調用的，所以不要在 sessionCreated 方法中執行過多的操作
	 * @param session socket連線
	 */
    @Override
    public void sessionCreated(IoSession session) throws Exception {
    	LOG.info("session["+session.getId()+"] 關閉");
    }
    
    /**
	 * 當連接變成閒置狀態的時候，此方法被調用
	 * @param session socket連線
	 * @param status 閒置狀態
	 */
    @Override
    public void sessionIdle(IoSession session, IdleStatus status)throws Exception {
    	LOG.info("session["+session.getId()+"] 閒置");
    }
    
    /**
	 * 當有新的連接打開的時候，該方法被調用，該方法在 sessionCreated之後被調用
	 * @param session socket連線
	 */
    @Override
    public void sessionOpened(IoSession session) throws Exception {
    	LOG.info("session["+session.getId()+"] 新的連線開啟");
    }
    
    /**
	 * 當消息被成功發送出去的時候，此方法被調用
	 * @param session socket連線
	 * @param message 送出訊息
	 */
    @Override
	public void messageSent(IoSession session, Object message) throws Exception {
    	LOG.info("發送訊息給 session["+session.getId()+"] 內容:"+message.toString());
	}

    /**
	 * 當成功收到消息，此方法被調用
	 * @param session socket連線
	 * @param message 接收訊息
	 */
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception
    {
    	LOG.info("session["+session.getId()+"]  送來訊息內容:"+message.toString());
        //傳回訊息
        //session.write(expression);
        //session.write(message.toString());
    	networkService.receipts(session, message);
    }
}
