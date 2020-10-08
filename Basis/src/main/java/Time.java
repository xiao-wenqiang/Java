import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Time {
    public static void main(String[] args) throws ParseException {

        //java.lang.System类的静态方法 currentTimeMillis()
        long time = System.currentTimeMillis();
        System.out.println(time);//返回毫秒数，从1970年1月1日0时0分0秒到现在的

        //java.util.Date类
        Date date = new Date();//创建了当前时间点的对象
        System.out.println(date.toString());//返回年月日时分秒
        System.out.println(date.getTime());//返回毫秒数

        //java.sql.Date、java.sql.Time、java.sql.TimeStamp
        java.sql.Date date1 = new java.sql.Date(1599819906357L);
        System.out.println(date1);//返回YYYY-MM-DD

        //java.util.Date对象 ->取得毫秒数 -> java.sql.Date对象
        Date date2 = new Date();
        java.sql.Date date3 = new java.sql.Date(date2.getTime());

        //java.text.SimpleDateFormat 用来对Date类的格式化和解析
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Date date4 = new Date();
        System.out.println(date4);
        //格式化：日期 ->字符串
        String str = simpleDateFormat.format(date4);
        System.out.println(str);
        //解析：字符串 ->日期
        String str2 = "20-9-11 下午7:06";//默认日期时间格式
        Date date5 = simpleDateFormat.parse(str2);
        System.out.println(date5);
        //自定义日期时间格式：
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(simpleDateFormat1.format(date4));

        //-------------------------------------------
        //把文本日期时间写入数据库
        String str3 = "2020-09-08";
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date6 = simpleDateFormat2.parse(str3);
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
        System.out.println(date7);

        //-------------------------------------------
        //日历类：（月份0-11，周日是1，周六是7）
        Calendar calendar = new GregorianCalendar();
        Calendar calendar1 = Calendar.getInstance();//两个都可以创建对象
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//返回今天是这个月的第几天


    }
}