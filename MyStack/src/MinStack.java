public class MinStack {
    private MyStackImpl minStack1;
    private MyStackImpl minStack2;

    public MinStack(){
        minStack1  = new MyStackImpl();
        minStack2 = new MyStackImpl();
    }

    public void push(int x) {
        minStack1.push(x);
        if(minStack2.empty()){
            minStack2.push(x);
        }else{
            if(x<= minStack2.peek()){
                minStack2.push(x);
            }
        }
    }

    public void pop() {
        if(!minStack1.empty()){
            int tmp = minStack1.pop();
            //判断出栈的元素是否和最小栈的栈顶元素相同，如果相同，最小栈也必须出栈。
            if(tmp == minStack2.peek()){
                minStack2.pop();
            }

        }
    }
    //返回栈顶元素,不是最小栈
    public int top() {
        if(minStack1.empty()){
            return -1;
        }
        return minStack1.peek();
    }

    public int getMin() {
        if(minStack2.empty()){
            return -1;
        }
        return minStack2.peek();
    }
}
