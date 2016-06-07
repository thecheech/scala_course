package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
  var s = union(
    union(
      singletonSet(1),
      singletonSet(2)
    ),
    singletonSet(1)
  )
  println(forall(s, x => x > 0))
  println(forall(s, x => x > 1))

  println(exists(s, x => x > 1))
  println(exists(s, x => x > 2))

  var s2 = map(s, x => x * x)
  println(exists(s2, x => x == 4))

  printSet(s)
  printSet(s2)
}
