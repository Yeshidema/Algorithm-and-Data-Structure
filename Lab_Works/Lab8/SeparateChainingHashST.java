import java.util.*;
public class SeparateChainingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int n;                                // number of key-value pairs
    private int m;                                // hash table size
    private SequentialSearchST<Key, Value>[] st;  // array of linked-list symbol tables
    /**
     * Initializes an empty symbol table.
     */
    public SeparateChainingHashST() {
       this(INIT_CAPACITY);
    } 

    /**
     * Initializes an empty symbol table with {@code m} chains.
     * @param m the initial number of chains
     */
    public SeparateChainingHashST(int m) {
    	this.m = m;
    	st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
    	for (int i = 0; i< m; i++)
    		st[i] = new SequentialSearchST<Key, Value>();

    } 

    // resize the hash table to have the given number of chains,
    // rehashing all of the keys
    private void resize(int chains) {
    	SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<Key, Value>(chains);
    	for (int i = 0; i < m; i++){
    		for (Key key : st[i].keys()) {
    			temp.put(key, st[i].get(key));
    		}
    	}
    	this.m = m;
    	this.n = n;
    	this.st = st;
    }

    // hash function for keys - returns value between 0 and m-1
    private int hashTextbook(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    private int hash(Key key){
    	int h = key.hashCode();
    	 h = (h >>> 20) ^ (h >>> 12) ^ (h >>> 7) ^ (h >>> 4);
    	 return h & (m - 1);

    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
       return n;
    } 

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        if(size() == 0){
        	return true;
        }	
        else{
        	return false;
        }	
        
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key};
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException ("Key cannot be null");
        else if(get(key) == null){
        	return false;
        }
        return true;
    } 

    /**
     * Returns the value associated with the specified key in this symbol table.
     *
     * @param  key the key
     * @return the value associated with {@code key} in the symbol table;
     *         {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException ("Key cannot be null");

        int i = hash(key);
        return st[i].get(key);
        }

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
    	if (key == null) throw new IllegalArgumentException ("Key cannot be null");
    	if (val == null) {
    		delete(key);
    		return;
    	}

    	if ( n >= 10*m) resize(2*m); //Double the size of the table if the length of the list is >= 10

    	int i = hash(key);
    	if (!st[i].contains(key)) n++;
    	st[i].put(key, val);

        
    } 

    /**
     * Removes the specified key and its associated value from this symbol table     
     * (if the key is in this symbol table).    
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");

        int i = hash(key);
        if(st[i].contains(key)) n--;
        st[i].delete(key);

        if (m > INIT_CAPACITY  && n <= 2*m) resize(m/2); // halve the size of the table if the length of the list id <= 2

    } 

    // return keys in symbol table as an Iterable
    public Iterable<Key> keys() {
        LinkedList <Key> link = new LinkedList<Key>();
        for (int i = 0; i < m; i++) {
        	for(Key key : st[i].keys())
        		link.add(key);

        }
        return link;
    }

    /**
     * Unit tests the {@code SeparateChainingHashST} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) { 
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();

        System.out.println("It is empty: " + st.isEmpty());

        st.put("A", 11);
        st.put("B", 22);
        st.put("C", 33);
        st.put("D", 44);
        st.put("E", 55);



        System.out.println("Size: " + st.size());
        System.out.println("It is empty: " + st.isEmpty());

        System.out.println("contains(A): " + st.contains("A"));
        System.out.println("Get(B): " + st.get("B"));
        System.out.println("Get(C): " + st.get("C"));

        System.out.println("Keys: " + st.keys());

        st.delete("A");
        st.delete("B");

        System.out.println("Size: " + st.size());



    }

}
