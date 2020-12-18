import java.util.*;

public class Solution<Key extends Comparable<Key>, Value> {
    private Node root;    
         // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int n;          // number of nodes in subtree

        public Node(Key key, Value val,int size ) {
            this.key = key;
            this.val = val;
            this.n = 1;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public Solution() {
    	root = null;
       
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        if(size()==0)
        	return true;
        return false;
       
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
      return size(root);
       
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if(x == null) return 0;
        return 1 + size(x.left) + size(x.right);
       
    }

    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    // public boolean contains(Key key) {
       
    // }

    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        // Node x = root;
        // while (x != null){
        // 	int t = key.compareTo(x.key);
        // 	if (t < 0) x = x.left;
        // 	else if (t > 0) x = x.right;
        // 	else return x.val;
        // }
        // return null;
        if(key == null){
            throw new IllegalArgumentException("argument to get value() is null");
        }
        Node curNode = root;
        while(curNode.key != key){
            int cmp = key.compareTo(curNode.key);
            if(cmp < 0){
                curNode = curNode.left;
            }
            else if(cmp > 0){
                curNode = curNode.right;
            }
        }
        if(curNode.key == key){
            System.out.println(curNode.val);
        }
        return curNode.val;
    }

    /*private Value get(Node x, Key key) {
       
        
        
    }*/

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        Node z = new Node(key, val,1);
        if (root == null) {
            root = z;
            return;
        }

        Node parent = null, x=root; 
    
        while (x != null) {
            parent = x;
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else {
                x.val = val;
                return; 
            }
        }
        int cmp = key.compareTo(parent.key);
        if (cmp < 0) parent.left  = z;
        else         parent.right = z;
    }

    // private Node put(Node x, Key key, Value val) {
        
    // }

    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
      return minimum(root).key;

    } 

    private Node minimum(Node x) { 
        if (x == null ) return null;
        while (x.left != null ) x = x.left;
        return x;

    } 

   

    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("key cannot be null");
        if (isEmpty()) throw new NoSuchElementException("your tree is empty");
        Node x = floor(root, key);
        if(x == null)
            return null;
        else
            return x.key;

            } 

    private Node floor(Node x, Key key) {
        Node mini = null;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x;
            if (cmp > 0) {
                mini = x;
                x  = x.right;
            }
            else {
                x = x.left;
            }
        }
        return mini;

    } 

    
    

    /**
     * Return the key in the symbol table whose rank is {@code k}.
     * This is the (k+1)st smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the key in the symbol table of rank {@code k}
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */
    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException ("invalid argument");

        }
        Node x = select(root, k);
        return x.key;
    }

    // Return key of rank k. 
    private Node select(Node x, int k) {
        int count = -1;
        Stack<Node> stack = new Stack<Node>();
        Node curr = root;
        while (!stack.empty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left; 
            }
            else{
                curr = stack.pop();
                count++;
                if(count == k)
                    break;
                curr = curr.right;
            }
        } 
        return curr;
         
    } 

    

    /**
     * Returns all keys in the symbol table in the given range,
     * as an {@code Iterable}.
     *
     * @param  lo minimum endpoint
     * @param  hi maximum endpoint
     * @return all keys in the symbol table between {@code lo} 
     *         (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
    public Iterable<Key> keys(Key lo, Key hi) {
        Stack<Node> stack = new Stack<Node>();
        LinkedList<Key> link = new LinkedList<Key>();
        Node x = root;
        while (x != null || !stack.isEmpty()) {
            if (x != null) {
                stack.push(x);
                x = x.left;
            }
            else {
                x = stack.pop();
                link.add(x.key);
                x = x.right;
            }
        }
        return link;
    } 

    // private void keys(Node x,Queue<Key> queue, Key lo, Key hi) { 
        
    // } 

   
    /* Run the program by giving the approriate command obtained from
    input files through input.txt files. The output should be displayed
    exactly like the file output.txt shows it to be.*/
  
    public static void main(String[] args) { 
        Solution <String, Integer> obj = new Solution<String, Integer>();
        obj.put("ABDUL",1);
        obj.get("ABDUL");
        obj.put("HRITHIK", 2);
        obj.put("SAI", 3);
        obj.put("SAMAL",6);
        obj.get("SAI");
        obj.put("TASHI", 4);

        System.out.println("The size of the tree is " + obj.size());
        System.out.println("Minimum: " + obj.min());
        System.out.println("Floor key : " + obj.floor("HRITHIK"));
        System.out.println(obj.floor("HAHA"));
        System.out.println(obj.select(2));
        System.out.println(obj.keys("ABDUL","TASHI"));
       
        obj.put("CHIMI",5);
        obj.put("SAMAL",4);
        System.out.println(obj.get("SAMAL"));
       
        obj.put("NIMA",7);
        System.out.println("Size: " + obj.size());
        obj.get("CHIMI");
        System.out.println(obj.floor("CHIMA"));
        
        obj.put("SONAM",8);
        System.out.println(obj.keys("ABDUL","TASHI")); 


        
       
    }
}