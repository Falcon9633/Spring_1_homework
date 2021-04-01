package beans.interfaceBeans;

import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@Primary
public class CatBean implements Animal{
    @Override
    public String getType() {
        return "cat";
    }
}
