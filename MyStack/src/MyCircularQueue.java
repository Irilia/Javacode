//循环队列
public class MyCircularQueue {
    private int front;//队头的下标
    private int rear;//队尾的下标
    private int[] elem;//数组
    private int usedSize;//有效数据的个数

    public MyCircularQueue(int k) {
        this.front = 0;
        this.rear = 0;
        //this.elem= new int[k+1];
        this.elem= new int[k];
        this.usedSize = 0;
    }
    //入队
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        this.elem[this.rear] = value;
        this.rear = (this.rear+1)%this.elem.length;
        this.usedSize++;
        return true;
    }
    //出队
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        this.front = (this.front+1)%this.elem.length;
        this.usedSize--;
        return true;
    }
    //队头的元素
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return this.elem[this.front];
    }
    //队尾的元素
    public int Rear() {
        if(isEmpty()){
            throw new UnsupportedOperationException("队为空");
        }
        if(rear == 0){
            return this.elem[this.elem.length-1];
        }
        return this.elem[rear-1];
    }
    //是否为空
    public boolean isEmpty() {
        return this.front == this.rear;
        //return this.usedSize == 0;
    }
    //是否为满
    public boolean isFull() {
        if((this.rear+1)%this.elem.length == this.front){
            return true;
        }
        return false;
    }
}
