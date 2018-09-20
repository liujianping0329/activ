package com.datsjin.activ;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAsync
@EnableTransactionManagement(proxyTargetClass = true)
@Log
public class ActivApplication {
    @Value("${spring.application.name}")
    public String projectName;

    public static void main(String[] args) {
        ConfigurableApplicationContext contenxt = SpringApplication.run(ActivApplication.class, args);
        ActivApplication obj = contenxt.getBean(ActivApplication.class);
        log.info("SpringBoot Start Success: " + obj.projectName);
    }
}
