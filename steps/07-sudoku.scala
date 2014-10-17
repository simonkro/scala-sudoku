object Sudoku extends App {

  def neighbour(i: Int, j: Int): Boolean = {
    def box(n: Int) = (n / 27 * 3) + (n % 9) / 3 
    (i != j) && (i % 9 == j % 9 || i / 9 == j / 9 || box(i) == box(j))
  }

  def neighbours(i: Int): IndexedSeq[Int] = {
    (0 to 80).filter(j => neighbour(i, j))
  }

  println(neighbours(0))
  println(neighbours(60))
}
