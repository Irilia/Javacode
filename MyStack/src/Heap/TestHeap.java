package Heap;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TestHeap implements IHeap {
    private int[] elem;
    private int usedSize;
    private final int DEFAULT_SUZE= 10;

    public TestHeap() {
        this.elem = new int[DEFAULT_SUZE];
        this.usedSize = 0;
    }
    @Override
    public void adjustDown(int root, int len) {
        int parent = root;
        int child = 2*parent+1;
        while(child<len){
            //有左右子树
            if (child+1<len && elem[child] < elem[child+1]) {
                child++;
            }
            //子树大于根节点数，交换
            if(elem[child] > elem[parent]) {
                int tmp = elem[parent];
                elem[parent] = elem[child];
                elem[child] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }

    @Override
    public void initHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        //开始调整堆，每一颗子树都需要调整
        for (int i = (elem.length-1-1)/2; i >= 0; i--) {
            adjustDown(i,elem.length-1);
        }
    }

    @Override
    public void adjustUp(int child, int len) {
        int parent = (child-1)/2;
        while (child>0){
            if (elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                child = parent;
                parent =  (child-1)/2;
            }else {
                break;
            }

        }
    }
    boolean isFull(){
        if(this.usedSize == this.elem.length){
            return true;
        }
        return false;
    }

    @Override
    public void pushHeap(int item) {
        if(isFull()) {
            this.elem = new int[2*this.elem.length];
        }
        this.elem[this.usedSize++] = item;
        adjustUp(usedSize-1,this.usedSize);
    }

    @Override
    public int popHeap() {
        if(this.usedSize == 0){
            throw new UnsupportedOperationException("堆为空");
        }
        int tmp = elem[0];
        elem[0] = elem[usedSize-1];
        elem[usedSize-1] = tmp;
        adjustDown(0,--usedSize);
        return tmp;
    }

    @Override
    public int getHeapTop() {
        if(this.usedSize == 0){
            throw new UnsupportedOperationException("堆为空");
        }
        return this.elem[0];
    }

    @Override
    public void HeapSort() {
        int end = this.usedSize-1;
        while(end > 0){
            int tmp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] = tmp;
            adjustDown(0,end--);
        }
    }

    @Override
    public void show() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(elem[i]);
        }
    }
}
