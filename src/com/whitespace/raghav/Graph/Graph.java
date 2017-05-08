package com.whitespace.raghav.Graph;

import java.util.LinkedList;

/**
 * Created by rbhatnagar2 on 6/11/15.
 * AdjList
 */
public class Graph {
    private final int V;
    private int E;
    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.V = v;
        this.E = 0;

        adj[V] = new LinkedList<Integer>();

        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    private void validateVertex(int u) {
        if (u < 0 || u > V)
            throw new IndexOutOfBoundsException("Vertex : " + u + " should be between 0 and " + (V - 1));
    }

    public void addEdge(int u, int w) {
        validateVertex(u);
        validateVertex(w);

        E++;
        adj[u].add(w);
        adj[w].add(u);
    }

    public Iterable<Integer> adj(int u) {
        validateVertex(u);
        return adj[u];
    }

    public int degree(int u) {
        validateVertex(u);
        return adj[u].size();
    }
}
