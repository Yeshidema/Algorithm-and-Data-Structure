public class LinkedList{
	//constructor
	int size=0;
	Node head=null;
	Node tail = null;

	public LinkedList(){
		size=0;
		head=null;
		tail=null;
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		if(size ==0){
			return true;
		}
		return false;
	}
	public int first(){
		if (ifEmpty()){
			
			return 0;
		}
		return head.getElement();
	}
	public int last(){
			if (ifEmpty()){
			return 0;
		}
		return tail.getElement();
	}

	
	public int addFrist(int element){
		Node newest = new Node(element, null);
		head = newest;
		tail = newest;

		if(size()==0){
			head= newest;
			tail = newest;
		}
		else{
			newest.setNext(head);
			head = newest;
		}
	}


	class Node{
		private int element;
		private Node next;
	}
	public Node(int value, Node n){
		element = value;
		next = n;
	}
	public int getElement(){
		return element;
	}
	public void setElement(){
		element = ele;
	}
	public Node getNext(){
		return next;
	}
	public void setNext(){
		next = n1;
	}

}
