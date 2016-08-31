// Primrose - Strongly typed "primitives" for Scala
// Copyright (C) 2016  Emil Lundberg
//
// This library is free software: you can redistribute it and/or modify it under
// the terms of the GNU Lesser General Public License as published by the Free
// Software Foundation, either version 3 of the License, or (at your option) any
// later version.
//
// This library is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
// details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this library. If not, see <http://www.gnu.org/licenses/>.

package se.emlun.primrose

sealed trait TypedPrimitive[T] {
  def value: T
}

object TypedPrimitives {

  case class TByte[A](value: Byte)
  case class TChar[A](value: Char)
  case class TDouble[A](value: Double)
  case class TFloat[A](value: Float)

  implicit class TInt[A](val value: Int) {

    @deprecated("Use === operator instead", "always")
    override def equals(other: Any): Boolean =
      throw new UnsupportedOperationException(
        s"You are using the ==(Any) or equals(Any) method on a ${this.getClass} value. Use ===(${this.getClass}) instead."
      )

    def ===(other: TInt[A]): Boolean = this.value == other.value
    def !==(other: TInt[A]): Boolean = !(this === other)

    def <(other: TInt[A]): Boolean = this.value < other.value
    def <=(other: TInt[A]): Boolean = this.value <= other.value
    def >(other: TInt[A]): Boolean = this.value > other.value
    def >=(other: TInt[A]): Boolean = this.value >= other.value

    def unary_+(): TInt[A] = this
    def +(other: TInt[A]): TInt[A] = this.value + other.value
    def unary_-(): TInt[A] = -(this.value)
    def -(other: TInt[A]): TInt[A] = this.value - other.value
    def *(other: TInt[A]): TInt[A] = this.value * other.value
    def /(other: TInt[A]): TInt[A] = this.value / other.value
    def %(other: TInt[A]): TInt[A] = this.value % other.value

    override lazy val toString = s"TInt($value)"
  }

  case class TLong[A](value: Long)
  case class TShort[A](value: Short)

}
