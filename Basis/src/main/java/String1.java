import java.util.Arrays;

public class String1 {
    public static void main(String[] args) {
        String str = "Helloworld!";

        System.out.println(str.length());//长度
        System.out.println(str.charAt(0));//取指定字符
        System.out.println(str.isEmpty());//判空
        System.out.println(str.toLowerCase());//小写
        System.out.println(str.trim());//去首尾空格
        System.out.println(str.equalsIgnoreCase("helloworld!"));
        System.out.println(str.concat("hello"));//拼接，用 + 就好啦
        System.out.println(str.compareTo("helloworld!"));//比较大小

        System.out.println(str.endsWith("rld!"));
        System.out.println(str.startsWith("Hel"));
        System.out.println(str.contains("ll"));

        //字符串 ->基本数据类型/包装类：比如：Integer.praseInt(str)
        String str1 = "123";
        int num = Integer.parseInt(str1);
        System.out.println(num);
        //基本数据类型/包装类 ->字符串：用String.valueOf(num)或者用 num+""
        String str2 = String.valueOf(num);//在常量池里
        String str3 = num+"";//在堆里
        System.out.println(str2);

        //String -> char[]  调用str.toCharArray()
        String str4 = "helloworld";
        char[] chars = str4.toCharArray();
        for(int i=0; i<chars.length; i++) {
            System.out.print(chars[i]);
        }
        System.out.println("");
        //char[] -> String  调用String的构造器
        char[] chars1 = new char[]{'h','e','l','l','o'};
        String str5 = new String(chars1);
        System.out.println(str5);
//编码：String->byte[]  解码：byte[]->String
//写数据是编码过程，读数据是解码过程，编码和解码用字符集要一致！可以用参指定字符集！
        //String -> byte[]  调用str.toBytes()
        String str6 = "helloworld";
        byte[] bytes = str6.getBytes();//还可以传参指定字符集
        System.out.println(Arrays.toString(bytes));
        //byte[] -> String  调用String的构造器，使用默认编码
        String str7 = new String(bytes);
        System.out.println(str7);

        /*-----------------------------------------
        String：不可变的字符序列
        Stringbuffer：可变，线程安全，效率低（多线程问题用它）
        StringBuilder：可变，线程不安全，效率高
         */
    }
}