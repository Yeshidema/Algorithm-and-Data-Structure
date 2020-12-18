public class LSD{
	public static void main(String[] args) {
		int W = 5;
	 	String []arr = {"Sonam","Yeshi"}; 
		int N  = arr.length;
		int Unique = 256;
		String[] aux = new String[N];

		for ( int d = W-1; d >= 0; d--){
			int []count = new int[Unique+1];
		
			for (int i = 0; i< N; i++){
			count [arr[i].charAt (d) + 1]++;
		}
		for(int r = 0; r < Unique; r++){
			count [r+1] += count [r];
		}
		for(int i = 0; i < N; i++){
			aux [count[arr[i].charAt(d)]++] =  arr[i];
		}
		for(int i = 0; i < N; i++){
			arr[i] = aux[i];
		}


		
	}
	for(int i = 0; i<N; i++){
			System.out.println(" " + arr[i]);
		}


	} 
}