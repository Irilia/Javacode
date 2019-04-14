public class Test {
    public static void main(String[] args) {
        MyQueueImpl myQueue = new MyQueueImpl();
        myQueue.add(5);
        myQueue.add(10);
        myQueue.add(15);
        myQueue.add(20);
        myQueue.add(25);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.size());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.size());



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
