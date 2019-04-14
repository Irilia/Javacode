public interface IMyQueue {
    // 判断这个队列是否为空
    boolean empty();
    // 返回队首元素，但不出队列
    int peek();
    // 返回队首元素，并且出队列
    int poll();
    // 将 item 放入队列中
    void add(int item);
    // 返回元素个数
    int size();

}
