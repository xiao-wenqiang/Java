package service;


import mapper.UserMapper;

public class UserServiceImpl implements UserService {

    private UserMapper userDao; //记得注入

//利用setter()实现动态注入值，实现控制反转：由主动创建对象->变为被动接收对象
    public void setUserDao(UserMapper userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        //业务层调用DAO层，也实现了静态代理
        userDao.getUserList();
    }

}
