import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Collections1 {
    public static void main(String[] args) {
        /*
        Collections：一个操作Collection（Set、List）和Map等集合的工具类
        Arrays：一个操作数组的工具类
         */

        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(789);
        list.add("ccc");
        list.add("bbb");
        list.add("aaa");
        list.add("无所谓也有点累");
        System.out.println(list);//打印

        Collections.reverse(list);//逆序排序
        System.out.println(list);
        Collections.shuffle(list);//随机排序
        System.out.println(list);
//        Collections.sort(list);//自然排序
        Collections.swap(list,0,1);//交换
        System.out.println(list);
        int frequency = Collections.frequency(list,123);//出现次数
        System.out.println(frequency);
//复制操作：
        List list1 = Arrays.asList(new Object[list.size()]);
        Collections.copy(list1,list);
        System.out.println(list1);
//使线程安全：就内部用了synchronized包了一下
        List list2 = Collections.synchronizedList(list);//返回的就是线程安全的了

    }
}
