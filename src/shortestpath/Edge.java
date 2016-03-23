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
    String a, b;

    public Edge(String source, String destination, int weight) {
        a = source;
        b = destination;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getSource() {
        return a;
    }

    public void setSource(String a) {
        this.a = a;
    }

    public String getDestination() {
        return b;
    }

    public void setDestination(String b) {
        this.b = b;
    }
    
    @Override
    public String toString(){
        return "Source: " + a + " Dest: " + b + " Weight: " + weight;
    }

}
