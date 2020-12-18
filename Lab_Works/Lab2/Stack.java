public class Stack{
	//declaring the array length
	int array_length = 10;
	int top = -1;
	int size = 0;
	int [] stack_Array = new int[array_length];

	// ading element to the array
	public void push(int e){
		
		if(size==0){
			stack_Array[0] = e;
			top = 0;
		}
		else{
			stack_Array[top+1] = e;
			top++;

		}
		size = size+1;
	}
	// removing the top element 
	public int pop(){
		if(size==0){
			System.out.println("sorry!!The stack is empty");
		}
		else{
			top = top-1;
			size = size-1;
		}
		return stack_Array[top+1];
			

	}
	

	public int size(){
		return size;
	}
	
	public int top(){
		if (top==-1){
			return 0;
		}

	return stack_Array[top];
		
	
	}
	// return true if the array is empty and false if the array is not empty
	public boolean isEmpty(){
		if(size==0){
			return true;
		}
		else{
			return false;
		}
	}
		

	// main method calling subclass
	public static void main(String[] args)
	{
		Stack obj = new Stack();//creating object 
		
		obj.push(1);
		obj.push(7);//adding element in the array
		obj.push(2);
		


		System.out.println("the szie of your element is :" + obj.size());
		//removing the top element
		System.out.println("The pop element is: "+ obj.pop());
		//representing the new top element
		System.out.println("now the new top element is: "+ obj.top());

		System.out.println(obj.isEmpty());
	}
	
}
