import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class Annotation {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c = Class.forName("yf.Student3");
        //取得注解
        java.lang.annotation.Annotation[] annotations = c.getAnnotations();
        for (java.lang.annotation.Annotation annotation:annotations) {
            System.out.println(annotation);
        }
        //取得注解的value的值
        TableKuang tableKuang = (TableKuang) c.getAnnotation(TableKuang.class);
        String value = tableKuang.value();
        System.out.println(value);
        //取得类指定的注解
        Field f = c.getDeclaredField("id");
        FiledKuang annotation = f.getAnnotation(FiledKuang.class);
        System.out.println(annotation.columName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());


    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableKuang {
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FiledKuang {
    String columName();
    String type();
    int length();
}

@TableKuang("db_student")
class Student3 {
    @FiledKuang(columName = "db_id",type = "int",length = 10)
    private  int id;
    @FiledKuang(columName = "db_age",type = "int",length = 10)
    private int age;
    @FiledKuang(columName = "db_name",type = "varchar",length = 10)
    private String name;
    public Student3(){

    }
    public Student3(int id,int age,String name){
        this.id = id;
        this.age = age;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}