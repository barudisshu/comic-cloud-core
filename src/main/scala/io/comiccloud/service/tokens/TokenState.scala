package io.comiccloud.service.tokens

import io.comiccloud.entity.EntityFieldsObject
import io.comiccloud.rest.ServiceProtocol._
import org.joda.time.DateTime
import spray.json.RootJsonFormat

trait TokenState extends EntityFieldsObject[String, TokenState]

object TokenInitialState {
  def empty = TokenInitialState("")
}

case class TokenInitialState(id: String, deleted: Boolean = false) extends TokenState {
  override def assignId(id: String): TokenState = this.copy(id)
  override def markDeleted: TokenState          = this
}

object CreatedValidationFO {
  def validation = CreatedValidationFO("")
}

case class CreatedValidationFO(id: String, deleted: Boolean = false) extends TokenState {
  override def assignId(id: String): TokenState = this.copy(id)
  override def markDeleted: TokenState          = this
}

object TokenFO {
  def empty                                    = TokenFO("", "", "", "", "", "")
  implicit val format: RootJsonFormat[TokenFO] = jsonFormat9(TokenFO.apply)
}

case class TokenFO(id: String,
                   accountId: String,
                   appid: String,
                   appkey: String,
                   token: String,
                   refreshToken: String,
                   createdAt: DateTime = DateTime.now(),
                   expiredAt: DateTime = DateTime.now(),
                   deleted: Boolean = false)
    extends TokenState {
  override def assignId(id: String): TokenState = this.copy(id)
  override def markDeleted: TokenState          = this
}

object TokenPair {
  implicit val format: RootJsonFormat[TokenPair] = jsonFormat2(TokenPair.apply)
}

case class TokenPair(token: String, refreshToken: String) extends TokenState {
  override def assignId(id: String): TokenState = this.copy(id)
  override def id: String                       = token
  override def deleted: Boolean                 = false
  override def markDeleted: TokenState          = this
}
