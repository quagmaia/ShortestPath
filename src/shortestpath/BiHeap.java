package shortestpath;

/**
 *
 * @author Maia
 */

//this is a MIN HEAP
public class BiHeap {
    int array[];
    int nextSeat;
    
    //NOTE: node @ index k has children at indexes 2k+1 and 2k+2
    //parent node p =(k-1)/2
    
   public BiHeap(int x){
       array = new int[x];
       nextSeat = 0;
   }//constructor
   
   public Boolean isEmpty(){
        return nextSeat==0;
   }
   
   public Boolean isFull(){
        return nextSeat==array.length;
   }
   
   public void insert(int x){
       //go to first empty spot of array and insert
       array[nextSeat]=x;
       //sift upwards
       up(nextSeat);
       //increment next open seat by 1
       nextSeat++;
   }//insert
   
   private void up(int k){
       while (k > 0){
           int p = (k-1)/2;
           if (array[k] < array[p]){
               //swap k and p
               int temp = array[k];
               array[k] = array[p];
               array[p] = temp;
               k=p;
           } else {
               break;
           }//else
       }//while
   }//up
   
   public int delete(){
       //output deleted node
       int output = array[0];
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
           int max=left;
           int right=left+1;
           if (right < nextSeat){   //if there's a right child
               if (array[right] < array[left]){
                   max++;
               }//if
           }//if
           if (array[k] < array[max]){
               int temp = array[k];
               array[k] = array[max];
               array[max] = temp;
               k=max;
               left=2*k+1;
           }else{
               break;
           }//if else
       }//while
   }//down
}//class
