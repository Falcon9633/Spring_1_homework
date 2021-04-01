package beans.autowiredBeans;

import beans.otherBeans.OtherBeanB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutowiredBeanB {
    private OtherBeanB otherBeanB;

    @Autowired
    public AutowiredBeanB(OtherBeanB otherBeanB) {
        this.otherBeanB = otherBeanB;
    }

    @Override
    public String toString() {
        return otherBeanB.toString();
    }
}
