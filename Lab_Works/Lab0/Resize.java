public class Arrayy {
	
	public static void main(String[] args)
	{
		int[] Num = {1,2,3};
		int[] value = resize(4, Num);

		for (int i=0;i<value.length;i++ ) {
			System.out.println(value[i]);
		}
		
	}
}
public static int[] Resize(int n, int[] Num) {
	int [] temp = new int [n];

	for (int i=0;i<Num.length;i++ ) {
		
		temp[i] = Num[i];
	}
	temp[n-1]=4;

	return temp;
}