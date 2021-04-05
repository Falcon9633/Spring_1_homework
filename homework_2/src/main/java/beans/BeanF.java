package beans;

public class BeanF implements BeanValidator{
    private String name;
    private int value;

    public BeanF(String name, int value) {
        this.name = name;
        this.value = value;
        System.out.println("beanF: constructor()");
    }

    @Override
    public String toString() {
        return "BeanF{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public void validate() {
        if (name == null) {
            System.out.println("beanF: name should not be null");
        }
        if (value < 0) {
            System.out.println("beanF: value should not be less then 0");
        }
    }
}
