package beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanA implements InitializingBean, DisposableBean, BeanValidator {
    private String name;
    private int value;

    public BeanA(String name, int value) {
        this.name = name;
        this.value = value;
        System.out.println("beanA: constructor()");
    }

    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("beanA: DisposableBean.destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("beanA: InitializingBean.afterPropertiesSet()");
    }

    @Override
    public void validate() {
        if (name == null) {
            System.out.println("beanA: name should not be null");
        }
        if (value < 0) {
            System.out.println("beanA: value should not be less then 0");
        }
    }
}
