package com.bittech.works;

import java.util.Date;

public class TestBeanUtils {


     static void main(String[] args) {

        Teacher teacher = new Teacher();
        teacher.setName("Peter");
        teacher.setSkill("C");
        teacher.setAge(23);
        teacher.setBirthday(new Date());
        System.out.println(teacher);

        Student student = new Student();
        System.out.println(student);

        //传统的方式
        //student.setBirthday(teacher.getBirthday());
        //student.setName(teacher.getName());
        //more field

        //通过反射进行属性赋值
        BeanUtils.copy(teacher,student);
        System.out.println(student);
    }

}


class Teacher {
    private String name;
    private String skill;
    private Date birthday;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                '}';
    }
}

class Student {
    private String name;
    private Integer skill;
    private Date birthday;
    private Boolean gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSkill() {
        return skill;
    }

    public void setSkill(Integer skill) {
        this.skill = skill;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", skill=" + skill +
                ", birthday=" + birthday +
                ", gender=" + gender +
                '}';
    }
}
