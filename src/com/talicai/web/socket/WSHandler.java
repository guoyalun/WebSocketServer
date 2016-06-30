package com.talicai.web.socket;

import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;

import javax.servlet.http.HttpServletRequest;
import java.lang.Override;import java.lang.String;import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by guoyalun on 6/30/16.
 */
public class WSHandler extends  WebSocketServlet {

    private static final long serialVersionUID = 1L;

    private final AtomicInteger connectionIds = new AtomicInteger(0);
    @Override
    protected StreamInbound createWebSocketInbound(String arg0,
                                                   HttpServletRequest request) {
        return new HelloMessageInbound(connectionIds.getAndIncrement(), request
                .getSession().getId());
    }


}
