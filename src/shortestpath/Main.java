package shortestpath;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maia
 */

/*
 Steps::::
 1. read input
 2. concert to two arrays: nodes and edges
 3. sort edges into binary heap
 4. create a list of visited nodes
 5. Begin Dijkstras Algorithm!!!! 
 from http://www.gitta.info/Accessibiliti/en/html/Dijkstra_learningObject1.html:
    
 1: function Dijkstra(Graph, source):
 2: for each vertex v in Graph:	// Initialization
 3: dist[v] := infinity	// initial distance from source to vertex v is set to infinite
 4: previous[v] := undefined	// Previous node in optimal path from source
 5: dist[source] := 0	// Distance from source to source
 6: Q := the set of all nodes in Graph	// all nodes in the graph are unoptimized - thus are in Q
 7: while Q is not empty:	// main loop
 8: u := node in Q with smallest dist[ ]
 9: remove u from Q
 10: for each neighbor v of u:	// where v has not yet been removed from Q.
 11: alt := dist[u] + dist_between(u, v)
 12: if alt < dist[v]	// Relax (u,v)
 13: dist[v] := alt
 14: previous[v] := u
 15: return previous[ ]

 6. print everything
 */
public class Main {

    public static void main(String[] args) {
        //A: read input
        Scanner sc = new Scanner(System.in);
        try {
            int shortestPath = 0;
            //READ INPUT
            Input input = new Input("C:\\Users\\Maia\\Desktop\\25000.txt");
            String[] nodes = input.getNodes();
            Edge[] edges = input.getEdges();

            //CONVERT EDGES TO BIG BIHEAP
            BiHeap heap = new BiHeap(edges.length);
            for (int i = 0; i < edges.length; i++) {
                heap.insert(edges[i]);
            }
            //LIST OF VISITED NODES
            LinkedList visitedNodes = new LinkedList();
            
            //TEST
            int remainingEdges=edges.length;

            //WHILE THERE ARE REMIANING NODES
            while (!heap.isEmpty()) {
                //loop prep work
                Edge temp = heap.deleteMin();
                Boolean visited = false;
                String source = temp.a;
                String dest = temp.b;
                //done prep work
                
                //TEST
                //System.out.println("Remaining edges: " + remainingEdges--);
                //System.out.println("Checking source: " + temp.a + " dest: " + temp.b + " weight: " + temp.weight);
                
                for (Object visitedNode : visitedNodes) {
                    if (source.equals(visitedNode)) {
                        visited=true;
                        //TEST
                        //System.out.println("Already visited.");
                        break;
                    }//if
                } //for
                
                //if it''s a new source, then look through all of source's edges and find min
                if (!visited){
                    for (int i = 0; i < remainingEdges; i++){
                        //System.out.println("Double checking: " + temp.a + " dest: " + temp.b + " weight: " + temp.weight);
                        if (source.equals(heap.peek(i).a) && heap.peek(i).weight<temp.weight){
                            //if they have the same source and alt's weight is smaller
                            //make temp equal to alt
                            //TEST
                            //System.out.println("Better source: " + temp.a + " dest: " + temp.b + " weight: " + temp.weight);
                            temp=heap.peek(i);
                        }//if
                    }//for
                    //add temp's weight to shortestPath
                    shortestPath+=temp.weight;
                    //System.out.println("Updated path: " + shortestPath);
                }//if
                
                //add to visited node
                visitedNodes.add(source);
                
            }//while
            
            System.out.println("Final shortest path: " + shortestPath);

        } catch (FileNotFoundException ex) {
            System.out.print("File not found.");
            System.exit(1);
        }//catch

    }//main

}//class
