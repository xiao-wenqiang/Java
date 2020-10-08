package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyIH implements InvocationHandler {

    //被代理的接口
    private Object object;

    //设置要代理的对象
    public void setProxyIH(Object object){
        this.object = object;
    }

    //生成代理对象
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    //执行代理
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before()...");

        //动态代理本质：还是反射的实现
        Object result = method.invoke(object,args);

        System.out.println("after()...");

        return result;
    }
}