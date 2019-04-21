public class TestMyQueue {
    private MyStackImpl myStack1;
    private MyStackImpl myStack2;
    public TestMyQueue() {
        myStack1 = new MyStackImpl();
        myStack2 = new MyStackImpl();
    }
    //入队
    public void push(int x){
        myStack1.push(x);
    }
    //出队
    public int pop() {
        int data = 0;
        if(myStack2.empty()) {
            //把s1里的数据放入s2
           while(!myStack1.empty()){
               myStack2.push(myStack1.pop());
           }
        }
        int tmp=-1;
        if(!myStack2.empty()){
            //直接弹出s2的栈顶元素
            tmp = myStack2.pop();
        }
        return tmp;
    }

    public int peek() {
        int data = 0;
        if(myStack2.empty()){
            while(!myStack1.empty()){
                myStack2.push(myStack1.pop());
            }
        }
        data = myStack2.peek();
        return data;
    }

    public boolean empty() {
        if(myStack1.empty() && myStack2.empty()){
            return true;
        }
        return false;
    }

}
