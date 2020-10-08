import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //正常方式：引入类 ->new ->取得实例化对象
        //反射方式：实例化对象 ->.getClass() ->取得Class对象
        /*
        加载完类后，在堆内存方法区中会产生一个Class类型的对象，也只有一个。
        它包含完整的类的结构信息：属性、方法、构造器、实现接口等。
        它也是一个类，由jvm对每一个加载的类创建一个对象。
        一个Class对象 ->一个加载的类
        一个加载的类 ->多个new的对象
         */

        Person student = new Student2();

        //三种办法取得同一个class对象，指向同一个！
        Class c = student.getClass();//Student2.class()
        Class c2 = Class.forName("yf.Student2");
        Class c3 = Student2.class;
        //取得父类的class对象
        Class c4 = c.getSuperclass();//Person.class()

        System.out.println(c.getName());//取得完整类名
        System.out.println(c.getSimpleName());

        Field name = c4.getDeclaredField("name");
        System.out.println(name);//取得指定属性名

        Method getName = c4.getDeclaredMethod("getName",null);
        Method setName = c4.getDeclaredMethod("setName",String.class);
        System.out.println(getName);//取得指定方法名
        System.out.println(setName);//取得指定方法名

        //动态创建对象：用反射
            //本质：还是调用它的无参构造器
        Person student2 = (Person) c.newInstance();
        System.out.println(student2);

        //通过构造器创建对象
        Constructor constructor = c4.getDeclaredConstructor(String.class);
        Person person = (Person) constructor.newInstance("笨蛋");
        System.out.println(person);

        //通过反射调用方法
        Person student3 = (Person) c.newInstance();
        Method setName2 = c4.getDeclaredMethod("setName",String.class);
        setName.invoke(student3,"无所谓 也有点累");
        System.out.println(student3);
        //通过反射操作属性（因为private所有要加 name.setAccessible(true);）
        Person person1 = (Person) c4.newInstance();
        Field name2 = c4.getDeclaredField("name");
        name2.set(person1,"yeyoudianlei");
        System.out.println(person1.getName());



    }
}

class Person{
    public String name;
    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student2 extends Person {
    public Student2() {
        setName("student");
    }
}

class Teacher2 extends Person {
    public Teacher2() {
        setName("teacher");
    }
}