import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestMethod {
    public static void main(String[] args) {
        //获取属性，字段
        Student student = new Student();
        student.setName("Jack");
        student.setAge(22);
        student.setSkill("c++,PHP,Java");

        Class studentClass = student.getClass();
        //获取父类的公开属性
        /*Field[] fields = studentClass.getFields();
        for (Field field:fields
             ) {
            System.out.println(field.getName() + " " + field.getType());
        }
        try {
            Field nameField = studentClass.getField("age");
            nameField.getName()
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }*/
        //获取当前类属性，不管是否公开
        Field[] fields = studentClass.getDeclaredFields();
        for(Field field: fields){
            System.out.println(field.getName() + " " + field.getType());
        }
        try {
            Field field = studentClass.getDeclaredField("name");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

class Person{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;

    public Person(){}

}

class Student extends Person{
    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Student{" +
                "skill='" + skill + '\'' +
                '}';
    }

    private String skill;

}