package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    println(balance("lalala".toList))
    println(balance("lalala)".toList))
    println(balance("lalal(()a".toList))
    println(balance("(((lala))la".toList))
    println(balance("lal)(ala".toList))
    println(balance("l(alal)a".toList))

    println(countChange(4, List(1, 2)))

  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = if (c==0) 1 else (0 until r).map(pascal(c-1, _)).sum

  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def func(chars: List[Char], counter: Int): Boolean = {
        if (chars.isEmpty) return counter == 0
        if (counter < 0) return false
        if (chars.head == '(') func(chars.tail, counter+1)
        else if (chars.head == ')') func(chars.tail, counter-1) else func(chars.tail, counter)
      }
    func(chars, 0)
  }





  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]) = {
      def count(capacity: Int, change: List[Int]): Int = {
        if (capacity == 0) 1
        else if (capacity < 0) 0
        else if (change.isEmpty) 0
        else count(capacity - change.head, change) + count(capacity, change.tail)
          }
      count(money, coins.sortWith(_.compareTo(_) < 0))
    }

}

