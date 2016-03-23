package shortestpath;

import java.util.*;
import java.io.*;
import java.util.regex.*;

/**
 *
 * @author Maia
 */
public class Input {

    private String file;
    public String[] nodes;
    public Edge[] edges;
    public int numNodes;
    public int numEdges;

    public Input(String file) throws FileNotFoundException {
        this.file = file;
        readSize();
        nodes = new String[numNodes];
        edges = new Edge[numEdges];
        createNodes();
        readData();
    }

    public String getFile() {
        return file;
    }

    //method to read from file and get edges, nodes, numEdges, and numNodes
    public void readSize() throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file));
        //n=number of vertices m=number of edges
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();         //current line loaded into string
            if (line.contains("=")) {                   //IF FIRST LINE
                //System.out.println("t");
                line = line.replaceAll("[^0-9]+", " ");
                String[] temp = line.split(" ");
                numNodes = Integer.parseInt(temp[1]);
                numEdges = 2*Integer.parseInt(temp[2]);
            }
        }//while
    }//readSize()

    public void readData() throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file));
        String source = null;    //current source
        int edCount = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (!line.contains("=")) {              //  not first line
                String[] temp = line.split("\\s+");
                if (temp.length == 1 && !temp[0].equals("")) {             //source line
                    source = temp[0];
                } else if (temp.length == 2) {       //dest line
                    String dest = temp[0];//current destination
                    int weight = Integer.parseInt(temp[1]);
                    Edge e = new Edge(source, dest, weight);
                    edges[edCount] = e;
                    edCount++;
                    Edge ee = new Edge(dest, source, weight);
                    edges[edCount] = ee;
                    edCount++;
                }
            }//if !line.contains...
        }//while
    }//readData()
    
    public void createNodes(){
        for (int i = 0; i < numNodes; i++){
            nodes[i]=String.valueOf(i);
        }
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public String[] getNodes() {
        return nodes;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public int getNumNodes() {
        return numNodes;
    }

}
