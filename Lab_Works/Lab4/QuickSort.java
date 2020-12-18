import java.util.*;
public class QuickSort{
    

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
        assert isSorted(a);
    }

    // quicksort the subarray from a[lo] to a[hi]
    private static void sort(int[] a, int lo, int hi) { 
        if (lo < hi){
            int p = partition(a, lo, hi);
             sort(a, lo, p - 1);//call quick sort recursively to sort sub arrays
            sort(a, p + 1, hi);//call quick sort recursively to sort sub arrays
        }
    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    private static int partition(int[] a, int lo, int hi) {
          int pivot = a[hi];
            int i = lo-1;// index of smaller elements
             for (int j = lo; j< hi;j++){
                if (a[j] <= pivot){
                 i++; 
                // swap a[i] and a[j] 
                int temp = a[i]; 
                a[i] = a[j]; 
                a[j] = temp;
             }
                
        }
   // swap a[i+1] and a[hi] (or pivot) 
        int temp = a[i+1]; 
       a[i+1] = a[hi]; 
        a[hi] = temp; 
   
        return i+1; 
    }



   /***************************************************************************
    *  Helper sorting functions.
    ***************************************************************************/
    
    // is v(first element) < w(second element) ?
   //This method checks if first element is less then the other element
     // return  1 if v >  w
   // return  0 if v == w
     // return -1 if v <  w
    // private static boolean less(Comparable v, Comparable w){  
   //  if (v == w) return false;   // optimization when reference equals
   //      return v.compareTo(w) < 0;
    //}
   private static boolean less(int v, int w){  
    
        if(v < w){
            return true;
        }
        else{
            return false;
        }    
    } 
    
    // is the array sorted
    private static boolean isSorted(int[] a, int lo, int hi) {
         for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) 
                {
                    return false;
                }
        return true;
    }

        
    // exchange a[i] and a[j]
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap; 
    }


   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    private static boolean isSorted(int[] a) {
       for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])){
              return false;  
            } 
        return true; 
  
    }



    // print array to standard output
    private static void show(int[] a) {
            System.out.println("Array after sorting are: ");  
            for (int i = 0; i < a.length; i++) {
                System.out.println (a[i]);
        }    }

    /**
     * Reads in a sequence of values ; quicksorts them; 
     * and prints them to standard output in ascending order. 
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int[] a = {2,4,3,1};
         QuickSort ob = new QuickSort(); 
            ob.sort(a);
            show(a);
            assert isSorted(a);

    }

}