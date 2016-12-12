package org.home.demo;
/**
  * Created by andrey on 05.12.16.
  */
class FirstDemo extends App{
  print ("Hello")

}

class F2 extends Application{
  @scala.deprecatedOverriding("main should not be overridden")
  override def main(args: Array[String]): Unit = {
    super.main(args)
    println("Hello first")
  }
}