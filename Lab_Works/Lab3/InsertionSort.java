import java.util.*;

public class InsertionSort {
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
        System.out.println("Elements after sorting: ");
        Sorting(arr);
        printarray(arr);
    }
    public static void Sorting(int arr[]){
        int n = arr.length,i,j,z;

        for(i=1;i<n;i++){
            for(j=i-1;j>=0 && arr[j+1]<arr[j]; j--){
                z=arr[j+1];
                arr[j+1]=arr[j];
                arr[j]=z;
 
            }
        }
    }
    public static void printarray(int arr[])
        {
        for(int i=0; i < arr.length; i++)
        {
        
        System.out.print(arr[i]+" ");
        }
 
}



    
}
