import beans.autowiredBeans.AutowiredBeanA;
import beans.autowiredBeans.AutowiredBeanB;
import beans.autowiredBeans.AutowiredBeanC;
import beans.interfaceBeans.AnimalContainerBean;
import beans.interfaceBeans.NewBean;
import config.FirstConfig;
import config.InterfaceConfig;
import config.SecondConfig;
import config.ThirdConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        String delimiter = "---------------------------";
        ApplicationContext context = new AnnotationConfigApplicationContext(FirstConfig.class);
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        System.out.println(delimiter);

        context = new AnnotationConfigApplicationContext(SecondConfig.class);
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        System.out.println(delimiter);

        context = new AnnotationConfigApplicationContext(ThirdConfig.class);
        AutowiredBeanA autowiredBeanA = context.getBean(AutowiredBeanA.class);
        System.out.println(autowiredBeanA);
        AutowiredBeanB autowiredBeanB = context.getBean(AutowiredBeanB.class);
        System.out.println(autowiredBeanB);
        AutowiredBeanC autowiredBeanC = context.getBean(AutowiredBeanC.class);
        System.out.println(autowiredBeanC);
        System.out.println(delimiter);

        context = new AnnotationConfigApplicationContext(InterfaceConfig.class);
        AnimalContainerBean animalContainerBean = context.getBean(AnimalContainerBean.class);
        animalContainerBean.printTypes();
        NewBean newBean = context.getBean(NewBean.class);
        System.out.println(newBean);

    }
}
