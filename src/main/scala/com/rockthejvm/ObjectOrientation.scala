package com.rockthejvm

class ObjectOrientation extends App {
  // When defining an object extending app you already have a static main method implemented by extending app
  // java public static void main(String[] args)
  // main method would just run this objects body, runs object as a dedicated application
  // class and instance
  class Animal {
    val age: Int = 0
    def eat() = println("I'm eating")
  }
  val anAnimal = new Animal

  // inheritance
  // constructor arguemnts also constructor definition
  class Dog(val name: String) extends Animal
  val aDog = new Dog("Lassie")
  // constructor arguments are not fields
  // aDog.name
  // need to put a val before constructor argument for it to become a val
  aDog.name // now works

  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime

  // abstract class
  abstract class WalingAnimal {
    val hasLegs = true // by default public, can restrict by using private / protected
    def walk(): Unit // any class that extends WalkingAnimal will need to define
  }

  // "interface" = ultimate abstract type, can leave everything undefined
  trait Carnivor {
    def eat(animal: Animal): Unit
  }

  trait Philosipher {
    def ?!(thought: String): Unit // valid method name
  }

  // Similar to PHP scalar allows single class inheritance, and mutli-trait inheritance

  class Crocodile extends Animal with Carnivor with Philosipher {
    override def eat(animal: Animal): Unit = println("I am eating you, animal!")
    override def ?!(thought: String): Unit = println(s"I was thinking: $thought")
//    override def eat(): Unit = super.eat() // overrides eat in Animal
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // infix notation = object method argument, only avail for methods with ONE argument
  aCroc ?! "What if we could fly"

  // operators in Scala are actually methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2)

  // anonymous classes
  val dinosaur = new Carnivor {
    override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat pretty mich anything")
  }

  /*
  What you tell the compiler:
    class Carnivor_Anonymouse_78655 extends Carnivor {
      override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat pretty mich anything")
    }

    val dinosaur = new Carnivor_Anonymouse_78655
  */

  // singleton object
  object MySingleton { // the only instance of the MySingleton type
    val mySpecialValue = 45678
    def mySpecialMethod(): Int = 32423
    // using the apply method in a class allows instances of that class to be instantiated like a function
    def apply(x: Int): Int = x + 1
  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65)

  // below is now a singleton
  object SingletonTest {
    val mySpecialValue = 45678
    def mySpecialMethod(): Int = 32423
    // using the apply method in a class allows instances of that class to be instantiated like a function
    def apply(x: Int): Int = x + 1
  }

  SingletonTest(78)

  // singleton with the same name as a class in the same file is called a companion object
  object Animal {
    // companions can access each other's private fields/methods
    // singleton Animal and instances of Animal are different things
    val canLiveIndefinitely = false

  }

  val animalsCanLiveForever = Animal.canLiveIndefinitely // "static" fields/methods

  /*
  case classes = lightweight data structures with some boilerplate
  - sensible equals and has code
  - serialization
  - companion with apply
  - pattern matching
   */
  case class Person(name: String, age: Int)
  // Case classes can be constructed without keyword new
  val bob = Person("Bob", 54) // Person.apply("Bob", 45)

  // exceptions
  // All Scala code is compiled to run on JVM
  try {
    // code that can throw
    val x: String = null
    x.length
  } catch {
    case e: Exception => "some faulty error message"
  } finally {
    // execute some code no matter what
  }

  // generics
  abstract class MyList[T] {
    def head: T
    def tail: MyList[T]
  }

  // using generic with concrete type
  // going to have to look at this again
  val aList: List[Int] = List(1,2,3) // List.apply(1,2,3)
  val first = aList.head
  val rest = aList.tail
  // so the point of generics is to reuse functionality to different types
  val aStringList = List("hello", "Scala")
  val firstString = aStringList.head
  // same logic but return types are different

  // Point #1: in Scala we usually operate with IMMUTABLE values/objects
  // Any modification to an object must return ANOTHER object
  /*
  Benefits
  1) works miracles in multithreaded/distributed environments
  2) helps making sense of code ("reasoning about")
   */
  val reverseList = aList.reverse // returns a NEW list

  // Point #2: Scalar is closest to the OO ideal
  // All the code and all the values are inside an instance, values and methods are apart of a class/object
}
