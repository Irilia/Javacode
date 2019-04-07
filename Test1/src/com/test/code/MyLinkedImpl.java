package com.test.code;

import com.test.impl.ILinked;

import java.util.Arrays;

public class MyLinkedImpl implements ILinked {

    private Object[] elemData;
    private int usedSize;
    public static final int CAPACITY = 10;
    //初始化方法：
    //1.getter/setter方法
    //2.构造器构造
    //3.静态代码块/构造块


    public MyLinkedImpl() {
        this.elemData = new Object[CAPACITY];
        this.usedSize = 0;
    }



    private boolean isFull(){
        return this.usedSize == this.elemData.length;
    }


    //在pos位置插入val
    @Override//重写的注解
    public boolean add(int pos, Object data) {
        //1.判断pos的合法性，放入数据后是否会溢出
        /*if(pos<0 || pos>this.usedSize || isFull()){
            return false;
        }*/
        if(pos<0 || pos>this.usedSize-1) {
            return false;
        }
        //二倍扩容
        if(isFull()){
           this.elemData = Arrays.copyOf(this.elemData,this.elemData.length*2);//有返回值
        }
        //native表示底层是c/c++写的，效率很高

        //2.挪数据
        int i = this.usedSize;
        while(i > pos){
            this.elemData[i] = this.elemData[i-1];
            i--;
        }
        this.elemData[pos] = data;

        //3.放入数据 usedSize++
        this.usedSize++;

        return true;
    }



    private boolean isEmpty(){
        return this.usedSize == 0;
    }


    //查找关键字key，找返回下标，没有返回null
    @Override
    public int search(Object key) {
        //key是Object类型，可能传的是null，需要判断
        //如果顺序表是空的没必要找，返回-1
        //数据是引用类型，比较用equals
        if(key == null){
            throw new UnsupportedOperationException("输入异常");
        }
        if(isEmpty()){
            return -1;
        }
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elemData[i].equals(key)){
                return i;
            }
        }
        return -1;
    }




    //查找是否包含关键字是否包含在顺序表中
    @Override
    public boolean contains(Object key) {
        if(key == null){
            throw new UnsupportedOperationException("输入异常");
        }
        if(isEmpty()){
            return false;
        }
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elemData[i].equals(key)){
                return true;
            }
        }
        return false;
    }




    //得到pos位置的值
    @Override
    public Object getPos(int pos) {
        if(pos < 0 || pos >=this.usedSize){
            return null;
        }
        return this.elemData[pos];
    }




    //删除第一次出现的关键字key
    @Override
    public Object remove(Object key) {
        int index = search(key);
        if(index == -1){
            return null;
        }

        Object data = this.elemData[index];
        for (int i = index; i < this.usedSize; i++) {
                this.elemData[i] = this.elemData[i+1];
        }
        this.usedSize--;
        return data;
    }



    private int searchAll(int pos,Object key){
        if(pos < 0 ||pos > this.usedSize){
             throw new UnsupportedOperationException("位置错误");
        }
        if(isEmpty()){
            return -1;
        }
        for (int i = pos; i < this.usedSize; i++) {
            if(this.elemData[i].equals(key)){
                return i;
            }
        }
        return -1;

    }



    //除所有的关键字key
    public Object removeAllKey(Object key){
        int i = 0;
        while(i != this.usedSize){
            int index = searchAll(i,key);
            if(index == -1){
                return null;
            }
            for (int j = index; j < this.usedSize; j++) {
                this.elemData[j] = this.elemData[j+1];
            }
            this.usedSize--;
            i = index;
        }
        return key;

    }



    //得到顺序表长度
    @Override
    public int size() {
        return this.usedSize;
    }



    //打印顺序表
    @Override
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elemData + " ");
        }
        System.out.println();
    }




    //清空顺序表以防内存泄漏
    @Override
    public void clear() {
        for (int i = 0; i < this.usedSize; i++) {
            this.elemData = null;
        }
        this.usedSize = 0;
    }
}
