package com.class2018070810;

public class Litchi {

    private int id;
    private LitchiStatus litchiStatus;

    public Litchi(int id, LitchiStatus litchiStatus) {
        this.id = id;
        this.litchiStatus = litchiStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LitchiStatus getLitchiStatus() {
        return litchiStatus;
    }

    public void setLitchiStatus(LitchiStatus litchiStatus) {
        this.litchiStatus = litchiStatus;
    }
}
