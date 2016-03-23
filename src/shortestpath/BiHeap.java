package shortestpath;

/**
 *
 * @author Maia
 */

//this is a MIN HEAP
public class BiHeap {
    Edge array[];
    int nextSeat;
    
    //NOTE: node @ index k has children at indexes 2k+1 and 2k+2
    //parent node p =(k-1)/2
    
   public BiHeap(int x){
       array = new Edge[x];
       nextSeat = 0;
   }//constructor
   
   public Boolean isEmpty(){
        return nextSeat==0;
   }
   
   public Boolean isFull(){
        return nextSeat==array.length;
   }
   
   public void insert(Edge x){
       //go to first empty spot of array and insert
       array[nextSeat]=x;
       //sift upwards
       up(nextSeat);
       //increment next open seat by 1
       nextSeat++;
   }//insert
   
   public int getWeight(int x){
       return array[x].weight;
   }
   
   public String getMinSD(int x){
       return array[x].getSource() + " " + array[x].getDestination();
   }
   
   public String PrintWeights(){
       String a = "";
       for (int i = 0; i < array.length; i++){
           a += array[i].weight + ", ";
       }
       return a;
   }
   
   private void up(int k){
       while (k > 0){
           int p = (k-1)/2;
           if (array[k].weight < array[p].weight){
               //swap k and p
               Edge temp = array[k];
               array[k] = array[p];
               array[p] = temp;
               k=p;
           } else {
               break;
           }//else
       }//while
   }//up
   
   public int deleteMin(){
       //output deleted node
       int output = array[0].weight;
       //set last node to index 0
       array[0] = array[nextSeat-1];
       //sift down
       down();
       //decrement nextSeat, return deleted node
       nextSeat--;
       return output;
   }//delete
   
   private void down(){
       int k = 0;
       int left = 2*k+1;
       while (left < nextSeat){
           int min=left;
           int right=left+1;
           if (right < nextSeat){   //if there's a right child
               if (array[right].weight < array[left].weight){
                   min=right;
               }//if
           }//if
           if (array[k].weight > array[min].weight){
               Edge temp = array[k];
               array[k] = array[min];
               array[min] = temp;
               k=min;
               left=2*k+1;
           }else{
               break;
           }//if else
       }//while
   }//down
}//class
