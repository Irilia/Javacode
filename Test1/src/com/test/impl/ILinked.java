package com.test.impl;

public interface ILinked {
    //在pos位置插入val
    boolean add(int pos,Object data);
    //查找关键字key，找返回下标，没有返回null
    int search(Object key);
    //查找是否包含关键字是否包含在顺序表中
    boolean contains(Object key);
    //得到pos位置的值
    Object getPos(int pos);
    //删除第一次出现的关键字key
    Object remove(Object key);
    //删除所有的关键字key
    Object removeAllKey(Object key);
    //得到顺序表长度
    int size();
    //打印顺序表
    void display();
    //清空顺序表以防内存泄漏
    void clear();
}
