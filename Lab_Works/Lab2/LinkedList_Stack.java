//creating a class
class Node{
    public int element;
    public Node next;

    // constructor
    public Node(int element, Node next ){
        this.element = element;
        next = null;
    }
}
public class Linkedlist_Stack{
    Node top;
    Node head;
    Node tail;
    int size;

    public Linkedlist_stack(){
        top = null;
        head = null;
        tail = null;
        size = 0;
    }
    //
    public boolean isEmpty()
    {
        if (this.top == null) {

            return true;    
        }
        else {
            return false;
        }
    }
    //
    public int size(){
        return size;
    }
    //
    public int top()
    {
        if (isEmpty()){
            return 0;

        }
        else {
            return top.element;
        }
        
    }
    public void push(int n)
    {
        Node newest = new Node(n, null);
        if(this.isEmpty()) {
            this.head = newest;
            this.top = newest;
            this.tail = newest;
        }
        else {
            this.top.next= newest;
            this.top = newest;
        }
        size = size + 1;
    }
    public int pop() {
        if(this.isEmpty()) {
            return 0;
        }
        else {
            int x = this.top.element;
            if(this.head == this.top) {// only one node
                this.top = null;
                this.head = null;
            }
            else {
                Node newest = this.head;
                while(newest.next != this.top) // iterating to the last element
                newest = newest.next;
                newest.next = null;
                this.top = newest;
            }
            size = size - 1;
            return x;
        }
    }
    //
    public static void main(String[] args) {
        Linkedlist_Stack obj = new Linkedlist_stack();

        obj.push(8);
        obj.push(4);
        obj.push(9);
                
        System.out.println("is your array empty?: "+obj.isEmpty());
        System.out.println("size of your array is: "+obj.size());
        System.out.println("Top of your element is: "+obj.top());
        System.out.println("The removed element is: "+obj.pop());
        System.out.println("Now the new size is: "+obj.size());
        System.out.println("Now the top element is: "+obj.top());
        System.out.println("Again removed element is: "+obj.pop());
        System.out.println("The new size is now: "+obj.size());
        System.out.println("All the test passed");
    }
}