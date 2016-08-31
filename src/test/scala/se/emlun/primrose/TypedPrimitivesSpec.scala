package se.emlun.primrose

import org.scalatest.FunSpec
import org.scalatest.Matchers

import TypedPrimitives._
import StockPrimitiveTypes._

class TypedPrimitivesSpec extends FunSpec {

  trait Foo
  trait Bar

  describe("A TInt") {

    val one: TInt[Foo] = 1
    val anotherOne: TInt[Foo] = 1
    val two: TInt[Foo] = 2

    val aFoo: TInt[Foo] = 1
    val anotherFoo: TInt[Foo] = 1
    val aBar: TInt[Bar] = 1

    describe("has a .value accessor which exposes the raw value.") {
      val oneValue: Int = one.value
      assert(oneValue == 1)
    }

    it("has == and != operators which compile, but throw UnsupportedOperationException.") {
      assertCompiles("aFoo equals anotherFoo")
      assertCompiles("aFoo == anotherFoo")
      assertCompiles("aFoo != anotherFoo")
      assertCompiles("aFoo equals aBar")
      assertCompiles("aFoo == aBar")
      assertCompiles("aFoo != aBar")

      assertThrows[UnsupportedOperationException] { aFoo equals anotherFoo }
      assertThrows[UnsupportedOperationException] { aFoo == anotherFoo }
      assertThrows[UnsupportedOperationException] { aFoo != anotherFoo }
      assertThrows[UnsupportedOperationException] { aFoo equals aBar }
      assertThrows[UnsupportedOperationException] { aFoo == aBar }
      assertThrows[UnsupportedOperationException] { aFoo != aBar }
    }

    describe("has a === operator which") {
      it("compiles iff the RHS is of the same type or a raw value.") {
        assertCompiles("aFoo === anotherFoo")
        assertCompiles("aFoo === 1")
        assertDoesNotCompile("aFoo === aBar")
      }

      it("returns true iff the contained values are equal.") {
        assert(one === anotherOne)
        assert(!(one === two))
      }
    }

    describe("has a !== operator which") {
      it("compiles iff the RHS is of the same type or a raw value.") {
        assertCompiles("aFoo !== anotherFoo")
        assertCompiles("aFoo !== 1")
        assertDoesNotCompile("aFoo !== aBar")
      }

      it("returns true iff the contained values are not equal.") {
        assert(!(one !== anotherOne))
        assert(one !== two)
      }
    }

    describe("has a < operator which") {
      it("compiles iff the RHS is of the same type or a raw value.") {
        assertCompiles("aFoo < anotherFoo")
        assertCompiles("aFoo < 1")
        assertDoesNotCompile("aFoo < aBar")
      }

      it("returns true iff the LHS is strictly less than the RHS.") {
        assert(!(one < anotherOne))
        assert(one < two)
        assert(!(two < one))
      }
    }

    describe("has a <= operator which") {
      it("compiles iff the RHS is of the same type or a raw value.") {
        assertCompiles("aFoo <= anotherFoo")
        assertCompiles("aFoo <= 1")
        assertDoesNotCompile("aFoo <= aBar")
      }

      it("returns true iff the LHS is less than or equal to the RHS.") {
        assert(one <= anotherOne)
        assert(one <= two)
        assert(!(two <= one))
      }
    }

    describe("has a > operator which") {
      it("compiles iff the RHS is of the same type or a raw value.") {
        assertCompiles("aFoo > anotherFoo")
        assertCompiles("aFoo > 1")
        assertDoesNotCompile("aFoo > aBar")
      }

      it("returns true iff the LHS is strictly greater than the RHS.") {
        assert(!(one > anotherOne))
        assert(!(one > two))
        assert(two > one)
      }
    }

    describe("has a >= operator which") {
      it("compiles iff the RHS is of the same type or a raw value.") {
        assertCompiles("aFoo >= anotherFoo")
        assertCompiles("aFoo >= 1")
        assertDoesNotCompile("aFoo >= aBar")
      }

      it("returns true iff the LHS is greater than or equal to the RHS.") {
        assert(one >= anotherOne)
        assert(!(one >= two))
        assert(two >= one)
      }
    }

    it("has a unary + operator which returns the operand itself.") {
      assert((+one) eq one)
    }

    describe("has a binary + operator which") {
      it("compiles iff the RHS is of the same type or a raw value.") {
        assertCompiles("aFoo + anotherFoo")
        assertCompiles("aFoo + 1")
        assertDoesNotCompile("aFoo + aBar")
      }

      it("returns the sum of the LHS and the RHS.") {
        assert(one + anotherOne === 2)
      }
    }

    it("has a unary - operator which returns an object whose value is the negative of that of the operand.") {
      assert((-one).value == (-(one.value)))
    }

    describe("has a binary - operator which") {
      it("compiles iff the RHS is of the same type or a raw value.") {
        assertCompiles("aFoo - anotherFoo")
        assertCompiles("aFoo - 1")
        assertDoesNotCompile("aFoo - aBar")
      }

      it("returns the RHS subtracted from the LHS.") {
        assert(two - one === 1)
      }
    }

    describe("has a binary * operator which") {
      it("compiles iff the RHS is of the same type or a raw value.") {
        assertCompiles("aFoo * anotherFoo")
        assertCompiles("aFoo * 1")
        assertDoesNotCompile("aFoo * aBar")
      }

      it("returns the product of the LHS and the RHS.") {
        assert(one * two === 2)
      }
    }

    describe("has a binary / operator which") {
      it("compiles iff the RHS is of the same type or a raw value.") {
        assertCompiles("aFoo / anotherFoo")
        assertCompiles("aFoo / 1")
        assertDoesNotCompile("aFoo / aBar")
      }

      it("returns the quotient of the integer division of the LHS by the RHS.") {
        val two: TInt[Foo] = 2
        val five: TInt[Foo] = 5
        assert(two / two === 1)
        assert(five / two === 2)
      }
    }

    describe("has a binary % operator which") {
      it("compiles iff the RHS is of the same type or a raw value.") {
        assertCompiles("aFoo % anotherFoo")
        assertCompiles("aFoo % 1")
        assertDoesNotCompile("aFoo % aBar")
      }

      it("returns the remainder of the integer division of the LHS by the RHS.") {
        val two: TInt[Foo] = 2
        val five: TInt[Foo] = 5
        assert(two % two === 0)
        assert(five % two === 1)
      }
    }

  }
}
