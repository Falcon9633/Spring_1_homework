package beans.interfaceBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NewBean {
    private Animal cat;
    private Animal dog;
    private Animal mouse;


    @Autowired
    public NewBean(Animal cat, @Qualifier("dogBean") Animal dog, @Qualifier("mouseBean") Animal mouse) {
        this.cat = cat;
        this.dog = dog;
        this.mouse = mouse;
    }

    @Override
    public String toString() {
        return "NewBean{" +
                "cat=" + cat.getType() +
                ", dog=" + dog.getType() +
                ", mouse=" + mouse.getType() +
                '}';
    }
}
