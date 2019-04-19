package com.bittech;

public class TestPerson {

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setName("张三");
        person1.setAge(28);
        person1.setGender(Gender.MALE);

        System.out.println(person1);

        switch (person1.getGender()) {
            case MALE:
                System.out.println("这是男同志");
                break;
            case FEMALE:
                System.out.println("这是女同胞");
                break;
            default:
                System.out.println("性别不详");
        }
    }
}


class Person {

    private String name;
    private Integer age;
    //private Boolean gender ; // false:女  true：男
    private Gender gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}

enum Gender {

    MALE("男"), FEMALE("女");

    private String mark;

    Gender(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}