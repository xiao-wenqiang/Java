package mapper;

import org.mybatis.spring.SqlSessionTemplate;
import pojo.User;

import java.util.List;
import java.util.Map;

public class UserMapperImpl implements UserMapper {

    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<User> getUserList() {
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
