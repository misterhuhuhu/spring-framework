package classpathfileaccess.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;


/**
 * BeanFactoryAware用于注入BeanFactory对象
 *
 * BeanFactory按需加载 bean，而ApplicationContext在启动时加载所有 bean。
 * 因此，与ApplicationContext相比， BeanFactory是轻量级的
 */
public class MyBeanFactory implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void getMyBeanName() {
        MyBeanName myBeanName = beanFactory.getBean(MyBeanName.class);
        System.out.println(beanFactory.isSingleton("myCustomBeanName"));
    }

}
