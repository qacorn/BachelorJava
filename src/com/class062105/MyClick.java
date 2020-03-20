package com.class062105;

public class MyClick {
    public interface OnClickListener{
        void onClick();
    }

    public static void main(String[] args) {
        OnClickListener onClickListener = new OnClickListener() {
            public void onClick() {
                System.out.println("匿名内部内!");
            }
        };
        onClickListener.onClick();
    }
}
