import java.util.*;

public class List1 {
    public static void main(String[] args) {
        /*
        集合框架：
        Collection接口 ->List接口：有序可重复 ->ArrayList（主要实现类一般就用它了）、LinkedList、Vector
                      ->Set接口：无序不重复 ->HashSet、TreeSet、LinkedHashSet
        Map接口 ->HashMap、TreeMap
         */

        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add("无所谓也有点累");
        collection.add(true);
        collection.add(654);
        collection.add(321);
        collection.add(new Bendan("bendan", 22));

        System.out.println(collection.size());//元素个数

        System.out.println(collection.contains(123));//判断包含对象
        System.out.println(collection.contains(new String("无所谓也有点累")));
//判断存在，对自定义的类的对象，要重写它的equals()方法
        System.out.println(collection.contains(new Bendan("bendan", 22)));

        Collection collection1 = Arrays.asList(123,456,true);
        System.out.println(collection.containsAll(collection1));
        collection.removeAll(collection1);

        collection.remove(123);//删除

        System.out.println(collection.hashCode());//取哈希值

        //集合 ->数组
        Object[] arr = collection.toArray();
        for (Object arr1 :
                arr) {
            System.out.println(arr1);
        }
        //数组 ->集合
        List<String> list = Arrays.asList(new String[]{"aa","bb","cc"});
        System.out.println(list);


//遍历集合：用它的迭代器：遍历的是对象
        Collection collection2 = new ArrayList();
        collection2.add(123);
        collection2.add(456);
        collection2.add(789);
        collection2.add(999);
        collection2.add(987);
        collection2.add(654);
        collection2.add(321);
        Iterator iterator = collection2.iterator(); //迭代器
        while (iterator.hasNext()){     //遍历
            Object next = iterator.next();//取下一个值
            if (new Integer(999).equals(next)){
                iterator.remove();//它的迭代器也可以删除元素（集合本身可以）
                continue;
            }
            System.out.print(next+" ");
        }
        System.out.println("");
//用foreach遍历集合：本质还是调用了迭代器
        for (Object o: collection2) {
            System.out.print(o+" ");
        }
        System.out.println("");


//还是用的ArrayList：
//对象元素排序用比较器：Comparable和
        ArrayList arrayList = new ArrayList();
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("ccc");
        arrayList.add("fff");
        arrayList.add("eee");
        arrayList.add("ddd");
        arrayList.add("ddd");
        arrayList.add("无所谓也有点累");
        System.out.println(arrayList.indexOf("ddd"));//首次出现的位置，没有返回-1
        System.out.println(arrayList.lastIndexOf("ddd"));//最后一次出现的位置
        arrayList.add(1,"111");//添加
//        arrayList.addAll(1,collection);
        System.out.println(arrayList.get(1));//取指定元素
        arrayList.remove("无所谓也有点累");//也可指定位置删除
        arrayList.set(0,"无所谓也有点累");//设置指定元素
//        ArrayList list1 = (ArrayList) arrayList.subList(2,4);//返回指定子集合
        System.out.println(arrayList.size());//长度



    }
}

class Bendan {
    private String name;
    private int age;

    public Bendan(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Bendan() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Bendan bendan = (Bendan) obj;
        return age == bendan.age &&
                Objects.equals(name, bendan.name);
    }

    @Override
    public String toString() {
        return "Bendan{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}