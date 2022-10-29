import java.util.*;
class Graph {
    private final int V;
    private int E;
    private ArrayList<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (ArrayList<Integer>[]) new ArrayList[V + 1];
        for (int v = 1; v <= V; v++) {
            adj[v] = new ArrayList<Integer>();
        }
    }

    public Graph(Scanner in) {
        this(in.nextInt());
        int E = in.nextInt();
        for (int i = 0; i < E; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            addEdge(v, w);
        }
    }

    public int V() {
        return V;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}

class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;
    private int s;

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V() + 1];
        edgeTo = new int[G.V() + 1];
        distTo = new int[G.V() + 1];
        this.s = s;
        for (int v = 1; v <= G.V(); v++)
            distTo[v] = Integer.MAX_VALUE;
        BFS(G, s);
    }

    private void BFS(Graph G, int s) {
        Queue<Integer> q = (Queue<Integer>) new LinkedList<Integer>();
        q.add(s);
        marked[s] = true;
        distTo[s] = 0;
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 6;
                    q.add(w);
                }
            }
        }
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public int distance(int v) {
        if (distTo[v] != Integer.MAX_VALUE) return distTo[v];
        return -1;
    }
}

public class Result {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            Graph graph = new Graph(in);
            int s = in.nextInt();
            BreadthFirstPaths bfp = new BreadthFirstPaths(graph, s);
            for (int v = 1; v <= graph.V(); v++) {
                if (s != v) {
                    System.out.print(bfp.distance(v) + " ");
                }
            }
            System.out.print("\n");
        }
    }
}