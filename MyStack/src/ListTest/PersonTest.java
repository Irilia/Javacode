package ListTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

class Person{
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

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

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Person)){
            return false;
        }
        Person per = (Person)obj;
        return this.age.equals(per.age)&&this.name.equals(per.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

public class PersonTest {
    public static void main(String[] args) {
        List<Person> people = new LinkedList<>();
        Person person1 = new Person("张三",25);
        Person person2 = new Person("李四",35);
        Person person3 = new Person("王五",45);
        people.add(person1);
        people.add(person2);
        people.add(person3);
        System.out.println(people.contains(new Person("张三",25)));
    }
}
