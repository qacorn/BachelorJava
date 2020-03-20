package com.class0618.haimian3;

public class InfoProcesor {

    public InfoProcesor(Object... toVerifyInfoList) {
        verify(toVerifyInfoList);
    }

    private Boolean infoCorrect = false;

    public Boolean getInfoCorrect() {
        return infoCorrect;
    }

    public void setInfoCorrect(Boolean infoCorrect) {
        this.infoCorrect = infoCorrect;
    }

    public void verify(Object... args) {
        this.setInfoCorrect(this.infoCorrect);
    }

    public void printInfo() {}
}
