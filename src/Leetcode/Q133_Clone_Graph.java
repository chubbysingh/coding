package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q133_Clone_Graph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();

        queue.offer(node);
        map.put(node, newNode);

        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            List<UndirectedGraphNode> neighbors = curr.neighbors;

            for (UndirectedGraphNode neighbor : neighbors) {
                if (!map.containsKey(neighbor)) {
                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, newNeighbor);
                    map.get(curr).neighbors.add(newNeighbor);
                    queue.offer(neighbor);
                } else {
                    UndirectedGraphNode newNeighbor = map.get(neighbor);
                    map.get(curr).neighbors.add(newNeighbor);
                }
            }
        }

        return newNode;
    }
}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};
