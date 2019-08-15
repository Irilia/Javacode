package ListTest;

import java.util.Arrays;

public class MyArray<E> {
    //实际存放元素的数组
    private E[] elementData;
    //全局常量
    private final static int DEFAULT_CAPACTI = 10;
    //数组长度
    private int size;

    public MyArray(){
        this(DEFAULT_CAPACTI);
    }

    public MyArray(int initCap){
        elementData = (E[]) new Object[initCap];
    }

    public void add(E e){
        //此时数组已经放不下元素了，需要扩容
        if(size == elementData.length){
            int oldCap = elementData.length;
            int newCap = oldCap + ((size<64)?oldCap:oldCap>>1);
            if(newCap > Integer.MAX_VALUE-8){
                throw new IndexOutOfBoundsException("数组元素过多");
            }
            elementData = Arrays.copyOf(elementData,newCap);
        }
        elementData[size++] = e;
    }

}
