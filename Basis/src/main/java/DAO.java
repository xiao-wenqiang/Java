import java.util.List;

public class DAO<T> {
    /*
    DAO：data/database access object
    定义对数据库的通用操作
    一个类对应一张表：多张表可以用泛型
     */
    //添加一条记录
    public void add(T t){}
    //删除一条记录
    public boolean delete(int index){return true;}
    //修改一条记录
    public void update(int index,T t){}
    //查询一条记录
    public <H> H getIndex(int index){return null;}
    //查询多条记录
    public <H>List<H> getForList(int index){return null;}
}

class Customer {

}

class CustomerDAO extends DAO<Customer> {

}