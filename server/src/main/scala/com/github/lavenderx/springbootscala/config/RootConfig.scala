package com.github.lavenderx.springbootscala.config

import org.springframework.boot.SpringBootConfiguration
import org.springframework.context.annotation.{Bean, ComponentScan, PropertySource}
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.springframework.core.annotation.Order

@Order(-100)
@SpringBootConfiguration
@ComponentScan(Array("com.github.lavenderx.springbootscala.service"))
@PropertySource(Array("classpath:commons-config.properties", "classpath:application-${spring.profiles.active}.properties"))
class RootConfig {

}

object RootConfig {
  @Bean def placeholderConfigurer = new PropertySourcesPlaceholderConfigurer
}
