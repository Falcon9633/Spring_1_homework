package config;

import beans.beans3.BeanD;
import beans.beans3.BeanE;
import beans.beans3.BeanF;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan("beans.beans2")
@ComponentScan(basePackages = {"beans.beans3"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*Bean[^DF]")})
public class SecondConfig {
}
