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
public class Edge {
    int weight;
    Node a, b;
    
    public Edge(Node source, Node destination, int weight){
        a=source;
        b=destination;
        weight=this.weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node getSource() {
        return a;
    }

    public void setSource(Node a) {
        this.a = a;
    }

    public Node getDestination() {
        return b;
    }

    public void setDestination(Node b) {
        this.b = b;
    }
    
    @Override
    public String toString(){
        return a + ", " + b;
    }
    
    
}
