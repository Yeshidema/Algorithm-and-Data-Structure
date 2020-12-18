public class LinearSearch{
	public static int Search(int[]arr, int key){
		for(int i = 0; i < arr.length; i++){
			if (arr[i] == key){
				return i;
			}
		}

		return -1;
	}
	public static void main(String[] args) {
		int arr[] = {12, 10 , 16, 17, 18, 19, 50, 60};

		int key = 60;

		System.out.println( key + " is found at index " + Search(arr, key));
	}
}