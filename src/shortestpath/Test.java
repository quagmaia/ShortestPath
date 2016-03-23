/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortestpath;

import java.util.LinkedList;

/**
 *
 * @author Maia
 */
public class Test {

    public static void main(String[] args) {

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
