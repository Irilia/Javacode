public class Test {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(8);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(5);
        myCircularQueue.enQueue(6);
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(8);
        myCircularQueue.enQueue(4);
        myCircularQueue.enQueue(9);
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.Front());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.Front());


        /*MinStack minStack = new MinStack();
        minStack.push(9);
        minStack.push(11);
        minStack.push(5);
        minStack.push(-8);
        minStack.push(-8);
        System.out.println(minStack.getMin());//-8
        minStack.pop();*/
        //minStack.pop();
        //System.out.println(minStack.getMin());//5
        /*TestMyQueue testMyQueue = new TestMyQueue();
        testMyQueue.push(11);
        testMyQueue.push(12);
        testMyQueue.push(13);
        testMyQueue.push(14);
        System.out.println();*/
        //MyBracketImpl myBracket = new MyBracketImpl();

        /*MyQueueImpl myQueue = new MyQueueImpl();
        myQueue.add(5);
        myQueue.add(10);
        myQueue.add(15);
        myQueue.add(20);
        myQueue.add(25);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.size());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.size());*/



        /*MyStackImpl myStack = new MyStackImpl();
        myStack.push(10);
        myStack.push(99);
        myStack.push(22);
        myStack.push(6);
        myStack.push(66);
        System.out.println(myStack.pop());
        System.out.println(myStack.size());
        System.out.println(myStack.peek());
        System.out.println(myStack.size());
        System.out.println(myStack.empty());*/

    }
}
