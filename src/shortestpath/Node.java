
package shortestpath;

/**
 *
 * @author Maia
 */
public class Node {
    String name;
    Boolean visited;
    
    public Node(String name){
        name=this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Boolean isVisited(){
        return visited;
    }
    
    public void visit(){
        visited=true;
    }
    
    public void unvisit(){
        visited=false;
    }
    
    @Override
    public String toString(){
        return name;
    }
}
