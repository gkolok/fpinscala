package fpinscala.gettingstarted

import org.scalatest.Matchers
import org.scalatest.FlatSpec

class PolymorphicFunctionsTest extends FlatSpec with Matchers {
  import PolymorphicFunctions._
  
  "isSorted" should "return true for 1 size array" in {
    val a = Array(1)
    isSorted(a, (x: Int, y: Int) => throw new Exception) should be (true)
  }
  
  it should "return true for array like (2, 1)" in {
    val a = Array(2, 1)
    isSorted(a, (x: Int, y: Int) => x > y) should be (true)
  }

  it should "return true for array like (2, 1, 0)" in {
    val a = Array(2, 1, 0)
    isSorted(a, (x: Int, y: Int) => x > y) should be (true)
  }

  it should "return false for array like (2, 0, 1)" in {
    val a = Array(2, 0, 1)
    isSorted(a, (x: Int, y: Int) => x > y) should be (false)
  }

  it should "return false for array like (2, 0, 0)" in {
    val a = Array(2, 0, 0)
    isSorted(a, (x: Int, y: Int) => x > y) should be (false)
  }
  
  "curry" should "return next int fun for curry((a: Int, b: Int) => a + b)(1) " in {
    val nextIntFun = curry((a: Int, b: Int) => a + b)(1)
    
    nextIntFun(2) should be (3)
  }
  
  "uncurry" should "return a function with two parameters" in {
    def f(a: Int) = (b: Int) => a + b 
    
    uncurry(f)(1,1) should be (2)
  }

}