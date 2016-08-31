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

/** A bunch of bundled names to use for your typed primitives
  *
  * If you need a name not provided here, simply define an empty sealed trait
  * and use that.
  */
object StockPrimitiveTypes {

  sealed trait Ampere
  sealed trait Candela
  sealed trait Celsius
  sealed trait Degrees
  sealed trait Fahrenheit
  sealed trait Identifier
  sealed trait Index
  sealed trait Kelvin
  sealed trait Kilograms
  sealed trait Metres
  sealed trait Moles
  sealed trait Numeral
  sealed trait Percent
  sealed trait Radians
  sealed trait Ratio
  sealed trait Seconds

}
