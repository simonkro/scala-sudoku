object Sudoku extends App {
  type Board = Vector[Int]

  def neighbour(i: Int, j: Int): Boolean = {
    def box(n: Int) = (n / 27 * 3) + (n % 9) / 3 
    (i != j) && (i % 9 == j % 9 || i / 9 == j / 9 || box(i) == box(j))
  }

  val neighbours = (0 to 80).map(i =>
    (0 to 80).filter(j => neighbour(i, j))
  )

  def solve(board: Board, index: Int = 0): Option[Board] = {
    def taken(number: Int): Boolean = 
      neighbours(index).exists(n => board(n) == number)
    
    def guess(number: Int): Option[Board] = 
      if (index > 80) Some(board)
      else if (board(index) > 0 && board(index) != number || taken(number)) None
      else solve(board.updated(index, number), index + 1)
    
    (1 to 9).view.flatMap(n => guess(n)).headOption
  }

  val puzzle = "............942.8.16.....29........89.6.....14..25......4.......2...8.9..5....7.."
  val board = puzzle.map(c => c.asDigit).toVector
  val solved = solve(board).get

  solved.grouped(9).foreach(row => println(row.mkString(" ")))
}
