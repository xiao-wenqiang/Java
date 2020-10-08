import java.sql.*;

public class JDBC {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://cdb-csvoa1qa.cd.tencentcdb.com:10091/sale_electricity_system?useUnicode=true&characterEncoding=utf8&useSSL=true";
    private static String username = "root";
    private static String password = "forever210";
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //连接数据库
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
    //断开连接
    public static void release(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet) {
        if(resultSet!=null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(preparedStatement!=null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void release2(Connection connection,Statement statement,ResultSet resultSet) {
        if(resultSet!=null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement!=null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //登入业务
    public static boolean login(String username,String password) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean flag = false;
        try {
            //获取数据库对象
            connection = JDBC.getConnection();
            //预编译
            String sql = "select * from administer where username=? and password=?";
            preparedStatement = connection.prepareStatement(sql);
            //传递参数
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            //执行
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.release(connection, preparedStatement, resultSet);
        }
        return flag;
    }

    //查询电量
    public static int query_electricity(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        int electricity=-1;
        try {
            //获取数据库对象
            connection = JDBC.getConnection();
            //预编译
            String sql = "select * from card where id=?";
            preparedStatement = connection.prepareStatement(sql);
            //传递参数
            preparedStatement.setInt(1, id);
            //执行
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                electricity = resultSet.getInt("electricity");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.release(connection, preparedStatement, resultSet);
        }
        return electricity;
    }

    //缴电费
    public static boolean pay(int id, int electricity) {
        boolean flag = false;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //获取数据库对象
            connection = JDBC.getConnection();
            //预编译
            String sql = "update card set electricity=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            //传递参数
            preparedStatement.setInt(1, electricity+ JDBC.query_electricity(id));
            preparedStatement.setInt(2, id);
            //执行
            int i =preparedStatement.executeUpdate();
            if(i>0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.release(connection, preparedStatement, resultSet);
        }
        return flag;
    }


    //记录购电信息
    public static boolean order(int id, int electricity, float money) {
        boolean flag = false;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //获取数据库对象
            connection = JDBC.getConnection();
            //预编译
            String sql = "insert into sale(id,buy_electricity,pay_money,time) values(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            //手动赋值
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, electricity);
            preparedStatement.setFloat(3, money);
            preparedStatement.setDate(4, new Date(new java.util.Date().getTime()));

            //执行
            int i =preparedStatement.executeUpdate();
            if(i>0) {
                flag = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.release(connection, preparedStatement, resultSet);
        }
        return flag;
    }

    //模拟用电
    public static boolean use_electricity() {
        boolean flag = false;

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //获取数据库对象
            connection = JDBC.getConnection();
            statement = connection.createStatement();
            //
            String sql = "UPDATE card SET electricity=electricity-1 where electricity>0";
            //执行
            int i = statement.executeUpdate(sql);
            if (i > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.release2(connection, statement, resultSet);
        }
        return flag;
    }


    //确认卡号业务
    public static boolean idQuery(String id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean flag = false;
        try {
            //获取数据库对象
            connection = JDBC.getConnection();
            //预编译
            String sql = "select * from card where id=?";
            preparedStatement = connection.prepareStatement(sql);
            //传递参数
            preparedStatement.setString(1, id);
            //执行
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.release(connection, preparedStatement, resultSet);
        }
        return flag;
    }








}
