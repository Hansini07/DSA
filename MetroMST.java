import java.util.*;

class Edge {
    int source, destination, weight;

    Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class UnionFind {
    int[] parent;

    UnionFind(int n) {
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        if (parent[x] == x)
            return x;

        return find(parent[x]);
    }

    boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY)
            return false;

        parent[rootX] = rootY;
        return true;
    }
}

public class MetroMST {

    public static void main(String[] args) {

        String[] stations = {
                "M", "K", "W", "S", "E", "Y", "H"
        };

        List<Edge> edges = new ArrayList<>();

        // Candidate edges with costs
        edges.add(new Edge(0, 1, 8));   // M-K
        edges.add(new Edge(0, 2, 12));  // M-W
        edges.add(new Edge(0, 3, 10));  // M-S
        edges.add(new Edge(1, 2, 7));   // K-W
        edges.add(new Edge(1, 4, 9));   // K-E
        edges.add(new Edge(2, 3, 11));  // W-S
        edges.add(new Edge(2, 5, 5));   // W-Y
        edges.add(new Edge(3, 4, 6));   // S-E
        edges.add(new Edge(3, 6, 4));   // S-H
        edges.add(new Edge(4, 5, 8));   // E-Y
        edges.add(new Edge(5, 6, 9));   // Y-H
        edges.add(new Edge(4, 6, 14));  // E-H

        // Sort edges by weight
        edges.sort(Comparator.comparingInt(e -> e.weight));

        UnionFind uf = new UnionFind(7);

        int totalCost = 0;

        System.out.println("Minimum Spanning Tree (MST):\n");

        for (Edge edge : edges) {

            if (uf.union(edge.source, edge.destination)) {

                System.out.println(
                        stations[edge.source] + " - "
                                + stations[edge.destination]
                                + " : Rs." + edge.weight + " crore");

                totalCost += edge.weight;
            }
        }

        System.out.println("\nTotal Construction Cost = Rs." + totalCost + " crore");
    }
}