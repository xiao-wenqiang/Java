package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pojo.User;

//Configuration实现了Component也是组件，也注册在容器，交由spring管理
    //Configuration是一个配置类，和.xml配置文件一样实现配置。
@Configuration    //代替.xml的<beans ...
//@Import(BeansConfig2.class)
//@ComponentScan("yf")    //显示配置了扫描包
public class SpringConfig {

    @Bean    //代替<bean .../>
    public User getUser(){
        return new User();
    }

}

//获取beans ->获取bean ->操作bean