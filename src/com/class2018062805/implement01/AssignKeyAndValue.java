package com.class2018062805.implement01;

public interface AssignKeyAndValue<T,K,V> {

    K getKey(T t);
    V getValue(T t);
}
