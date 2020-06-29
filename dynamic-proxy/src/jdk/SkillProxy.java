package jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by caidapao on 2020-5-6
 * Time 20:49
 * Address https://today.caidapao.com
 */
public class SkillProxy implements InvocationHandler {

    private Object target;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target, args);
        System.out.println("哈哈我是代理包装类，代理了" + method.getName() + "方法：做了强化");
        return result;
    }

    public Object createProxy(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
    }

}
