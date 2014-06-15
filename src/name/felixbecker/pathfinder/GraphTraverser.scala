package name.felixbecker.pathfinder

import scala.annotation.tailrec

object GraphTraverser extends App {

  val node1 = Node("Node 1")
  val node2 = Node("Node 2")
  val node3 = Node("Node 3")
  val node4 = Node("Node 4")
  val node5 = Node("Node 5")
  val node6 = Node("Node 6")


  val node1to2 = Edge(node1, node2, 7)
  val node1to3 = Edge(node1, node3, 9)
  val node1to6 = Edge(node1, node6, 14)
  
  val node2to3 = Edge(node2, node3, 10)
  val node2to4 = Edge(node2, node4, 15)
  
  val node3to4 = Edge(node3, node4, 11)
  val node3to6 = Edge(node3, node6, 2)
  
  val node4to5 = Edge(node4, node5, 6)
  
  val node5to6 = Edge(node5, node6, 9)
  

  val allEdges = List(node1to2, node1to3, node1to6, node2to3, node2to4, node3to4, node3to6, node4to5, node5to6)
  
  
  def findWay(currentNode: Node, targetNode: Node, allEdges: List[Edge], visitedNodes: List[Node] = Nil): List[List[Node]] = {
    
    if(currentNode == targetNode) return List(visitedNodes :+ targetNode)
    
    val nodeEdges = allEdges.filter(edge => 
      (currentNode == edge.node1 || currentNode == edge.node2) && 
      (!visitedNodes.contains(edge.node1) && !visitedNodes.contains(edge.node2))
    )
    
    if(nodeEdges == Nil) return Nil
    
    val newVisitedNodes = visitedNodes :+ currentNode
    
    
    
    val newResults = nodeEdges.map(edge => {
      if(edge.node1 == currentNode) findWay(edge.node2, targetNode, allEdges, newVisitedNodes) else findWay(edge.node1, targetNode, allEdges, newVisitedNodes)
    }).filter(_ != Nil)
    

    newResults match {
      case Nil => Nil
      case head :: tail => head
    }
    
    
  }
  
  println(findWay(node1, node4, allEdges))
  
  
}



case class Node(name: String)
case class Edge(node1: Node, node2: Node, cost: Int)