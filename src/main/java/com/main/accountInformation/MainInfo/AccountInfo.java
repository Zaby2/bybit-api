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
        acc.setApiKey("");
        acc.setApiSecret("");
        acc.getInfo();
    }
}
