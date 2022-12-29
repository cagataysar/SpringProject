package com.garanti.FirstSpringWeb.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

// localhost:9090/FirstSpringWeb/ogretmen

@RestController
@RequestMapping(path = "ogretmen")
public class OgretmenController //implements ApplicationContextAware
{
    @GetMapping(path = "hello")
    public String helloSpring()
    {
//        int k = 7 / 0;
//        localhost:9090/FirstSpringWeb/ogretmen/hello
        return "Hello Spring World";
    }

    // Bean'leri console'da görmek için yazdığımız metot
    /*@Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        String[] names = applicationContext.getBeanDefinitionNames();
        Arrays.sort(names);
        System.err.println("--------------------------------------");
        System.err.println("---- " + names.length + " ----");
        for (String name : names)
        {
            System.err.println(name + " ---> " + applicationContext.getBean(name).getClass().getName());
        }
        System.err.println("--------------------------------------");
    }*/
}
