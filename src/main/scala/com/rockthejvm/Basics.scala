package com.rockthejvm

object Basics extends App {
  // in scala we work with values
  // reminds me of Golang
  // think of a value as a constant
  // cannot be reassinged
  val meaningOfLife: Int = 42
  // type specification is not required
  val aBoolean = false
  // compiler knows that above is a boolean
  // Int, Boolean, Char, Double, Float, String types

  // String and String operations
  val aString = "I love Scala"
  val aComposedString = "I" + " " + "love" + " " + "Scala";
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

  // expressions = structures that can be reduced to a value
  val anExpression = 2 + 3

  // if-expression
  val ifExpression = if (meaningOfLife > 43) 56 else 999
  val chainedIfExpression =
    if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 9) 78
    else 0

  // code blocks
  val aCodeBlock = {
    // definitions
    val aLocalValue = 67
    // value of block is the value of the last expression
    aLocalValue + 3
  }

  // define a function
  def myFunction(x: Int, y: String): String = y + " " + x
  def myFunctionCodeBlock(x: Int, y: String): String = {
    y + " " + x
  }

  // recusrive functions
  def factorial(n: Int): Int =
    if ( n <= 1) 1
    else n * factorial(n - 1)

  /*
    factorial(5) = 5 * factorial(4) = 5 * 24 = 120
    factorial(4) = 4 * factorial(3) = 4 * 6
    factorial(3) = 3 * factorial(2) = 3 * 2
    factorial(2) = 2 * factorial(1) = 2 * 1
    factorial(1) = 1
   */

  // In scala we don't use loops or iteration, we use RECURSION!

  // the Unit type = no meaningful value === "void"
  // type of SIDE EFFECTS, no computing of meaningful values
  println("this is scala") // eg. console.log, echo, printf
  def myUnitReturningFunction() : Unit = {
    println("I don't love returning Unit")
  }

  // return unit would be ()
  val theUnit = ()
}
