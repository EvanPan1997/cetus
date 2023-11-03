package com.cetus;

import com.cetus.core.factory.CetusPropertySourceFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "classpath:env/default/application.yaml", encoding = "UTF-8", factory = CetusPropertySourceFactory.class)
@MapperScans({
        @MapperScan("com.cetus.mapper"),
        @MapperScan("com.cetus.core.mapper")
})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
