package com.github.lavenderx.springbootscala.config

import java.text.SimpleDateFormat

import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.boot.SpringBootConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@SpringBootConfiguration
class SpringScalaConfig {

  @Bean def jacksonBuilder = new Jackson2ObjectMapperBuilder()
      .dateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"))
      .modules(new DefaultScalaModule, new Jdk8Module, new JavaTimeModule)
}
