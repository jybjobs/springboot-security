package com.yihecloud;

import com.didispace.swagger.EnableSwagger2Doc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableSwagger2Doc
@SpringBootApplication  //开启自动配置
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) 关闭特定自动配置
//@ImportResource({"classpath:spring-context.xml","classpath:mybatis-context.xml"}) 加载xml
public class SpringbootDemoApplication {
	public static final Logger log = LoggerFactory.getLogger(SpringbootDemoApplication.class);


	public static void main(String[] args) {

		SpringApplication.run(SpringbootDemoApplication.class, args);
	}
}
