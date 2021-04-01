package beans.otherBeans;

import org.springframework.stereotype.Component;

@Component
public class OtherBeanC {
    private String name = "OtherBeanC";

    @Override
    public String toString() {
        return name;
    }
}
