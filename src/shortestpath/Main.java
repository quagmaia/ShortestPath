package shortestpath;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maia
 */
public class Main {

    public static void main(String[] args) {
        //A: read input
        Scanner sc = new Scanner(System.in);
        try {
            int shortestPath = 0;
            //READ INPUT
            Input input = new Input("C:\\Users\\Maia\\Desktop\\1000.txt");
            String[] nodes = input.getNodes();
            Edge[] edges = input.getEdges();

            //CONVERT EDGES TO BIG BIHEAP
            BiHeap big = new BiHeap(edges.length);
            for (int i = 0; i < edges.length; i++) {
                big.insert(edges[i]);
            }
            //LIST OF VISITED NODES
            String[] visitedNodes = new String[nodes.length];

            while (!big.isEmpty()) {
                Edge temp = big.peek(0);                //check min value
                Boolean visited = false;
                for (int i = 0; i < input.numNodes; i++) {  //check if min edge is from visited source
                    if (temp.a.equals(visitedNodes[i]) || temp.b.equals(visitedNodes[i])) {
                        visited = true;
                    }//if
                }//for i
                if (visited) {
                    big.deleteMin();
                    System.out.println("        deleted " + big.deleteMin()); //test
                } else {
                    //find min of all of temp's neighbors

                    for (int i = 0; i < edges.length; i++) {
                        if (temp.a.equals(big.peek(i).a)) {
                            if (big.peek(i).weight < temp.weight) {
                                temp = big.peek(i);   //if a new edge is smaller make it the new minimum
                            }
                        }//if
                    }//for i
                    shortestPath+=temp.weight;

                    visitedNodes[Integer.parseInt(temp.a)] = temp.getSource();     //add to visited nodes

                    System.out.println("visited " + big.peek(0)); //test
                    System.out.println("weight " + shortestPath);
                }
            }//while

            System.out.println("Path: " + shortestPath);

        } catch (FileNotFoundException ex) {
            System.out.print("File not found.");
            System.exit(1);
        }//catch

    }//main

}//class
