import java.util.*;

public class Generic1<G> {//类的泛型

    private String name;
    private G desc;
    public G getDesc() {
        return desc;
    }
    public void setDesc(G desc) {
        this.desc = desc;
    }
    public <H> H sout(H h){return h;}//自定义的方法的泛型，和类的泛型没关系

    public static void main(String[] args) {
        //泛型：标签：指定参数类型：使数据类型安全
        Generic1<String> generic1 = new Generic1<>();
        //如果定了泛型但是没有指定类型，就是Object
        generic1.setDesc("无所谓也有点累");
        System.out.println(generic1.getDesc());

//List用泛型：
        ArrayList<Integer> list = new ArrayList<>();
        list.add(88);
        list.add(98);
        list.add(100);
        for (Integer score : list){
            System.out.print(score+" ");
        }
        System.out.println("");

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println("");

//Map用泛型：
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("bendan",21);
        map.put("bendan2",22);
        map.put("bendan3",20);
        map.put("bendan4",19);
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            Map.Entry<String, Integer> entry = iterator1.next();
            System.out.print(entry.getKey()+":"+entry.getValue()+" ");
        }
        System.out.println("");


    }
}
