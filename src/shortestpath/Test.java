/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shortestpath;

/**
 *
 * @author Maia
 */
public class Test {
    public static void main(String[] args) {
        
        
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
