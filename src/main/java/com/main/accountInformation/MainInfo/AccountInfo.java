package com.main.accountInformation.MainInfo;

import lombok.Setter;

@Setter
public class AccountInfo {
    boolean testNet = true;
    private String apiKey;
    private String apiSecret;

    public void getInfo() {

        Connector con = new Connector();

        con.getConnection(apiKey, apiSecret);
    }
    public static void main(String[] args) {
        AccountInfo acc = new AccountInfo();
        acc.setApiKey("WsbeDjHgCxk66dDuFy");
        acc.setApiSecret("69VcrfjXJ2qxxk7k5jYKx16aXv0ee8EVVy1F");
        acc.getInfo();
    }
}
