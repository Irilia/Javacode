public class MyStackImpl implements IMyStack {

    private int[] elem;
    private int top;//保存的是当前可以放数据元素的下标
    private int usedSize;
    private static final int DEFAULT_SIZE = 10;

    public MyStackImpl(){
        this.elem = new int[DEFAULT_SIZE];
        this.top = 0;
        this.usedSize = 0;
    }

    public boolean isFull(){
        return this.top == this.elem.length;
    }

    @Override
    public void push(int item) {
        if(isFull()){
            throw new UnsupportedOperationException("栈是满的");
        }
        this.elem[this.top++] = item;
        this.usedSize++;
    }


    @Override
    public int pop() {
        if(empty()){
            throw new UnsupportedOperationException("栈是空的");
        }
        int num = this.elem[this.top-1];
        --this.top;
        this.usedSize--;
        return num;
    }

    @Override
    public int peek() {
        if(empty()){
            throw new UnsupportedOperationException("栈是空的");
        }
        return this.elem[this.top-1];
    }

    @Override
    public boolean empty() {
        return this.top == 0;
    }

    @Override
    public int size() {
        return this.usedSize;
    }

    public boolean isValid(String s) {

        return true;
    }
}
