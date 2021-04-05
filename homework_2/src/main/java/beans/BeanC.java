package beans;

public class BeanC implements BeanValidator{
    private String name;
    private int value;

    public BeanC(String name, int value) {
        this.name = name;
        this.value = value;
        System.out.println("beanC: constructor()");
    }

    @Override
    public String toString() {
        return "BeanC{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    private void initMethod(){
        System.out.println("beanC: initMethod()");
    }

    private void destroyMethod(){
        System.out.println("beanC: destroyMethod()");
    }

    @Override
    public void validate() {
        if (name == null) {
            System.out.println("beanC: name should not be null");
        }
        if (value < 0) {
            System.out.println("beanC: value should not be less then 0");
        }
    }
}
