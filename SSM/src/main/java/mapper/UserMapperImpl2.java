package mapper;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import pojo.User;

import java.util.List;
import java.util.Map;

public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper {

    public List<User> getUserList() {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.getUserList();
    }

    public User getUserById(int id) {
        return null;
    }


    public int addUser(User user) {
        return 0;
    }

    public int updateUser(User user) {
        return 0;
    }

    public int deleteUser(int id) {
        return 0;
    }

    public int updateUser2(Map map) {
        return 0;
    }

    public List<User> getUserLike(String username) {
        return null;
    }

    public List<User> getUserByLimit(Map<String, Integer> map) {
        return null;
    }
}
