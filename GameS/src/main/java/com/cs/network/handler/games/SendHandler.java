package com.cs.network.handler.games;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cs.network.model.games.SocketVO;


/**
 * 傳送封包處理
 * @author Leo 
 * @param <T>
 */
@Component("SendHandler")
public class SendHandler<T>  extends IoHandlerAdapter{
	
	private static final Logger LOG = LoggerFactory.getLogger(CalculatorHandler.class);
	
	/**
	 * 調用mina 傳送封包
	 * @param session 玩家連線
	 * @param message 訊息內容
	 */
    @Override
	public void messageSent(IoSession session, Object message) throws Exception {
		//當消息被成功發送出去的時候，此方法被調用
//    	JSONObject jso = new JSONObject();
//    	jso.fromObject(message);
    	LOG.info("發送訊息給 session["+session.getId()+"] 內容:"+message.toString());
		session.write(message);
	}
    
    /**
	 * 傳送訊息給玩家
	 * @param session 玩家連線
	 * @param rsMethod 方法名稱
	 * @param message 訊息內容
	 */
    public void send(IoSession session, String rsMethod, Object message){
    	if(session==null){
    		return;
    	}
    	LOG.debug("send 發送訊息給 session["+session.getId()+"] 方法:"+rsMethod);
    	SocketVO socketVO = new SocketVO();
    	socketVO.setMethodName(rsMethod);
    	socketVO.setParamObject(message);
    	JSONObject jso = JSONObject.fromObject(socketVO);
    	try {
			this.messageSent(session, jso.toString());
		} catch (Exception e) {
			LOG.error("send error", e);
		}
    }
    
    /**
	 * 傳送大量資料訊息給玩家
	 * @param session 玩家連線
	 * @param rsMethod 方法名稱
	 * @param message 訊息內容
	 * @param status 訊息狀態  0:沒有訊息  1:還有待接收訊息
	 */
    public void sendbypage(IoSession session, String rsMethod, Object message, int status) throws Exception{
    	if(session==null){
    		return;
    	}
    	LOG.debug("sendbypage 發送訊息給 session["+session.getId()+"] 內容: 方法:"+rsMethod +" 狀態:"+status);
    	SocketVO socketVO = new SocketVO();
    	socketVO.setMethodName(rsMethod);
    	JSONObject obj = new  JSONObject();
    	obj.put("data", message);
    	obj.put("status", status);
    	socketVO.setParamObject(obj.toString());
    	JSONObject jso = JSONObject.fromObject(socketVO);    	
    	this.messageSent(session, jso.toString());
    }
    
    
    
    /**
	 * 傳送大量資料訊息給玩家
	 * @param session 玩家連線
	 * @param rsMethod 方法名稱
	 * @param list 訊息內容
	 */
    public void sendByPageData(IoSession session, String rsMethod, List<T> list) throws Exception{
    	int count = 30;
    	int num=0;
    	int page = (int)list.size()/count; //總頁數
    	int remainder = (int)list.size()%count; //餘數
    	int totalPage = page + (remainder>0?1:0);
    	if(list.size()>0){
    		for(int i=1; i<=totalPage; i++){
        		num = count * (i-1);
        		int endType = 1; // 0:沒有資料 1:還有資料
        		
        		if(i == totalPage && i==1){
        			endType = 0;
        			this.sendbypage(session, rsMethod, JSONArray.fromObject(list.subList(num, list.size())).toString(),endType);
        		}else{
        			if(i == totalPage){
        				endType = 0;
            			this.sendbypage(session, rsMethod, JSONArray.fromObject(list.subList(num, list.size())).toString(),endType);

        			}else{
        				endType = 1;
            			this.sendbypage(session, rsMethod, JSONArray.fromObject(list.subList(num, num+count)).toString(),endType);
        			}
        		}
        				
        		if(endType == 0){
        			return;
        		}
        	}
    	}else{
			this.sendbypage(session, rsMethod, JSONArray.fromObject(list).toString(),0);
    	}
    	
    }
    
    


}
