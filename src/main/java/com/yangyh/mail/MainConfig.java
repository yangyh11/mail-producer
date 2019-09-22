package com.yangyh.mail;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @description:
 * @author: yangyh
 * @create: 2019-09-03 23:32
 */
@EnableWebMvc       // 启用spring mvc
@Configuration      // 让springboot启动时识别该配置类
@ComponentScan({"com.yangyh.mail.*"})   //
@MapperScan(basePackages = "com.yangyh.mail.mapper")
public class MainConfig {
}
