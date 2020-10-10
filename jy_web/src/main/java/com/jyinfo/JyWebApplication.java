package com.jyinfo;

import ChatRoom.MyServer;
import ChatRoom.ServerHandler;
import ChatRoom.ServerHandlerImpl;
import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.net.Socket;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, MultipartAutoConfiguration.class},scanBasePackages= {"com.jyinfo.*","com.jyinfo.jy_security.service.serviceImpl"})
@EnableSwagger2
@EnableSwaggerBootstrapUI
@MapperScan("com.jyinfo.jy_domain.mapper.mybatisMapper")
public class JyWebApplication {

    public static void main(String[] args) throws IOException {

        SpringApplication.run(JyWebApplication.class, args);
    }

}
