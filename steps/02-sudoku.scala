object Sudoku extends App {

  def neighbour(i: Int, j: Int) = {
    i % 9 == j % 9
  }

  println(neighbour(0, 1))
}
