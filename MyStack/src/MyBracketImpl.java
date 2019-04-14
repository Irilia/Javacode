public class MyBracketImpl implements IBracket {
    private char[] elem;
    private int top;//保存的是当前可以放数据元素的下标
    private int usedSize;
    private static final int DEFAULT_SIZE = 10;

    public MyBracketImpl(){
        this.elem = new char[DEFAULT_SIZE];
        this.top = 0;
        this.usedSize = 0;
    }

    public boolean isFull(){
        return this.top == this.elem.length;
    }


    @Override
    public void push(char item) {
        if(isFull()){
            throw new UnsupportedOperationException("栈是满的");
        }
        this.elem[this.top++] = item;
        this.usedSize++;
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
        MyBracketImpl myBracket = new MyBracketImpl();
        if(empty()){
            return true;
        }
        this.elem = s.toCharArray();
        for (int i = 0; i < this.elem.length; i++) {
            if(elem[i] == '('){
        }

    }
}
