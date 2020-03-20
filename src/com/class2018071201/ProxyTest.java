package com.class2018071201;

public class ProxyTest {

    public static void main(String[] args) {
        ConnectionInterface connectionInterface = new ProxyConnection(new ConnectionS());
        connectionInterface.close();
    }
}
