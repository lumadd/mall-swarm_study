package com.macro.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.macro.mall.mapper")
public class MyBatisConfig {
}