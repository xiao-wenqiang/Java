import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://cdb-2kxl7eco.cd.tencentcdb.com:10097/mybatis";
    private static String username = "root";
    private static String password = "forever210";
    private static Connection conn = null;
    static{ //初始化
        try {
            //1.加载驱动程序
            Class.forName("driver");
            //2. 获取连接
            // （取用就是：取它创建一条语句的对象，然后语句的对象可以执行语句）
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){   //获取连接
        return conn;
    }
}

/*
取用：
    Connection coon = JDBCUtil.getConnention();//获取连接

    //增
    String sql1 = "insert into user(id,username,password) value(?,?,?)";
    PreparedStatement statement = coon.prepareStatement(sql);//预编译
    statement.setInt(1,user1.getId());//传参，传一个用户对象的id
    ...
    statement.execute();

    //删/改
    String sql2 = "delete/update user ...";

    //查
    String sql3 = "select id,name from user";
    Statement statement3 = coon.createStatement();
    //PrepareStatement statement4 = coon.prepareStatement(sql3);//对？传参
    ResultSet set = statement3.executeQuery(sql3);//执行查询，返回结果集
    List<E> list = new ArrayList<E>();
    E e = null;
    while(set.next()) {
        e = new E();
        e.setId(set.getId("id"));
        e.setUsername(set.getUsername("username");
        list.add(e);
    }
    return list;

 */