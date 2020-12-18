public class Queue{

	int max = 15;
	int front = -1;
	int rear = 0;
	int len = 0;

	int [] queue_array = new int [max];

	public int len()
	{
		return len;
	}
	public int front()
	{
		if(front==-1)
		{
			return 0;
		}
		return queue_array[front];
	}

	public void enqueue(int e)
	{
		if(len==0){
			queue_array[0] = e;
			front = 0;
		}
		else{
			queue_array[rear+1] = e;
			rear++;

		}
		len = len+1;
		System.out.println("your added element are : "+e);
	}
	public int first()
	{	
		if(isEmpty())
		{
			return 0;
		}
		else{
			return queue_array[front+1];
		}
	}

	public int dequeue()
	{
		if(len==0)
		{
			System.out.println("you fool!!your queue_array is empty");
		}
		else
		{
			front = front-1;
			len = len -1;
		}
		return queue_array[front+1];
	}
	public boolean isEmpty()
	{
		if(len==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static void main(String[] args)
	{
		Queue C = new Queue();
		C.enqueue(9);
		C.enqueue(2);
		C.enqueue(5);
		C.enqueue(1);


		System.out.println("Is your array empty? : "+C.isEmpty());
		System.out.println("The size of your array is: "+ C.len());
		System.out.println("The removed element is: "+ C.dequeue());
		System.out.println("The first element is: "+ C.first());
		
	}

}