package Heap;

public interface IHeap {
    //从每颗子树的根节点开始调整 调整的长度为len
    void adjustDown(int root,int len);
    //初始化建立大根堆
   void initHeap(int[] array);
    // 向上调整，从孩子节点开始调整
    void adjustUp(int child,int len);
    // 插入 item 到堆中
    void pushHeap(int item);
    // 返回堆顶元素，删除数据元素
    int popHeap();
    // 返回堆顶元素，不删除数据元素
    int getHeapTop();
    //堆排序
    void HeapSort();
    //打印堆
    void show();
}
