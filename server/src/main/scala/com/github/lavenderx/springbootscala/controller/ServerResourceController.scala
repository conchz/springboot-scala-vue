package com.github.lavenderx.springbootscala.controller

import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RestController}

@RestController
class ServerResourceController {

  @RequestMapping(path = Array("/api/v1/serverInfo"), method = Array(RequestMethod.GET))
  def getInfo: Object = {
    Map("name" -> "springboot-scala-vue-examples")
  }
}
