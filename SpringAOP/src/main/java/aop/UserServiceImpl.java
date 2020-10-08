package aop;

public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("add a user...");
    }

    @Override
    public void delete() {
        System.out.println("delete a user...");
    }

    @Override
    public void update() {
        System.out.println("update...");
    }

    @Override
    public void query() {
        System.out.println("query...");
    }
}
