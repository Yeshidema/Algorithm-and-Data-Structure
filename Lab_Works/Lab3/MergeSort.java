public class MergeSort{
    int [] array;
    int [] temparray;
    int length;

        // is the array sorted
        public void sort(int [] arr){
            this.array=arr;
            this.length=arr.length;
            this.temparray=new int[length];
            mergesort(0,length-1);
        }
        public void mergesort(int lo,int hi){
            if(lo<hi){
                int mi=lo +(hi-lo)/2;
                mergesort(lo,mi);
                mergesort(mi+1,hi);
                merge(lo,mi,hi);
            }
        }
        public void merge(int low,int mid,int high){
            for (int i=low;i<=high;i++){
                temparray[i]=array[i];
            }
            int i=low;
            int j=mid+1;
            int k=low;
            while(i<=mid && j<=high){
                if(temparray[i]<=temparray[j]){
                    array[k]=temparray[i];
                    i++;
                }
                else{
                    array[k]=temparray[j];
                    j++;
                }
                k++;
            }
            while(i<=mid){
                array[k]=temparray[i];
                i++;
                k++;
            }
        }

        public static void main(String[] args) {
            System.out.println("The unsorted array is:");
            int [] arraytosort={2,5,4,3,1};
            for (int i:arraytosort){
                System.out.print(i);
                 System.out.println("");
        }
            
            MergeSort arr= new MergeSort();
            arr.sort(arraytosort);
            System.out.println("The sorted array is: ");
            for(int i:arraytosort){
                System.out.print(i);
                System.out.println("");
        }
    }
}
