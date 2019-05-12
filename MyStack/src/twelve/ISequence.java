package twelve;

public interface ISequence {
    boolean add(int pos,Object data);
    int search(Object key);
    boolean contion(Object key);
    Object getPos(int pos);
    Object remove(Object key);
    int size();
    void display();
    void clear();
}
