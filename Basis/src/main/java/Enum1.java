public class Enum1 {
    public static void main(String[] args) {
        //当要定义一组常量时，用枚举类

        //jdk1.5：自定义的
        Season spring = Season.SPRING;
        System.out.println(spring.toString());

        //jdk1.8：使用enum关键字定义的
        Season1 spring1 = Season1.SPRING;
        System.out.println(spring1.toString());
        //继承了 enum类的方法：大概就是定义时候被就写进数组了
        Season1[] values = Season1.values();
        for (Season1 value :
                values) {
            System.out.println(value);
        }


    }
}

//jdk1.5：自定义枚举类：静态类方法 ->取静态对象
class Season {
    private final String name;
    private final String describle;

    private Season(String name,String describle){
        this.name = name;
        this.describle = describle;
    }

    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","雪花飘飘");

    public String getName() {
        return name;
    }

    public String getDescrible() {
        return describle;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", describle='" + describle + '\'' +
                '}';
    }
}

//jdk1.8：使用enum关键字定义
enum  Season1 {
    SPRING("春天","春暖花开"),
    SUMMER("夏天","夏日炎炎"),
    AUTUMN("秋天","秋高气爽"),
    WINTER("冬天","雪花飘飘");

    private final String name;
    private final String describle;

    private Season1(String name,String describle){
        this.name = name;
        this.describle = describle;
    }

    public String getName() {
        return name;
    }

    public String getDescrible() {
        return describle;
    }

}