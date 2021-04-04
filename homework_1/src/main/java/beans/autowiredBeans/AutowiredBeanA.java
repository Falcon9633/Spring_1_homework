package beans.autowiredBeans;

import beans.otherBeans.OtherBeanA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutowiredBeanA {
    @Autowired
    private OtherBeanA otherBeanA;

    @Override
    public String toString() {
        return otherBeanA.toString();
    }
}
