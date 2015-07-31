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
  
  "foldLeft" should behave like foldLeftFunction(List.foldLeft)
  
  "foldLeft2" should behave like foldLeftFunction(List.foldLeft2)

  "foldRight" should behave like foldRightFunction(List.foldRight)
  
  "foldRight2" should behave like foldRightFunction(List.foldRight2)

  "sum3" should "work" in {
    List.sum3(List(1, 2, 3)) should be (6)
  }
  
  "product3" should "work" in {
    List.product3(List(1, 2, 3)) should be (1*2*3)
  }
  
  "length3" should "work" in {
    List.length3(List(1,2,3)) should be (3)
  }

  "reverse" should "revert" in {
    List.reverse(List(1,2,3)) should be (List(3,2,1))
  }
  
  "append2" should "be the same as append" in {
    List.append2(List(1,2,3), List(4,5)) should be (List(1,2,3,4,5))
  }
  
  "flatten" should "concat member lists" in {
    List.flatten(List(List(1,2), List(3,4,5), List(6))) should be (List(1,2,3,4,5,6))
  }

  type LeftFolding[A,B] = (List[A], B) => ((B, A) => B) => B
  type RightFolding[A,B] = (List[A], B) => ((A, B) => B) => B

  def foldLeftFunction(f: LeftFolding[Int, List[Int]]) = 
      f(List(1, 2, 3), List[Int]())((x, y) => Cons(y, x)) should be (List(3,2,1))
  
  def foldRightFunction(f: RightFolding[Int, List[Int]]) = 
      f(List(1, 2, 3), List[Int]())((x, y) => Cons(x, y)) should be (List(1,2,3))
}