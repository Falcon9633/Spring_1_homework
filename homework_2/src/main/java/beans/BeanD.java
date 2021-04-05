package beans;

public class BeanD implements BeanValidator{
    private String name;
    private int value;

    public BeanD(String name, int value) {
        this.name = name;
        this.value = value;
        System.out.println("beanD: constructor()");
    }

    @Override
    public String toString() {
        return "BeanD{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    private void initMethod(){
        System.out.println("beanD: initMethod()");
    }

    private void destroyMethod(){
        System.out.println("beanD: destroyMethod()");
    }

    @Override
    public void validate() {
        if (name == null) {
            System.out.println("beanD: name should not be null");
        }
        if (value < 0) {
            System.out.println("beanD: value should not be less then 0");
        }
    }
}
