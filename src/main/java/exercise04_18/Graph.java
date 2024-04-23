package exercise04_18;

public class Graph {
    private Edge[] graph; // adjacency list for this graph

    // Static nested class Edge
    public static class Edge { // Class Edge
        private int neighbor; // id of the neighbor (id of the destination node)
        private Edge next; // reference to the next "edge"

        public Edge(int neighbor) {
            this.neighbor = neighbor;
            next = null;
        }
    } // class Edge

    public Graph(int numVertices) {
        graph = new Edge[numVertices];
    }

    /**
     * Return the number of vertices in the graph
     * @return number of vertices
     */
    public int getNumVertices() {
        return graph.length;
    }

    /**
     * Adds the given edge as an outgoing edge for the given vertex.
     * Modifies the adjacency list.
     *
     * @param vertexId id of the vertex
     * @param edge     outgoing edge
     *                 Do not modify.
     */
    public void addEdge(int vertexId, Edge edge) {
        Edge head = graph[vertexId]; // head of the linked list for this  node
        graph[vertexId] = edge; // insert in front
        if (head != null) {
            edge.next = head;
        }
    }

    public int getNumberOfOutgoingEdges(int vertexId) {
           Edge head = graph[vertexId]; //adjacency list for this vertex
           int count = 0;
           // FILL IN CODE


           return count;
    }

    public void printNeighbors(int vertexId) {
        Edge curr = graph[vertexId]; //adjacency list for this vertex
        // FILL IN CODE: print all the vertices we can directly reach for a given vertex
        // by following outgoing edges
        while(curr != null){
            System.out.println(curr.neighbor);
            curr = curr.next;
        }

    }

    public void printIncomingEdges(int vertexId) {
       // FILL IN CODE
        for(int i = 0; i< graph.length; i++){
            if (i == vertexId){
                continue;
            }
            Edge curr = graph[i];
            while(curr != null){
                if(curr.neighbor == vertexId){
                    System.out.println(graph[i]);
                }
                curr = curr.next;
            }
        }
    }

    public void runDFSFromVertex(int vertexId, boolean[] visited) {

        // FILL IN CODE

    }

    /** Repeatedly runs dfs starting from each vertex that has not been visited
     */
    public void dfsMain() {
        boolean[] visited = new boolean[graph.length];
        // FILL IN CODE: run dfs from every vertex
        // Should call runDFSFromVertex for each vertex

    }


    public static void main(String[] args) {
        Graph g = new Graph(8);

        // edges going out of vertex 1
        Edge edge10 = new Edge(0);
        Edge edge12 = new Edge(2);
        g.addEdge(1, edge10);
        g.addEdge(1, edge12);

        // edge going out of 0
        Edge edge05 = new Edge(5);
        g.addEdge(0, edge05);

        //edge going out of 2
        Edge edge26 = new Edge(6);
        g.addEdge(2, edge26);

        // edges going out of 5
        Edge edge54 = new Edge(4);
        Edge edge56 = new Edge(6);
        g.addEdge(5, edge54);
        g.addEdge(5, edge56);

        // edge going out of 6
        Edge edge67 = new Edge(7);
        g.addEdge(6, edge67);

        //edge going out of 4
        Edge edge47 = new Edge(7);
        g.addEdge(4, edge47);

        // edge going out of 7
        Edge edge75 = new Edge(5);
        g.addEdge(7, edge75);

        System.out.println(g.getNumberOfOutgoingEdges(0));
        // g.printNeighborsFromVertex(5);
        // g.printIncomingEdges(6);
        g.dfsMain();
    }
}

