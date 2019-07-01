package TypeUnit;

import java.util.Arrays;
//动态扩容
public class MyArray<E> {
    private E[] elementData;
    private final static int DEFAULT_CAPACITY = 10;
    private int size;

    public MyArray() {
        this(DEFAULT_CAPACITY);
    }
    public MyArray(int initCap){
        elementData = (E[]) new Object[DEFAULT_CAPACITY];
    }
    public void sdd(E e) {
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
