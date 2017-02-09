package com.github.lavenderx.springbootscala.data.domain

import java.time.LocalDateTime

import scala.beans.BeanProperty

case class Message(name: String,
                   age: Int,
                   user: User,
                   status: Option[Boolean]) {
  @BeanProperty
  val createdTime: LocalDateTime = LocalDateTime.now()
}