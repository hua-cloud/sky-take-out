package com.sky.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * websocket服务
 */
@Component
@ServerEndpoint("/ws/{sid}")
public class WebSocketServer {

    // 存放会话对象
    private static Map<String, Session> sessionMap = new HashMap<>();

    /**
     * 连接建立成功后调用的方法
     * @param session
     * @param sid
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
        System.out.println("客户端" + sid + "建立连接");
        sessionMap.put(sid, session);

    }

    /**
     * 收到来自客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param sid
     */
    @OnMessage
    public void onMessage(String message, @PathParam("sid") String sid) {
        System.out.println("收到来自客户端" + sid + "的信息" + message);
    }

    /**
     * 连接关闭调用的方法
     * @param sid
     */
    @OnClose
    public void onClose(@PathParam("sid") String sid) {
        System.out.println("客户端" + sid + "连接断开");
        sessionMap.remove(sid);
    }

    /**
     * 向所有客户端群发消息
     * @param message
     */
    public void sendToAllClient(String message) {
        Collection<Session> sessions = sessionMap.values();
        for (Session session : sessions) {
            try {
                // 向客户端发送消息
                session.getBasicRemote().sendText(message);
            } catch(Exception e) {
                e.printStackTrace();
            }

        }
    }
}
