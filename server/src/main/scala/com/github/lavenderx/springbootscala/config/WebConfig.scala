package com.github.lavenderx.springbootscala.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.annotation.{Bean, ComponentScan, Import}
import org.springframework.core.annotation.Order
import org.springframework.core.io.Resource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.{RequestMapping, RestController}
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.filter.CharacterEncodingFilter
import org.springframework.web.servlet.DispatcherServlet
import org.springframework.web.servlet.config.annotation.{ResourceHandlerRegistry, WebMvcConfigurerAdapter}

@Order(-1)
@SpringBootConfiguration
@ComponentScan(Array("com.github.lavenderx.springbootscala.controller"))
@Import(Array[Class[_]](classOf[RootConfig]))
@RestController
class WebConfig extends WebMvcConfigurerAdapter {

  @Value("classpath:/ui/index.html") private[this] val indexHtml: Resource = null

  @Bean def characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true)

  @Bean def apiV1ServletBean(wac: WebApplicationContext): ServletRegistrationBean = {
    val servlet: DispatcherServlet = new DispatcherServlet(wac)
    val bean: ServletRegistrationBean = new ServletRegistrationBean(servlet, "/api/v1/**")
    bean.setName("api-v1")
    bean
  }

  override def addResourceHandlers(registry: ResourceHandlerRegistry): Unit = {
    registry.addResourceHandler("/**").addResourceLocations("classpath:/ui/")
  }

  @RequestMapping(Array("/")) def index = ResponseEntity.ok.body(indexHtml)
}