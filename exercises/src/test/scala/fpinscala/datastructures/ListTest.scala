package fpinscala.datastructures

import org.scalatest.Matchers
import org.scalatest.FlatSpec

import List._
class ListTest extends FlatSpec with Matchers {
  "List.tail" should "return tail of a List" in {
   tail(List(1,2,3,4,5)) should be (List(2,3,4,5))
  }
  
  "setHead" should "return a new list with replaced head" in {
    setHead(List(1,2,3,4), 2) should be (List(2,2,3,4))
  }
  
  "drop" should "return list without first n element" in {
    drop(List(1,2,3,4), 2) should be (List(3,4))
  }
  
  "dropWhile" should "drop elements while predicate is true" in {
    dropWhile(List(1,2,3,4), (x: Int) => x < 3) should be (List(3,4))
  }
  
  "init" should "drop last element" in {
    init(List(1,2)) should be (List(1))
  }
  
  it should "return Nil for one size list" in {
    init(List(1)) should be (Nil)
  }
  
  it should "return Nil for Nil" in {
    init(Nil) should be (Nil)
  }
  
  "length" should "return 0 for zero length list" in {
    List.length(List()) should be (0)
  }
  
  it should "return 1 for 1 length list" in {
    List.length(List(1)) should be (1)
  }

  it should "return 4 for 4 length list" in {
    List.length(List(1,2,3,4)) should be (4)
  }

}