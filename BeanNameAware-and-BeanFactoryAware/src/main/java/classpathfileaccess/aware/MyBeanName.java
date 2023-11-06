package classpathfileaccess.aware;

import org.springframework.beans.factory.BeanNameAware;

/**
 * BeanNameAware使对象知道容器中定义的 bean 名称。
 */
public class MyBeanName implements BeanNameAware {

    @Override
    public void setBeanName(String beanName) {
        System.out.println(beanName);
    }
}
