object Sudoku extends App {

  def neighbour(i: Int, j: Int): Boolean = {
    i % 9 == j % 9 || i / 9 == j / 9
  }

  println(neighbour(0, 1))
  println(neighbour(0, 9))
  println(neighbour(0, 8))
}
