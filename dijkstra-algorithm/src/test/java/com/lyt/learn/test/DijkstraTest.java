package com.lyt.learn.test;

import com.lyt.common.Graph;
import com.lyt.common.GraphNode;
import com.lyt.learn.Dijkstra;
import junit.framework.TestCase;
import org.junit.Assert;

public class DijkstraTest extends TestCase {

    public void testGetSmallestWeight() {
        Graph graph = new Graph(false);
        GraphNode nodeA = new GraphNode("A");
        GraphNode nodeB = new GraphNode("B");
        GraphNode nodeC = new GraphNode("C");
        GraphNode nodeD = new GraphNode("D");
        GraphNode nodeE = new GraphNode("E");
        GraphNode nodeF = new GraphNode("F");
        GraphNode nodeG = new GraphNode("G");
        GraphNode nodeH = new GraphNode("H");
        GraphNode nodeI = new GraphNode("I");
        GraphNode nodeJ = new GraphNode("J");

        graph.addEdge(nodeA, nodeB, 4);
        graph.addEdge(nodeA, nodeD, 1);
        graph.addEdge(nodeA, nodeG, 2);
        graph.addEdge(nodeB, nodeC, 3);
        graph.addEdge(nodeC, nodeJ, 2);
        graph.addEdge(nodeD, nodeE, 2);
        graph.addEdge(nodeE, nodeF, 2);
        graph.addEdge(nodeE, nodeI, 1);
        graph.addEdge(nodeF, nodeJ, 3);
        graph.addEdge(nodeG, nodeH, 2);
        graph.addEdge(nodeG, nodeI, 3);
        graph.addEdge(nodeH, nodeJ, 4);
        graph.addEdge(nodeI, nodeJ, 3);

        Dijkstra dijkstra = new Dijkstra();

        Assert.assertEquals(dijkstra.getSmallestWeight(graph, nodeA, nodeJ), 7);
    }
}