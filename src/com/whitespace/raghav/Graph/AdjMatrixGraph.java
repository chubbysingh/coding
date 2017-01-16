package com.whitespace.raghav.Graph;

import java.util.Iterator;

/**
 * Created by rbhatnagar2 on 6/11/15.
 */
public class AdjMatrixGraph {
    private final int V;
    private int E;
    private boolean[][] adj;

    public AdjMatrixGraph(int v) {
        this.V = v;
        this.E = 0;

        adj = new boolean[V][V];

        for (int i = 0 ; i < V ; i++) {
            for (int j = 0 ; j < V ; j++) {
                adj[i][j] = false;
            }
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int u, int w) {
        if (!adj[u][w])
            E++;
        adj[u][w] = true;
        adj[w][u] = true;
    }

    public boolean contains(int v, int w) {
        return adj[v][w];
    }

    public Iterable<Integer> adj(int v) {
        return new AdjacencyIterator(v);
    }

    private class AdjacencyIterator implements Iterator<Integer>, Iterable<Integer> {
        int v, w = 0;
        AdjacencyIterator(int v) {
            this.v = v;
        }

        @Override
        public Iterator<Integer> iterator() {
            return this;
        }

        @Override
        public boolean hasNext() {
            while (w < V) {
                if (adj[v][w])
                    return true;
                w++;
            }
            return false;
        }

        @Override
        public Integer next() {
            return null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported");
        }
    }
}
