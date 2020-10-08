import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        UserMapper userMapper = (UserMapper) context.getBean("userMapper");

        for (User user : userMapper.getUserList()){
            System.out.println(user);
        }
    }
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        UserMapper userMapper = (UserMapper) context.getBean("userMapper2");

        for (User user : userMapper.getUserList()){
            System.out.println(user);
        }
    }
}
