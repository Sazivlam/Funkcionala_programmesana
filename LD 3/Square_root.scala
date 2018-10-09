

object Square_root {
  val input_x = 4
  val initial_y = 1
  
  
  def main(args:Array[String]){
    println(sqrt(input_x))
  }
  
  
  def sqrt(x: Double) = sqrtIter(initial_y, x)

  def square(x: Double) = x*x
    
  def isGoodEnough(y: Double, x: Double) = Math.abs(square(y)-x) < 0.001
  
  def improve(y: Double, x: Double) = (y+x/y)/2
  
  def sqrtIter(y: Double, x: Double): Double =
    
    if(!isGoodEnough(y,x))
      sqrtIter(improve(y,x),x)
    else
      y
}