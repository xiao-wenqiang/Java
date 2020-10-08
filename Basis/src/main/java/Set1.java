import java.util.HashSet;
import java.util.Set;

public class Set1 {
    public static void main(String[] args) {
        /*
        集合框架：
        Collection接口 ->List接口：有序可重复 ->ArrayList（主要实现类一般就用它了因我效率高虽然线程不安全）、LinkedList、Vector
                      ->Set接口：无序不重复 ->HashSet（主要实现类主要就用它了因为效率高虽然线程不安全）、TreeSet、LinkedHashSet（是HashSet子类）
        Map接口 ->HashMap、TreeMap
         */

        //无序的意思是：存数据在底层数组中没有按照索引的顺序存（按照哈希值），但是取还是按照索引顺序取的
        //不能重复添加相同的元素
        //方法大概同Collection接口方法
        Set set = new HashSet();
        set.add(123);
        set.add(456);
        set.add(654);
        set.add(321);
        set.add("bbb");
        set.add("aaa");
        for (Object set1 : set){
            System.out.println(set1);
        }






    }
}
