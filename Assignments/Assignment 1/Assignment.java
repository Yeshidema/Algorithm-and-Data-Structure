import java.util.*;
public class Assignment{
    
    int max;
    int size;
    int count;
    int [] array;
    int onefourth;
    int threefourth;


    //main method
    public static void main(String[] args) {
        Assignment obj = new Assignment(4);

        obj.add(1);
        obj.add(1);
        obj.add(1);

        System.out.println("The Size of an array before adding is: "+obj.size());
        System.out.println("The Size of an array before adding is: "+obj.size);
        for (int i=0;i<obj.size ;i++ ) {
            System.out.println("array is: "+obj.array[i]);
        }
        
        
        //obj.pop();
        
        obj.resize();
        //obj.pop();
        System.out.println("The Size of Array is now: "+obj.size());   
    }

   
    //Constructor
    public Assignment(int l){
        max = l;
        size = 0;//2
        array = new int[max];
        onefourth = Math.round((25*l)/100);
        threefourth = Math.round((75*l)/100);
    }
    // adding element in array.
    public void add(int ele){
        if (size==0){
            array[size]=ele;
        }
        else{
            array[size+1]=ele;
        }
        size = size+1;
    }
    //removing element in array
    public void pop(){
        if(size > 0){
            array[size-1] = 0; 
            size--; 
        }
    }
    //Size of array
    public int size(){
        return max;
    }
    //Resizing array that is if the array is 1/4 it is made into half and if array is 3/4 or full array size is doubled.
    //Array remain same if the array element is 2/4.    
    public void resize(){
      
        if(size == onefourth){

            int[] temp = new int[max/2];

            for(int i=0;i<size;i++){
                temp[i]=array[i];
            }

            max = max/2;
            array = temp;
        }

        if(size == threefourth){

            int[] temp = new int[max*2];

            for(int i=0;i<size;i++){
                temp[i]=array[i];
            }

            max = max*2;
            array = temp;
        } 
       
    }

}