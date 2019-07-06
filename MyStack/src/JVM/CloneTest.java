package JVM;


import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.ObjectInputStream;

class Teacher implements  Cloneable{
    private String name;
    private String job;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Teacher(String name, String job) {
        this.name = name;
        this.job = job;
    }
    public Teacher clone() {
        Teacher teacher = null;
        try {
            teacher = (Teacher) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return teacher;
    }
}

class Student implements Cloneable {
    private  String name;
    private Integer age;
    private Teacher teacher;

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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student(String name, Integer age, Teacher teacher) {
        this.age = age;
        this.name = name;
        this.teacher = teacher;
    }
    public Student clone() {
        Student student = null;
        try {
            student = (Student) super.clone();
            student.setTeacher(teacher.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return student;
    }
}
public class CloneTest {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("gb","java teacher");
        Student student = new Student("zs",20,teacher);
        Student cloneStudent = student.clone();
        System.out.println(student == cloneStudent);
        System.out.println(cloneStudent);
        System.out.println(student.getTeacher() == cloneStudent.getTeacher());
    }
    /*public static void main(String[] args) throws Exception {
        Teacher teacher = new Teacher("gb","java teacher");
        Student student = new Student("zs",20,teacher);
        //student ->内存中
        ByteOutputStream bos = new ByteOutputStream();
        ObjectInputStream oos = new ObjectInputStream(bos);
        oos.writeObject(student);
        //内存中stu->程序
        Student cloneStudent = (Student) ois.readObject();
        System.out.println(student == cloneStudent);
        System.out.println(cloneStudent);
        System.out.println(student.getTeacher() == cloneStudent.getTeacher());
    }*/

}
