object Sudoku extends App {

  def neighbour(i: Int, j: Int) = {
    def box(n: Int) = (n / 27 * 3) + (n % 9) / 3 
    (i != j) && (i % 9 == j % 9 || i / 9 == j / 9 || box(i) == box(j))
  }

  def neighbours(i: Int) = {
    (0 to 80).filter(j => neighbour(i, j))
  }

  def taken(board: Vector[Int], index: Int, number: Int) = {
    neighbours(index).exists(n => board(n) == number)
  }

  def guess(board: Vector[Int], index: Int, number: Int): Option[Vector[Int]] = {
    if (board(index) > 0 && board(index) != number || taken(board, index, number)) None
    else Some(board.updated(index, number))
  }

  val puzzle = "............942.8.16.....29........89.6.....14..25......4.......2...8.9..5....7.."
  val board = puzzle.map(c => c.asDigit).toVector

  board.grouped(9).foreach(row => println(row.mkString(" ")))

  println(guess(board, 2, 4))
  println(guess(board, 2, 9))
}
