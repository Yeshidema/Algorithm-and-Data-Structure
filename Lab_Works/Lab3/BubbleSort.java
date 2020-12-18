import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the number of elements you want to store in the array: ");
        int n  = obj.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");

        for(int i=0; i<n;i++){
            arr[i] = obj.nextInt();
        }
        System.out.println("Array elements are: ");

        for(int i=0; i<n; i++){
            System.out.println(arr[i]);
        }
        System.out.println("Sorted array are: ");
        Sorting(arr);
        printarray(arr);
    }
    public static void Sorting(int arr[]){
       int n = arr.length, i, x, y ;
       
       for(i=0; i<(n-1);i++){
           for(x=0;x<n-i-1;x++){
                if(arr[x]>arr[x+1]){
                    y = arr[x];
					arr[x] = arr[x+1];
					arr[x+1] = y;
                }
           }
       }
       
    }
    public static void printarray(int arr[])
       {
           for(int i=0; i<arr.length;i++)
           {
               System.out.println(arr[i] + " ");
           }
       }
}
