package com.star.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.star.springboot.mapper")
//@ServletComponentScan
public class SpringbootApplication {

	public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件

//        try {
//            SpringApplication.run(SpringbootApplication.class, args);
//        } catch (Exception e){
//            e.printStackTrace();
//        }

        SpringApplication.run(SpringbootApplication.class, args);
//		SpringApplication springApplication = new SpringApplication(SpringbootApplication.class);
//		springApplication.addListeners();

	}
}
