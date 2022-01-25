package net.javahaul.springbootforhaulmont;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SpringbootforhaulmontApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootforhaulmontApplication.class, args);
    }

}
