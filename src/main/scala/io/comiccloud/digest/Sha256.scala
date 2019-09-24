package io.comiccloud.digest

import java.util

case class Sha256(bytes: Array[Byte]) {
  require(bytes.length == 32, s"Invalid Sha256: 32 bytes expected but ${bytes.length} provided")

  override def toString: String = bytes2hex(bytes)
  override def hashCode(): Int  = util.Arrays.hashCode(bytes)
  override def equals(that: Any): Boolean = that match {
    case that: Sha256 => util.Arrays.equals(bytes, that.bytes)
    case _            => false
  }
}

object Sha256 {
  def apply(hex: String): Sha256 = Sha256(hex2bytes(hex))
}
