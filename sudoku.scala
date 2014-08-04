object Sudoku extends App {
  type Board = Vector[Int]

  def solve(board: Board = board, index: Int = 0): Option[Board] = {
    def guess(number: Int) = {
      def taken = neighbours(index).exists(board(_) == number)

      if (index > 80) Some(board)
      else if (board(index) > 0 && board(index) != number || taken) None
      else solve(board.updated(index, number), index + 1)
    }

    (1 to 9).view.flatMap(guess).headOption
  }

  def neighbour(i: Int, j: Int) = {
    def box(n: Int) = n / 27 * 3 + n % 9 / 3
    (i != j) && (i / 9 == j / 9 || i % 9 == j % 9 || box(i) == box(j))
  }

  val neighbours = (0 to 80).map(i => (0 to 80).filter(j => neighbour(i, j)))

  def board = readLine.filter("123456789_." contains _).map(_.asDigit).toVector
  solve(board).foreach(_.grouped(9).foreach(row => println(row.mkString(" "))))
}
