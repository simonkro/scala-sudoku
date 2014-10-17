object Sudoku extends App {

  def box(n: Int) = {
    (n / 27 * 3) + (n % 9) / 3 
  }

  def neighbour(i: Int, j: Int) = {
    i % 9 == j % 9 || i / 9 == j / 9 || box(i) == box(j)
  }

  println(neighbour(0, 1))
  println(neighbour(0, 9))
  println(neighbour(0, 8))
  println(box(0))
  println(box(20))
  println(box(80))
  println(box(60))
}
