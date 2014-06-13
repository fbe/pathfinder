package name.felixbecker.pathfinder

import javax.swing.JFrame
import javax.swing.JPanel
import java.awt.Graphics
import java.awt.Color

class Field(tiles: List[Tile]) extends JFrame {
  
  
	val tilesPanel = new FieldDisplayPanel(tiles) with VisitedPainter with TilePainter


	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(640, 480);
	add(tilesPanel);
	tilesPanel.setVisible(true);
	setVisible(true);

  
		
		
}


class FieldDisplayPanel(val tiles: List[Tile]) extends JPanel() {
  
  override def paint(g: Graphics){}
  
}
  
trait TilePainter extends FieldDisplayPanel {
  
	override def paint(g: Graphics){
		tiles.foreach(t => {
		  	g.setColor(Color.GREEN);
			g.fillRect(t.getX(), t.getY(), Tile.width, Tile.height);
			g.setColor(Color.BLACK);
			g.fillRect(t.getX(), t.getY(), Tile.width-1, Tile.height-1);
		})
		
		super.paint(g)
	}
	
}

trait VisitedPainter extends FieldDisplayPanel {
  
  override def paint(g: Graphics){
  
    g.setColor(Color.WHITE)
    g.fillRect(50,50,50,50)
    
    super.paint(g)

  }
  
}