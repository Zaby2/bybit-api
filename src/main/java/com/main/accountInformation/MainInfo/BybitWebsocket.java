package com.main.accountInformation.MainInfo;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;


@ClientEndpoint
public class BybitWebsocket {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Connected to endpoint: " + session.getBasicRemote());
            Connector.session=session;
            //System.out.println(Connector.session);

    }
    @OnMessage
    public void processMessage(String message) {
        System.out.println("Received message in client: " + message);
    }


}
