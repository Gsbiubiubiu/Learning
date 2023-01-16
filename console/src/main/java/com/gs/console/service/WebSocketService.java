package com.gs.console.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author: Gaos
 * @Date: 2022-11-14 14:05
 **/
@Slf4j
@ServerEndpoint("/community/{userId}/{roomId}")
@Component
public class WebSocketService {
//    private static final User_MessageService service;
//
//    static {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        service = ((User_MessageService) ctx.getBean("user_MessageServiceImpl"));
//    }

    private static final Map<Integer, CopyOnWriteArraySet<WebSocketService>> rooms = new HashMap<>();

    private Session session;

    private Integer userId;

    private Integer roomId;

    @OnOpen
    public void onOpen(@PathParam(value = "userId") Integer userId, @PathParam(value = "roomId") Integer roomId,  Session session) {
        this.session = session;
//        String[] param = ro_user.split("-");
//        this.roomId = Integer.parseInt(param[0]);
//        this.userId = Integer.parseInt(param[1]);
        this.roomId = roomId;
        this.userId = userId;
        log.info("链接开启 {}", session);
        CopyOnWriteArraySet<WebSocketService> friends = rooms.get(roomId);
        if (friends == null) {
            synchronized (rooms) {
                if (!rooms.containsKey(roomId)) {
                    friends = new CopyOnWriteArraySet<>();
                    rooms.put(roomId, friends);
                }
            }
        }
        friends.add(this);
    }

    @OnClose
    public void onClose() {
        CopyOnWriteArraySet<WebSocketService> friends = rooms.get(roomId);
        if (friends != null) {
            friends.remove(this);
        }
    }

    @OnMessage
    public void onMessage(final String message, Session session) {
        //新建线程来保存用户聊天信息
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                service.save(new User_Message(0, userId, message, roomId, new Date()));
//            }
//        }).start();
        log.info("发送消息{}", message);
        CopyOnWriteArraySet<WebSocketService> friends = rooms.get(roomId);
        log.info("发送对象{}", friends);
        if (friends != null) {
            for (WebSocketService item : friends) {
                item.session.getAsyncRemote().sendText(message);
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.info("发生错误" + new Date());
        error.printStackTrace();
    }
}