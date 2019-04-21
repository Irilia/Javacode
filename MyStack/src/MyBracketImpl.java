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
        char[] stack = new char[s.length()];
        int top = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' ||
                    s.charAt(i) == '{' ||
                    s.charAt(i) == '[') {
                stack[top++] = s.charAt(i);
            } else {
                if (top == 0) {
                    System.out.println("右括号大于左括号");
                    return false;
                }
                //取出栈顶元素
                char ch = stack[top - 1];
                if (ch == '(' && s.charAt(i) == ')' || ch == '{' && s.charAt(i) == '}' || ch == '[' && s.charAt(i) == ']') {
                    --top;
                } else {
                    System.out.println("右括号匹配的顺序不正确");
                    return false;
                }
            }

        }
        if (top > 0) {
            System.out.println("左括号大于右括号");
            return false;
        }
        return true;
    }




}
