package beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanE implements BeanValidator{
    private String name;
    private int value;

    public BeanE(String name, int value) {
        this.name = name;
        this.value = value;
        System.out.println("beanE: constructor()");
    }

    @Override
    public String toString() {
        return "BeanE{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @PostConstruct
    private void postConstruct(){
        System.out.println("beanE: postConstruct()");
    }

    @PreDestroy
    private void preDestroy(){
        System.out.println("beanE: preDestroy()");
    }

    @Override
    public void validate() {
        if (name == null) {
            System.out.println("beanE: name should not be null");
        }
        if (value < 0) {
            System.out.println("beanE: value should not be less then 0");
        }
    }
}
