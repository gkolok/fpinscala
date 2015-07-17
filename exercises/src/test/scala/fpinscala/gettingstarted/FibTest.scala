package fpinscala.gettingstarted

import org.scalatest.Matchers
import org.scalatest.FlatSpec

class FibTest extends FlatSpec with Matchers {
  import MyModule._
  
  "fib(n)" should "be fib(n-1) + fib(n-2)" in { 
    (2 to 10) foreach { n => fib(n) should be (fib(n -1) + fib(n -2) )}
  }
  
  it should "be 1 for 1" in {
    fib(1) should be (1)
  }
  it should "be 0 for 0" in {
    fib(0) should be (0)
  }
}