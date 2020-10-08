import java.util.*;

public class Map1 {
    public static void main(String[] args) {
        /*
        集合框架：
        Collection接口 ->List接口：有序可重复 ->ArrayList（主要实现类一般就用它了因我效率高虽然线程不安全）、LinkedList、Vector
                      ->Set接口：无序不重复 ->HashSet（主要实现类主要就用它了因为效率高虽然线程不安全）、TreeSet、LinkedHashSet（是HashSet子类）
        Map接口 ->HashMap（主要实现类主要就用它了因为效率高虽然线程不安全）(无序）、TreeMap（有序）
         */

        //HashMap：双列数据：用于存储键值对key-value的数据：类似于 y=f(x)，x是key无序不重复，key-value的entry无序不重复
        //key所在类要重写 equals()
        HashMap hashMap = new HashMap();
        hashMap.put("aaa",456);//添加数据，也可以存null
        hashMap.put("bbb",123);
        hashMap.put("ccc",789);
        hashMap.put("aaa",654);//修改：第二次以后的put()是修改上次的value
        hashMap.put("aaa",655);//修改：第二次以后的put()是修改上次的value
        System.out.println(hashMap);//打印

        System.out.println(hashMap.get("aaa"));//取指定key的value
        System.out.println(hashMap.containsKey("aaa"));//判断存在指定key
        System.out.println(hashMap.containsValue(654));//判断存在指定value
        System.out.println(hashMap.size());//key-value对的个数

        HashMap hashMap1 = new HashMap();
        hashMap1.put("aaa",888);
        hashMap1.put("ddd",888);
        hashMap1.put("eee",888);
        hashMap1.putAll(hashMap);//添加HashMap
        System.out.println(hashMap1);

        Object value = hashMap1.remove("eee");//删除key="eee"的，也返回它value
        System.out.println(value);
        System.out.println(hashMap1);

        hashMap1.clear();//清空HashMap的数据：当然只是删除数据实例还在不是赋空值
        System.out.println(hashMap1.size());
        System.out.println(hashMap1);

        System.out.println(hashMap1.equals(hashMap));//判断相等

//遍历：Map它没有迭代器，只能取集合key、集合value，用它的迭代器
//遍历key：只能取keySet的迭代器遍历key：.keySet()
        Set keys = hashMap.keySet();
        Iterator iterator = keys.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println("");
//遍历value：只能取value的集合：.value()
        Collection values = hashMap.values();
        for (Object o : values){
            System.out.print(o+" ");
        }
        System.out.println("");
//遍历key-value：取entry的集合：.entrySet()
        Set entrySet = hashMap.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            Object o = iterator1.next();
            Map.Entry entry = (Map.Entry)o;
            System.out.print(entry.getKey()+":"+entry.getValue()+" ");
        }
        System.out.println("");



    }
}
