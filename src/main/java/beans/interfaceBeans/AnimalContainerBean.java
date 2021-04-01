package beans.interfaceBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnimalContainerBean {
    private List<Animal> animals;

    @Autowired
    public AnimalContainerBean(List<Animal> animals) {
        this.animals = animals;
    }

    public void printTypes(){
        for (Animal animal : animals) {
            System.out.println(animal.getType());
        }
    }
}
