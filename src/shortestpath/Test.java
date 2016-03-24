/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortestpath;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Maia
 */
public class Test {

    public static void main(String[] args) {
        try {
            int shortestPath = 0;
            //READ INPUT
            Input input = new Input("C:\\Users\\Maia\\Desktop\\test.txt");
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
                String source = temp.a;
                for (int i = 0; i < input.numNodes; i++) {  //check if min edge is from visited source
                    if (source.equals(visitedNodes[i])) {
                        visited = true;
                    }//if
                    if (visited) {
                        break;
                    }
                }//for i
                if (visited) {
                    big.deleteMin();
                    System.out.println("        deleted " + big.deleteMin()); //test
                } else {
                    //find min of all of temp's neighbors

                    for (int i = 0; i < edges.length; i++) {
                        if (source.equals(big.peek(i).a)) {
                            if (big.peek(i).weight < temp.weight) {
                                temp = big.peek(i);   //if a new edge is smaller make it the new minimum
                            }
                        }//if
                    }//for i
                    shortestPath += temp.weight;

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
        /*
         Scanner sc = new Scanner(System.in);
         try {
            
         Input input = new Input("C:\\Users\\Maia\\Desktop\\test.txt");
         String[] nodes = input.getNodes();
         Edge[] edges = input.getEdges();
         //test
         System.out.println("Nodes");
         for (int i=0;i<input.numNodes;i++){
         System.out.print(nodes[i] + " ");
         }
         System.out.println();
         System.out.println("Edges");
         for (int i=0;i<input.numEdges;i++){
         String out = edges[i].toString();
         System.out.println(out);
         }
            
            
            
            
         } catch (FileNotFoundException ex) {
         System.out.print("File not found.");
         System.exit(1);
         }//catch
         /*
         Edge[] edges = new Edge[3];
         String[] nodes = new String[3];

         String line = "5 12";         //current line loaded into string
         //System.out.println("t");
         String source = "test";
         int soNoCount = 0;
         int edCount = 0;

         if (!line.contains("=")) {              //  not first line
         String[] temp = line.split("\\s+");
         if (temp.length == 1) {             //source line
         nodes[soNoCount] = temp[0];
         source = temp[0];
         soNoCount++;
         } else if (temp.length == 2) {       //dest line
         String dest = temp[0];//current destination
         Edge e = new Edge(source, dest, Integer.parseInt(temp[1]));
         edges[edCount]=e;
         edCount++;
         }
         }//if !line.contains...
         for (int i = 0; i < edges.length; i++) {
         try {
         System.out.println(edges[i].b + " " + edges[i].weight);
            
         } catch (NullPointerException e){
         System.out.println("rfafcA");
         }
         }

         /*
         //testing biheap
         BiHeap bh = new BiHeap(6);
         Node a = new Node();
         a.setName("a");
         Node b = new Node();
         b.setName("b");
         Node c = new Node();
         c.setName("c");
         Node d = new Node();
         d.setName("d");
         Edge ab = new Edge(a,b,6);
         Edge bc = new Edge(b,c,3);
         Edge ca = new Edge(c,a,5);
         Edge ad = new Edge(a,d,4);
         Edge bd = new Edge(b,d,1);
         Edge cd = new Edge(c,d,2);
        
         bh.insert(ab);
         bh.insert(bc);
         bh.insert(ca);
         bh.insert(ad);
         bh.insert(bd);
         bh.insert(cd);
        
         System.out.println(bh.getWeight(0));
         System.out.println(bh.getMinSD(0));
        
         System.out.println(bh.PrintWeights());
        
         bh.deleteMin();
        
         System.out.println(bh.getWeight(0));
         System.out.println(bh.getMinSD(0));
        
         System.out.println(bh.PrintWeights());
        
        
         /*
         //testing edges and nodes
         Node a = new Node();
         a.setName("a");
         Node b = new Node();
         Node c = new Node();
         Edge ab = new Edge(a,b,1);
         Edge bc = new Edge(b,c,3);
         Edge ca= new Edge(c,a,5);
         System.out.println(ab.weight + "\n" + bc.weight + "\n" + ca.weight);
         System.out.println(ab.getSource().getName());
         */
    }
}
