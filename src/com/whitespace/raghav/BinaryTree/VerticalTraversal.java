package com.whitespace.raghav.BinaryTree;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by rbhatnagar2 on 9/14/15.
 */
public class VerticalTraversal {


    private static void buildMap(Tree root, TreeMap<Integer, LinkedList<String>> map, int distance) {
        if (root == null)
            return;

        if (map.containsKey(distance)) {
            LinkedList<String> data = map.get(distance);
            data.add(root.data);
            map.put(distance, data);
        } else {
            LinkedList<String> data = new LinkedList<String>();
            data.add(root.data);
            map.put(distance, data);
        }

        buildMap(root.left, map, distance-1);
        buildMap(root.right, map, distance+1);
    }

    public static void main(String[] args) {
        Tree root = TreeUtils.populateTree();

        TreeMap<Integer, LinkedList<String>> map = new TreeMap<Integer, LinkedList<String>>();

        buildMap(root, map, 0);

        for(Map.Entry<Integer, LinkedList<String>> entry : map.entrySet()) {
            LinkedList<String> data = entry.getValue();
            for (String s : data) {
                System.out.print(s);
            }
            System.out.println();

        }

    }
}
