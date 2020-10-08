import java.util.Arrays;
import java.util.Comparator;

public class Compare {
    public static void main(String[] args) {

        //实现字符串数组的排序
        //本质：因为String实现了Comparable接口
        String[] arr = new String[]{"aa", "vv", "bb", "cc", "zz", "dd"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        //Comparable接口的使用：自然排序
        //实现对象数组的排序
        //办法：对象类实现Comparable接口并重写compareTo()
        Goods[] arr2 = new Goods[4];
        arr2[0] = new Goods("xiaomi",9.9);
        arr2[1] = new Goods("huawei",88);
        arr2[2] = new Goods("vivo",66);
        arr2[3] = new Goods("oppo",33);
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));


        //Comparator接口的使用：定制排序：方便临时用
        String[] arr3 = new String[]{"aa", "vv", "bb", "cc", "zz", "dd"};
        Arrays.sort(arr3, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 instanceof String && o2 instanceof String){
                    String s1 = (String)o1;
                    String s2 = (String)o2;
                    return -s1.compareTo(s2);
                }
                //return 0;
                throw new RuntimeException("输入的数据类型不对！");
            }
        });
        System.out.println(Arrays.toString(arr3));



    }
}

class Goods implements Comparable {
    private String name;
    private double price;

    public Goods() {
    }
    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public int compareTo(Object o) {
        //写比较办法
        if (o instanceof Goods) {
            Goods goods = (Goods)o;
            if(this.price > goods.price) {
                return 1;
            }else if (this.price < goods.price) {
                return -1;
            }else {
                //return 0;
                return  this.name.compareTo(goods.name);
            }
            //return Double.compare(this.price,goods.price);
        }
        //return 0;
        throw new RuntimeException("传入的数据类型不对！");
    }
}