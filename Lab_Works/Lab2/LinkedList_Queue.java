class Node{
    public int element;
    public Node next;

    // constructor
    public Node(int element, Node next ){
        this.element = element;
        next = null;
    }
}
public class Linkedlist_Queue{
	Node front;
	Node rear;
    Node head;
	int len;

	public Linkedlist_queue(){
		front = null;
		rear = null;
        head = null;
		len = 0;
	}
	//
	public boolean isEmpty()
    {
        if (len == 0) {

        	return true; 	
        }
        else {
        	return false;
        }
    }
    //
    public int len(){
    	return len;
    }
    //
    public int first()
    {
        if (isEmpty()){
        	return 0;

        }
        else {
        	return front.element;
        }
        
	}
	public void enqueue(int n)
    {
        Node newest = new Node(n, null);
        if (this.isEmpty())
        {
            this.head = newest;
            this.rear = newest;
            this.front = newest;
        }
        else
        {
            this.rear.next = newest;
            this.rear = newest;
        }
        len = len + 1;
    } 
    //
    public int dequeue()
    {
        int x = front.element;

        if (isEmpty()) {
        	return 0;
        }

        else {
            front = front.next;
        }
        len = len - 1;
        return x;
    }
    public static void main(String[] args) {
        Linkedlist_queue obj = new Linkedlist_queue();

        obj.enqueue(7);
        obj.enqueue(5);
        obj.enqueue(3);
                
        System.out.println("Is your array empty?: "+obj.isEmpty());
        System.out.println("Size of your array: "+obj.len());
        System.out.println("First element is: "+obj.first());
        System.out.println("Removed element is: "+obj.dequeue());
        System.out.println("New size is: "+obj.len());
        System.out.println("Now first element after removing is: "+obj.first());
        System.out.println("All the test passed");
    }
}