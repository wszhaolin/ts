package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
@MapperScan("com.baizhi.dao") //注意事项: mybatis和spring boot整合 扫描DAO接口
public class DayApplication {
    public static void main(String[] args) {
        SpringApplication.run(DayApplication.class, args);
    }

}

