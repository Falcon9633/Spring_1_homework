package beans.interfaceBeans;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class MouseBean implements Animal{
    @Override
    public String getType() {
        return "mouse";
    }
}
