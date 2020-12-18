import java.util.LinkedList;
public class EdgeWeightedGraph {
    static class Edge {
        int source;
        int destination;
        int weight;
        
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
    static class Graph {
        int v;
        LinkedList<Edge> [] adj;

        Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v ; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEgde(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adj[source].addFirst(edge);
        }
       public void printGraph(){
            for (int i = 0; i <v ; i++) {
                LinkedList<Edge> list = adj[i];
                for (int j = 0; j <list.size() ; j++) {
                    System.out.println("vertex" + i + " is connected to " + list.get(j).destination + " with weight " +  list.get(j).weight);
                }
            }
        }
    }
    public static void main(String[] args) {
        int v = 4;
        Graph graph = new Graph(v);
        graph.addEgde(0, 1, 4);
        graph.addEgde(1, 3, 2);
        graph.addEgde(2, 3, 5);
        graph.addEgde(3, 4, 2);
        graph.printGraph();
    }
}