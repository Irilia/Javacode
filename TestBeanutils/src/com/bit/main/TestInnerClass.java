package com.bit.main;

public class TestInnerClass {
    public static void main(String[] args) {

    }
}

class Outer{
    private String message = "Outer的消息";
    static class Inner{
        public void print(){
            System.out.println(Outer.this.message);
        }
    }
}
