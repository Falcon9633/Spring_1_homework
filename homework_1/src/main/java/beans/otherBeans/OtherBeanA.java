package beans.otherBeans;

import org.springframework.stereotype.Component;

@Component
public class OtherBeanA {
    private String name = "OtherBeanA";

    @Override
    public String toString() {
        return name;
    }
}
