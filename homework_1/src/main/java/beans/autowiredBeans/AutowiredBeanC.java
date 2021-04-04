package beans.autowiredBeans;

import beans.otherBeans.OtherBeanC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AutowiredBeanC {
    private OtherBeanC otherBeanC;

    @Qualifier("otherBeanC")
    @Autowired
    public void setOtherBeanC(OtherBeanC otherBeanC) {
        this.otherBeanC = otherBeanC;
    }

    @Override
    public String toString() {
        return otherBeanC.toString();
    }
}
