import org.msgpack._

class Sudoku(source: String) {
  val board = source.toList.filter("123456789_." contains _).map(_.asDigit).toArray

  def solve(index: Int = 0): Boolean = {
    def guess(number: Int): Boolean = {
      val f = board(index)
      if (f > 0 && f != number || taken(index, number)) return false
      board(index) = number
      if (index == 80 || solve(index + 1)) return true
      board(index) = f
      false
    }
    1 to 9 exists guess
  }

  private val neighbours = (0 to 80).map(i => (0 to 80).filter(j => neighbour(i, j)))

  private def neighbour(i: Int, j: Int): Boolean = {
    def box(n: Int) = n / 27 * 3 + n % 9 / 3
    (i != j) && (i / 9 == j / 9 || i % 9 == j % 9 || box(i) == box(j))
  }

  private def taken(index: Int, number: Int): Boolean = {
    neighbours(index).exists(board(_) == number)
  }
}

object Sudoku {
  def main(args: Array[String]) {
    val game = new Sudoku(readLine)
    game.solve()
    game.board.grouped(9).foreach(row => println(row.mkString(" ")))
  }
}
