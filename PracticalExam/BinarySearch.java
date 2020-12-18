import java.util.*;

public class BinarySearch<Key extends Comparable<Key>, Value> {
    private Node root;// this is the root of BST

    private class Node {
       
        private Key key;           
        private Value val;        
        private Node left, right; 
        private int n;          
        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.n = 1;
        }
    }

    public BinarySearch() {
        root=null;
    
       
    }

    
    public boolean isEmpty() {
        
        if (size()==0) {
            return true;  
        }
            return false;
    }

   
    public int size() {
      return size(root);
       
    }

    
    private int size(Node x) {
        if(x==null) return 0;
        return x.n; 
       
    }

   
    public Value get(Key key) {
             return get(root,key);
    }

    private Value get(Node x, Key key) {
       
        x = root;
        while (x != null)
    {
        int temp = key.compareTo(x.key);
            if (temp < 0) x = x.left;
            else if (temp > 0) x = x.right;
            else return x.val;
        }
            return null; 
        
    }
    public void put(Key key, Value val) {
          
         // root= put(root, key, val);
         if (val == null) { 
            delete(key); 
            return; 
        }
        root = put(root, key, val);

    }

    private Node put(Node x, Key key, Value val) {
        

        if (x == null) return new Node(key, val, 1);
        int temp = key.compareTo(x.key);
        if      (temp < 0) x.left  = put(x.left,  key, val);
        else if (temp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.n = 1 + size(x.left) + size(x.right);
        return x; 
    }


    
    
      public void deleteMin() {
        
        root = deleteMin(root);
        
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }
    public void delete(Key key) {
        root = delete(root, key);
        
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    } 


    
    public Key min() {
       return min(root).key;
    } 

    private Node min(Node x) { 
         if(x.left==null) return x;
         return min(x.left);
    } 

   
   
    

    
    public Iterable<Key> keys(Key lo, Key hi) {
     LinkedList<Key> link = new LinkedList<Key>();
        keys(root, link, lo, hi);
        return link;
    } 

    private void keys(Node x,LinkedList<Key> link, Key lo, Key hi) { 
         if (x == null) return; 
        int cmplo = lo.compareTo(x.key); 
        int cmphi = hi.compareTo(x.key); 
        if (cmplo < 0) keys(x.left, link, lo, hi); 
        if (cmplo <= 0 && cmphi >= 0) link.add(x.key); 
        if (cmphi > 0) keys(x.right, link, lo, hi);  
    } 

   
    
    public static void main(String[] args) { 
       BinarySearch<String, Integer> obj = new BinarySearch<String, Integer>();
        obj.put("Ada",1);
        obj.put("Ballerina", 3);

        System.out.println( obj.get("Ada"));

        obj.put("Html",5);
        obj.put("Java", 7);

        System.out.println(obj.get("Java"));
         
        System.out.println(obj.size());
        System.out.println(obj.min());

        System.out.println(obj.keys("Ada", "Java"));

        obj.put("Java", 8);
        obj.put("Dart", 9);
        System.out.println(obj.get("Java"));
        System.out.println(obj.size());

        obj.deleteMin();

        System.out.println(obj.keys("Ballerina", "Java"));

        obj.delete("Java");

    }
}   