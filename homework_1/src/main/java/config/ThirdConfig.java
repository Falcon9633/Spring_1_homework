package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("beans.otherBeans")
@ComponentScan("beans.autowiredBeans")
public class ThirdConfig {
}
