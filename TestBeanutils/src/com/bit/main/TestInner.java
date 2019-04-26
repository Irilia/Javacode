package com.bit.main;

public class TestInner {

    public static void main(String[] args) {
        Outter outter = new Outter();
        Outter.Inner inner = outter.new Inner();
        //Outter.Inner inner = new Outter().new Inner();
        outter.print(inner);
    }
}

class Outter{

    private String message = "Outter的消息";

    public void print(){

        System.out.println("Outter:" );
    }

    public void print(Inner inner){
        System.out.println("==Outter:" );
    }

    class Inner{
        private String message = "Inner的消息";

        public void print(){
            System.out.println("Inner:"+ message);
        }
    }
}
