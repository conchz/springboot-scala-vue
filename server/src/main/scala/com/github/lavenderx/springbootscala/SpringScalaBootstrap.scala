package com.github.lavenderx.springbootscala

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(Array("com.github.lavenderx.springbootscala.config"))
private[this] class AppConfig {

}

object SpringScalaBootstrap {
  private[this] val SPRING_PROFILE = "spring.profiles.active"

  def main(args: Array[String]) {
    if (sys.props.get(SPRING_PROFILE).isEmpty) {
      System.setProperty(SPRING_PROFILE, "dev")
    }

    SpringApplication.run(classOf[AppConfig])
  }
}
