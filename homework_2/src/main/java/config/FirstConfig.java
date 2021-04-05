package config;

import beans.BeanB;
import beans.BeanC;
import beans.BeanD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("beans")
@PropertySource("classpath:properties.properties")
public class FirstConfig {
    @Autowired
    private Environment env;

    @Bean(value = "beanB", initMethod = "initMethod", destroyMethod = "destroyMethod")
    @DependsOn("beanD")
    public BeanB getBeanB() {
        return new BeanB(env.getProperty("beanB.name"), Integer.parseInt(env.getProperty("beanB.value")));
    }

    @Bean(value = "beanC", initMethod = "initMethod", destroyMethod = "destroyMethod")
    @DependsOn("beanB")
    public BeanC getBeanC(){
        return new BeanC(env.getProperty("beanC.name"), Integer.parseInt(env.getProperty("beanC.value")));
    }

    @Bean(value = "beanD", initMethod = "initMethod", destroyMethod = "destroyMethod")
    public BeanD getBeanD(){
        return new BeanD(env.getProperty("beanD.name"), Integer.parseInt(env.getProperty("beanD.value")));
    }
}
