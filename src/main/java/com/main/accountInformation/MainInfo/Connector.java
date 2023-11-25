package com.main.accountInformation.MainInfo;


import lombok.SneakyThrows;
import org.json.JSONObject;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.websocket.*;
public class Connector {
    ///private final  String uri = "wss://stream.bybit.com/v5/public/linear";
    private final  String uri = "wss://stream.bybit.com/v5/execution/list";
    static Session session;
    static String api_key = "";
    static String api_secret = "";

    public static String generate_signature(String expires){ return sha256_HMAC("GET/realtime"+ expires, api_secret); }

    private static String byteArrayToHexString(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b!=null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toLowerCase();
    }
    @SneakyThrows
    public static String sha256_HMAC(String message, String secret) {
        String hash = "";
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(message.getBytes());
            hash = byteArrayToHexString(bytes);
        return hash;
    }

    public static String getAuthMessage(){
        JSONObject req=new JSONObject();
        req.put("op", "auth");
        List<String> args = new LinkedList<String>();
        String expires = String.valueOf(System.currentTimeMillis()+1000);
        args.add(api_key);
        args.add(expires);
        args.add(generate_signature(expires));
        req.put("args", args);
        return (req.toString());
    }

    public static String subscribe(String op, String argv){
        JSONObject req=new JSONObject();
        req.put("op", op);
        List<String> args = new LinkedList<String>();
        args.add(argv);
        req.put("args", args);
        return req.toString();
    }

    @SneakyThrows
    public void getConnection(String apiKey, String apiSecret) {
        System.setProperty("javax.net.debug", "ssl:handshake");
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(BybitWebsocket.class, URI.create(uri));
           session.getBasicRemote().sendText("{\"op\":\"ping\"}");
           session.getBasicRemote().sendText(getAuthMessage());
           session.getBasicRemote().sendText(subscribe("subscribe", "BTCUSDT"));
           java.io.BufferedReader r=new  java.io.BufferedReader(new java.io.InputStreamReader( System.in));
           String line=r.readLine();
           session.getBasicRemote().sendText(line);
        }
}
