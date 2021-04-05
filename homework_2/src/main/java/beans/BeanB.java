package beans;

public class BeanB implements BeanValidator{
    private String name;
    private int value;

    public BeanB(String name, int value) {
        this.name = name;
        this.value = value;
        System.out.println("beanB: constructor()");
    }

    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    private void initMethod(){
        System.out.println("beanB: initMethod()");
    }

    private void destroyMethod(){
        System.out.println("beanB: destroyMethod()");
    }

    private void otherInitMethod() {
        System.out.println("beanB: otherInitMethod()");
    }

    @Override
    public void validate() {
        if (name == null) {
            System.out.println("beanB: name should not be null");
        }
        if (value < 0) {
            System.out.println("beanB: value should not be less then 0");
        }
    }
}
