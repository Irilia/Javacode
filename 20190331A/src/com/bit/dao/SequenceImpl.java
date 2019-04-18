package com.bit.dao;

import com.bit.Impl.ISequence;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-03-31
 * Time: 11:56
 */
public class SequenceImpl implements ISequence {

    private Object[] elemData;
    private int usedSize;
    public static final int DEFAULT_CAPACITY = 10;

    public SequenceImpl() {
        this.elemData = new Object[DEFAULT_CAPACITY];
        this.usedSize = 0;
    }
    //判断是否为满
    private boolean isFull() {
        return this.usedSize == this.elemData.length;
    }
    @Override
    public boolean add(int pos, Object data) {
        //1、判断pos的合法性，放入数据后是否会发生溢出
        if(pos < 0 || pos > this.usedSize) {
            return  false;
        }
        /*  ctr + shift + /*/
        //System.arraycopy();//native   C/C++
        if(isFull()){
            // 扩容
            this.elemData = Arrays.copyOf(
                    this.elemData,
                    this.elemData.length*2);
            //return  false;
        }
        //2、挪数据
        for (int i = this.usedSize-1; i >= pos ; i--) {
            this.elemData[i+1] = this.elemData[i];
        }
        //3、放入数据  usedSize++;
        this.elemData[pos] = data;
        this.usedSize++;
        return true;
    }

    private boolean isEmpty() {
        return this.usedSize == 0;
    }

    @Override
    public int search(Object key) {
        //null
        if(key == null) {
            throw new UnsupportedOperationException("不可以传入" +
                    "null作为参数");
        }
        if(isEmpty()) {
            return -1;
        }
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elemData[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object key) {
        if(key == null) {
            throw new UnsupportedOperationException("不可以传入" +
                    "null作为参数");
        }
        if(isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elemData[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object getPos(int pos) {
        if(pos < 0 || pos >= this.usedSize) {
            return null;
        }
        return this.elemData[pos];
    }

    @Override
    public Object remove(Object key) {
        int index = search(key);
        if(index == -1) {
            return null;
        }
        Object oldData = this.elemData[index];
        int i = 0;
        for (i = index; i < this.usedSize-1; i++) {
            this.elemData[i] = this.elemData[i+1];
        }
        this.elemData[i+1] = null;
        this.usedSize--;
        return oldData;
    }

    /*public void removeAllKey(Object key){

    }*/

    @Override
    public int size() {
        return this.usedSize;
    }

    @Override
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elemData[i]+ " ");
        }
        System.out.println();
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.usedSize; i++) {
            this.elemData[i] = null;
        }

        this.usedSize = 0;
    }
}
