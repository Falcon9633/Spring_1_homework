package beans.interfaceBeans;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class DogBean implements Animal{
    @Override
    public String getType() {
        return "dog";
    }
}
