package name.felixbecker.pathfinder

object Tile {
  val height = 10
  val width = 10
}

case class Tile(x: Int, y: Int){
  def getX() = x * Tile.width
  def getY() = y * Tile.height
}