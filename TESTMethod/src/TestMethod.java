import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestMethod {
    public static void main1(String[] args) {
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
    //反射获取方法
    public static void main2(String[] args) {
        //Class对象获取方法
        Class classz = Person.class;
         /*//获取所有的方法
        Method[] methods = classz.getMethods();
        for(Method method : methods){
            //getParameterTypes()返回的是一个数组类型
            System.out.println(method.getName() + " " + Arrays.toString(method.getParameterTypes()));
        }*/
        try {
            Method method = classz.getMethod("setName", String.class);
            Person person = new Person("Jack",22);
            System.out.println("before " + person);
            Object returnValue = method.invoke(person,"Tom");
            System.out.println(returnValue);
            System.out.println("after "+ person);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
       Student student = new Student();
       student.setName("Jack");
       student.setAge(22);
       student.setSkill("c++,php,java");
       //得到一个Class对象
       Class studentClass = student.getClass();
       //获取父类的公开属性（字段）
       /* Field[] fields = studentClass.getFields();
        for(Field field : fields){
            System.out.println(field.getName()+ " " + field.getType());
        }

        try {
            Field nameField = studentClass.getField("name");
            System.out.println(nameField.getName() +" " + nameField.getType());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
*/
       //获取当前类的属性
        //获取所有属性
        //返回一个数组
        /*Field[] fields = studentClass.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getName() + " "+field.getType());
        }
        System.out.println("===========");
        //获取指定属性
        try {
            //只返回一个
            Field field = studentClass.getDeclaredField("skill");
            System.out.println(field.getName() + " "+field.getType());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }*/

        //获取student对象的skill属性
        //通过对象调用方法--正向操作
        System.out.println("skill ="+student.getSkill());
        //通过反射调用值
        try {
            Field skillfield = studentClass.getDeclaredField("skill");
            //Object skillValue = skillfield.get(student);

            skillfield.setAccessible(true);
            Object skillValue = skillfield.get(student);
            System.out.println(skillfield);
            skillfield.set(student,"JavaScript");
            System.out.println(student.getSkill());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}

class Person{
    //setter,getter也是成员方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;

    public Person(){}

    public Person(String name,Integer age){
        this.name = name;
        this.age = age;
    }

    public String greetInfor(){
        return "欢迎" + this.getName();
    }

    public void printPersonInfor(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student extends Person{
    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    private String skill;

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "skill='" + skill + '\'' +
                ", sex=" + sex +
                '}';
    }

    private Boolean sex;

}