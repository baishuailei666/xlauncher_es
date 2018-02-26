package AlertEventLog.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * 方法一：
 * 创建获取Spring的生成类
 * 普通类调用Spring注解方式的Service层bean
 * @author 白帅雷
 * @date 2018-02-06
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext ;  //Spring应用上下文环境

    /**
     * 此方法可以把ApplicationContext对象inject到当前类中作为一个静态成员变量。
     * 加上@Override注解，因为是继承ApplicationContextAware接口是必须实现的方法
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtil.applicationContext  = applicationContext;
        //ApplicationContext配置成功,在普通类可以通过调用SpringUtils.getAppContext()获取applicationContext对象,

    }

    /**
     * 获取ApplicationContext
     * 有了这个ApplicationContext之后
     * 我们就可以调用其getBean("beanName")方法来得到由Spring管理所有对象.
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 这是一个便利的方法，通过name获取 Bean 帮助我们快速得到一个BEAN
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) throws BeansException{
//        return getApplicationContext().getBean(beanName);
        return applicationContext.getBean(beanName);
    }

    /**
     * 通过class获取Bean.
     * @param clazz
     * @return
     */
    public static Object getBean(Class clazz){
//        return getApplicationContext().getBean(clazz);
        return applicationContext.getBean(clazz);
    }

    /**
     * 通过name,以及Clazz返回指定的Bean
     * @param name
     * @param clazz
     * @return
     */
    public static Object getBean(String name,Class clazz) throws BeansException{
//        return getApplicationContext().getBean(name, clazz);
        return applicationContext.getBean(name,clazz);
    }



    public static boolean containsBean(String name) {
        return applicationContext.containsBean(name);
    }

    public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException{
        return applicationContext.isPrototype(name);
    }

    public static Class getType(String name) throws NoSuchBeanDefinitionException{
        return applicationContext.getType(name);
    }

    public static String[] getAliases(String name) throws NoSuchBeanDefinitionException{
        return applicationContext.getAliases(name);
    }

}
