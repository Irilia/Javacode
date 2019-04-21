public class TestMyStack {
    private MyQueueImpl myQueue1;
    private MyQueueImpl myQueue2;
    private int usedSize;
    public TestMyStack(){
        myQueue1 = new MyQueueImpl();
        myQueue2 = new MyQueueImpl();
        this.usedSize = 0;
    }

    //入栈
    public void push(int x) {
        if(myQueue1.empty()) {
            myQueue1.add(x);
        }else if(myQueue2.empty()){
            myQueue2.add(x);
        }else{
            myQueue1.add(x);
        }
        this.usedSize++;
    }

    public boolean empty() {
        return this.usedSize == 0;
    }
    //删除栈顶的元素
    public int pop() {
        if(myQueue1.empty() && myQueue2.empty()){
           throw new UnsupportedOperationException("栈为空");
        }
        int data = 0;
        if(!myQueue2.empty()) {
            for (int i = 0; i < this.usedSize-1; i++) {
                myQueue1.add(myQueue2.poll());
            }
            data = myQueue2.poll();
            this.usedSize--;
        }else{
            for (int i = 0; i < this.usedSize-1; i++) {
                myQueue2.add(myQueue1.poll());
            }
            data = myQueue1.poll();
            this.usedSize--;
        }
        return data;
    }

    // 获取栈顶元素
    public int top() {
        if(myQueue1.empty() && myQueue2.empty()){
            throw new UnsupportedOperationException("栈为空");
        }
        int data = 0;
        if(!myQueue2.empty()) {
            for (int i = 0; i < this.usedSize-1; i++) {
                data = myQueue2.peek();
                myQueue1.add(data);
            }
            data = myQueue2.poll();
            this.usedSize--;
        }else{
            for (int i = 0; i < this.usedSize-1; i++) {
                myQueue2.add(myQueue1.poll());
            }
            data = myQueue1.poll();
            this.usedSize--;
        }
        return data;
    }
    //检索栈中的最小元素

}
