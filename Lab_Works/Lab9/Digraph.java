import java.util.NoSuchElementException;
import java.util.*;

public class Digraph {
    private final int V;                  // number of vertices in this digraph
    private int E;                        // number of edges in this digraph
    private LinkedList<Integer>[] adj;    // adj[v] = adjacency list for vertex v
    private int[] indegree;               // indegree[v] = indegree of vertex v
    
    /**
     * Initializes an empty digraph with <em>V</em> vertices.
     *
     * @param  V the number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public Digraph(int V) {
        if (V < 0 ) throw new IllegalArgumentException ("The number of vertices cannot be negative.");
        this.V = V;
        this.E = 0;
        indegree = new int[V];
        adj = (LinkedList<Integer>[]) new LinkedList[V];
        for (int v = 0;v < V ; v++ ) {
            adj[v] = new LinkedList<Integer>();
        }
    }    
            
    /**
     * Returns the number of vertices in this digraph.
     *
     * @return the number of vertices in this digraph
     */
    public int V() {
       return V;
    }
    /**
     * Returns the number of edges in this digraph.
     *
     * @return the number of edges in this digraph
     */
    public int E() {
        return E;
    }
    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException ("vertex " + v + " is not between 0 and " + (V-1));

    }
    /**
     * Adds the directed edge v→w to this digraph.
     *
     * @param  v the tail vertex
     * @param  w the head vertex
     * @throws IllegalArgumentException unless both {@code 0 <= v < V} and {@code 0 <= w < V}
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        indegree[w]++;
        E++;

    }

    /**
     * Returns the vertices adjacent from vertex {@code v} in this digraph.
     *
     * @param  v the vertex
     * @return the vertices adjacent from vertex {@code v} in this digraph, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }
   
    /**
     * Returns the reverse of the digraph.
     *
     * @return the reverse of the digraph
     */
    public Digraph reverse() {
        Digraph reverse = new Digraph(V);
        for (int v = 0; v < V; v++){
            for (int w : adj(v)) {
                reverse.addEdge(w, v);
            }    
        }
        return reverse;
    }
    /**
     * Returns a string representation of the graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,  
     *         followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE =  System.getProperty("line.separator");
        s.append(V + "vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++){
            s.append(String.format("%d : ", v));
            for (int w : adj[v]) {
                s.append(String.format("%d ", w));
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public static void main(String[] args) {
      Digraph obj = new Digraph(10);

      obj.addEdge(0,1);
      obj.addEdge(0,2);
      obj.addEdge(0,3);
      obj.addEdge(3,4);
      obj.addEdge(3,5);
      obj.addEdge(5,6);
      obj.addEdge(6,7);
      obj.addEdge(6,8);
      obj.addEdge(8,9);
      obj.addEdge(0,9);


    System.out.println("Number of vertices: " + obj.V());
    System.out.println("Number of edges: " + obj.E());
    System.out.println("Reverse: " + obj.reverse());
    System.out.println("To String: " + obj.toString());
    System.out.println("Out degree of 0: " + obj.adj(0));




    }

}