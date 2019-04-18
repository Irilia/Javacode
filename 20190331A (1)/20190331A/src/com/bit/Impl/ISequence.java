package com.bit.Impl;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO  com.bit.dao;
 * Date: 2019-03-31
 * Time: 11:49
 */
public interface ISequence {
    //在pos位置插入data
    boolean add(int pos,Object data);
    //查找关键字key 找到返回key的下标，没有返回-1;
    int search(Object key);
    //查找是否包含关键字key是否在顺序表当中(这个和search有点冲突)
    boolean contains(Object key);
    //得到pos位置的值
    Object getPos(int pos);
    //删除第一次出现的关键字key
    Object remove(Object key);
    //得到顺序表的长度
    int size();
    //打印顺序表
    void display();
    //清空顺序表以防内存泄漏
    void clear();
}
