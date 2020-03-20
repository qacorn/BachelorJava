package com.class2018071201;

public class ConnectionS implements ConnectionInterface {
    @Override
    public void close() {
        System.out.println("Connection closed!");
    }
}
