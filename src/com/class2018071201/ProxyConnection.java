package com.class2018071201;

public class ProxyConnection implements ConnectionInterface {

    private ConnectionS connectionS;

    public ProxyConnection(ConnectionS connectionS) {
        this.connectionS = connectionS;
    }

    @Override
    public void close() {
        System.out.println("proxy connection close!");
        connectionS.close();
    }
}
