package com.bittech;

public class TestColor {

    public static void main(String[] args) {
        System.out.println(Color.getColorInstance(2));
        System.out.println(Color.getColorInstance(1));
        System.out.println(
                Color.getColorInstance(3) == Color.getColorInstance(3)
        );
        System.out.println(Color.getColorInstance(5));//null
    }
}

//多例：一个类实例化对象的个数是可数的
class Color {

    private static final Color RED = new Color("红色");
    private static final Color GREEN = new Color("绿色");
    private static final Color BLUE = new Color("蓝色");

    private String title;

    private Color(String title) {
        this.title = title;
    }

    public static Color getColorInstance(int flag) {
        switch (flag) {
            case 1:
                return RED;
            case 2:
                return GREEN;
            case 3:
                return BLUE;
            default:
                return null;
        }
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Color{" +
                "title='" + title + '\'' +
                '}';
    }
}