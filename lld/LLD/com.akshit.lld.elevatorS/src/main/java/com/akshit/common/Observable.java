package com.akshit.common;

public interface Observable<T, V> {

    public void add(T observable);

    public void remove(T observable);

    public void setData(V obj);

}
