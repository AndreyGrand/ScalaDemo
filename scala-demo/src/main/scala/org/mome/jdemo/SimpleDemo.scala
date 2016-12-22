package org.mome.jdemo

/**
  * Created by andrey on 13.12.16.
  */
object SimpleDemo {
  def main (args : Array[String]){
    print ("hello world!")
    //val shps : Array[Shape] = new Array(getSomeShape(), getSomeShape(), getSomeShape(), getSomeShape(), getSomeShape(), getSomeShape());
//    for(i <-1 to 5) {
//      println(description( getSomeShape() ) );
//    }
  }

  def printShp(a: Int, shps : Array[Shape]): Unit = {
    if(a>5) 0 else {println(description(shps(a))); printShp(a+1, shps)}
  }
  sealed trait Shape  //sealed trait - интерфейс, все реализации которого должны быть объявлены в этом файле
  case class Dot(x: Int, y: Int) extends Shape
  case class Circle(x: Int, y: Int, radius: Int) extends Shape
  case class Square(x1: Int, y1: Int, x2: Int, y2: Int) extends Shape
  case class Ellipse(x1: Int, y1: Int, rdius1: Int, radius2: Int) extends Shape

  def getSomeShape() : Shape = {
    val rnd = (Math.random()*4).toInt
    val shp = rnd match{
      case 0 => Dot((Math.random() * 100).toInt, (Math.random() * 100).toInt)
      case 1 => Circle((Math.random() * 100).toInt, (Math.random() * 100).toInt, (Math.random() * 100).toInt)
      case 2 => Square((Math.random() * 100).toInt, (Math.random() * 100).toInt, (Math.random() * 100).toInt, (Math.random() * 100).toInt)
      case 3 => Ellipse((Math.random() * 100).toInt, (Math.random() * 100).toInt, (Math.random() * 100).toInt, (Math.random() * 100).toInt)
    }
    shp
  }

  val shape: Shape = getSomeShape() //объявляем локальную переменную типа Shape

  def description(x : Shape): String = {
    x match {
      //x и x в выражении ниже - это поля объекта Dot
      case Dot(x, y) => "dot(" + x + ", " + y + ")"
      //Circle, у которого радиус равен нулю. А также форматирование строк в стиле Scala
      case Circle(x, y, 0) => s"dot($x, $y)"
      //если радиус меньше 10
      case Circle(x, y, r) if r < 10 => s"smallCircle($x, $y, $r)"
      case Circle(x, y, radius) => s"circle($x, $y, $radius)"
      //а прямоугольник мы выбираем явно по типу
      case sq : Square => "random square: " + sq.toString
      case el : Ellipse => "random ellipse: " + el.toString
      //case Square(x, y, w, h) => "random square: " + _
    } //если вдруг этот матч не охватывает все возможные значения, компилятор выдаст предупреждение
  }

}
