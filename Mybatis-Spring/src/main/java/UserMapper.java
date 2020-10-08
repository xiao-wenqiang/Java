import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();//查
    User getUserById(int id);//查
    int addUser(User user);//增
    int updateUser(User user);//改
    int deleteUser(int id);//删

    int updateUser2(Map map);//万能的map：可以用new Map代替new具体对象

    List<User> getUserLike(String username);//模糊查询：要防止SQL注入

    List<User> getUserByLimit(Map<String, Integer> map);//分页查询
}
/*
所以，传入的是对象，用到的参数是对象的属性，写：#{对象属性}，然后和表的字段值做运算
 */