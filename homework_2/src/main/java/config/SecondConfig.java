package config;

import beans.BeanA;
import beans.BeanE;
import beans.BeanF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@Import(FirstConfig.class)
@PropertySource("classpath:properties.properties")
public class SecondConfig {
    @Autowired
    private Environment env;

    @Bean("beanA")
    public BeanA getBeanA(){
        return new BeanA("beanA", -10);
    }

    @Bean("beanE")
    public BeanE getBeanE(){
        return new BeanE(null, 10);
    }

    @Bean("beanF")
    @Lazy
    public BeanF getBeanF(){
        return new BeanF("beanF", 0);
    }
}
