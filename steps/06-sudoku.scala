object Sudoku extends App {

  def neighbour(i: Int, j: Int): Boolean = {
    def box(n: Int) = (n / 27 * 3) + (n % 9) / 3 
    (i != j) && (i % 9 == j % 9 || i / 9 == j / 9 || box(i) == box(j))
  }

  println(neighbour(0, 1))
  println(neighbour(0, 9))
  println(neighbour(0, 8))
  println(neighbour(0, 20))
  println(neighbour(80, 60))
  println(neighbour(80, 80))
}
