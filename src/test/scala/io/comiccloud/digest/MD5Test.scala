package io.comiccloud.digest

import org.scalatest.{FlatSpec, Matchers}

class MD5Test extends FlatSpec with Matchers {
  "it" should "include the underlying bytes in equality comparison" in {
    MD5("6a18b3c45107538de9d430f83a6af988") shouldBe MD5("6a18b3c45107538de9d430f83a6aF988")
  }

  "it" should "include the underlying bytes in hashcode computation" in {
    MD5("6a18b3c45107538de9d430f83a6af988").hashCode() shouldBe MD5("6a18b3c45107538de9d430f83a6af988").hashCode()
  }

  "it" should "convert MD5 to lower-case" in {
    MD5("6A18B3C45107538DE9D430F83A6AF988").toString() shouldBe "6a18b3c45107538de9d430f83a6af988"
  }
}