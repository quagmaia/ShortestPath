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
        
    }
    
}
