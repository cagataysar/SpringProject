package com.garanti.FirstSpringWeb.config;

import com.garanti.FirstSpringWeb.model.PersonBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanFactory
{
    /*public BeanFactory () {
        System.err.println("-------> BeanFactory new yapılıyor");
    }*/

    @Bean(name = "person1")
    public PersonBean getPerson() {
        return new PersonBean(12, "şerafettin");
    }
}
