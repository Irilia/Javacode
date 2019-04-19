package com.bittech;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestFunction {

    public static int charsCountA(char[] chars) {
        int i = 0;
        for (char c : chars) {
            if (c == 'A') {
                i++;
            }
        }
        return i;
    }

    public static void code1() {
        Function<Integer, String> function = String::valueOf;

        //计算字符串的长度
        Function<String, Integer> function1 = String::length;

        //计算char数组中A的个数
        Function<char[], Integer> function2 = (chars) -> {
            int i = 0;
            for (char c : chars) {
                if (c == 'A') {
                    i++;
                }
            }
            return i;
        };

        // function2 = TestFunction::charsCountA;
    }

    public static void code2() {
        //供给型函数
        Supplier<String> supplier1 = () -> {
            return "hello java";
        };
        System.out.println(supplier1.get());

        Supplier<Person2> supplier2 = () -> {
            Person2 person2 = new Person2();
            person2.setAge(22);
            person2.setName("jack");
            return person2;
        };
        System.out.println(supplier2.get());

        double price = compute(
                () -> {
                    //code
                    //code
                    return 100.0D;
                },
                () -> {
                    //code
                    //code
                    return 0.98D;
                }
        );
        System.out.println(price);
    }

    public static void code3() {
        Consumer<String[]> consumer = (strings -> {
            for (String string : strings) {
                System.out.println(string);
            }
        });
        consumer.accept(new String[]{"Java", "Python", "C++"});

        Consumer<String> consumer1 = (s -> {
            System.out.println(s);
        });

        //对象的成员方法引用
        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("Hello");
    }

    public static void main(String[] args) {

        //断言型函数
        //判断String是否为null或者空
//        Predicate<String> predicate1 = (s -> {
//            return s != null && s.length() != 0;
//        });
//        System.out.println(predicate1.test("hello"));
//        System.out.println(predicate1.test(null));

        Predicate<String> predicate1 = (s -> {
            return s != null;
        });
        Predicate<String> predicate2 = (s -> {
            return s.length() != 0;
        });
        // y = f(x)
        // z = g(x)
        // r = y & z
        // h = f(x) && g(x)
        // r = h(x)
        Predicate<String> predicate3 = predicate1.and(predicate2);
        System.out.println(predicate3.test("Hello"));
        System.out.println(predicate3.test(""));


    }

    public static Double compute(Supplier<Number> supplier1, Supplier<Double> supplier2) {
        Number number = supplier1.get();
        Double discount = supplier2.get();
        double price = number.doubleValue() * discount;
        return price;
    }
}
