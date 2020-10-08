//import org.apache.ibatis.session.SqlSession;
//import org.junit.Test;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class UserTest {
//    @Test
//    public void test1() {
//        SqlSession sqlSession = MybatisUtil.getSqlSession();
//
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        List<User> userList = userMapper.getUserList();
//        for (User user : userList) {
//            System.out.println(user);
//        }
//
//        sqlSession.close();
//    }
//    @Test
//    public void getUserById(){
//        SqlSession sqlSession = MybatisUtil.getSqlSession();
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        User user = userMapper.getUserById(1001);
//        System.out.println(user);
//        sqlSession.close();
//    }
//
//    @Test
//    public void addUser(){
//        SqlSession sqlSession = MybatisUtil.getSqlSession();
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        userMapper.addUser(new User(1004,"bendan4","323223"));
//
//        //默认开启了事务，所以要提交事务：所以更新（增删改）都要提交事务
//        sqlSession.commit();
//
//        sqlSession.close();
//    }
//    @Test
//    public void updateUser(){
//        SqlSession sqlSession = MybatisUtil.getSqlSession();
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        userMapper.updateUser(new User(1004,"bendan4","222222"));
//        sqlSession.commit();
//        sqlSession.close();
//    }
//    @Test
//    public void deleteUser(){
//        SqlSession sqlSession = MybatisUtil.getSqlSession();
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        userMapper.deleteUser(1004);
//        sqlSession.commit();
//        sqlSession.close();
//    }
//
//    @Test
//    public void updateUser2(){
//        SqlSession sqlSession = MybatisUtil.getSqlSession();
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("id",1003);
//        map.put("password","888888");
//
//        userMapper.updateUser2(map);
//        sqlSession.commit();
//        sqlSession.close();
//    }
//
//    @Test
//    public void getUserList(){
//        SqlSession sqlSession = MybatisUtil.getSqlSession();
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
////模糊查询：要防止SQL注入
//        List<User> userList = userMapper.getUserLike("%"+"王"+"%");
//        for (User user : userList) {
//            System.out.println(user);
//        }
//        sqlSession.commit();
//        sqlSession.close();
//    }
////分页查询
//    @Test
//    public void getUserByLimit(){
//        SqlSession sqlSession = MybatisUtil.getSqlSession();
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        Map<String,Integer> map = new HashMap<String, Integer>();
//        map.put("startIndex",0);
//        map.put("pageSize",3);
//        List<User> list = userMapper.getUserByLimit(map);
//        for (User user : list){
//            System.out.println(user);
//        }
//        sqlSession.close();
//    }
//}
//
///*
//JDBC：获取connection对象 ->获取语句对象 ->语句对象调用执行的方法
//mybayis：获取sqlSession对象 ->获取Mapper对象 ->Mapper对象调用执行的方法
// */