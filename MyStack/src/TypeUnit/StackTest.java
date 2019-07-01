package TypeUnit;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        //栈
        /*Stack<Integer> stack = new Stack<>();
        //push改为add也一样，因为Stack继承了Vector，Vector是List的子类，所以add方法也可以使用；
        //添加元素
        stack.push(1);
        stack.push(3);
        stack.push(5);
        //读取栈顶元素，不出栈
        System.out.println(stack.peek());
        //读取栈顶元素并出栈
        System.out.println(stack.pop());
        System.out.println(stack.peek());
*/
        //队列
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(3);
        queue.add(5);
        //读取栈顶元素，不出栈
        System.out.println(queue.peek());
        //读取栈顶元素并出栈
        System.out.println(queue.poll());


    }
}
