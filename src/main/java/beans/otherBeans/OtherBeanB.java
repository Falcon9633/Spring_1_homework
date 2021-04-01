package beans.otherBeans;

import org.springframework.stereotype.Component;

@Component
public class OtherBeanB {
    private String name = "OtherBeanB";

    @Override
    public String toString() {
        return name;
    }
}
