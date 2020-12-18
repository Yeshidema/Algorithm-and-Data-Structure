public class KeyIndexCounting{
	public static void main(String[] args) {
		int []arr = {0,1,3,4,2,5,3,6,7,8,5,9};
		int n = arr.length;
		int unique = 256;

		int [] aux = new int[unique];
		int []count = new int[unique + 1];

		for(int i = 0; i<n; i++){
			count[arr[i]+1]++;
		}

		for( int r = 0; r < unique; r++ ){
			count [r+1] += count[r];
		}

		for (int i = 0; i < n; i++){
			aux[count[arr[i]]++] = arr[i];
		} 

		for(int i =0 ; i < n; i++){
			arr[i] = aux[i];
		}

		for(int i =0; i<n; i++){
			System.out.print(" " + arr[i]);
		}
    }
}