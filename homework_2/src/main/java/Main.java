import config.SecondConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        String delimiter = "-----------------------------------------";
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SecondConfig.class);
        System.out.println(delimiter);

        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        System.out.println(delimiter);

        context.getBean("beanF");
        System.out.println(delimiter);

        context.close();
    }

}
