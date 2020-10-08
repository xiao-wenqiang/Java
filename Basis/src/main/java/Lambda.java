//函数式接口：只有唯一一个抽象方法
//可以用lambda表达式创建对象
//lambda表达式：实现函数式接口方法（实现指定接口的指定方法）
public class Lambda {
    public static void main(String[] args) {

        IOne one1 = new IOne() {
            @Override
            public void lambda() {
                System.out.println("匿名内部类");
            }
        };

        //只留下了指定方法的实现
        IOne one2 = ()->{
            System.out.println("lambda");
        };
        one1.lambda();
        one2.lambda();
    }
}

interface IOne {
    void lambda();
}
//class One implements IOne {
//    @Override
//    public void lambda() {
//        System.out.println("lambda");
//    }
//}