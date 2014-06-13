package name.felixbecker.pathfinder

object Main extends App {

	val field = new Field(Array.tabulate(64,48){
		(x,y) => Tile(x,y); 
	}.flatten.toList)
		
}