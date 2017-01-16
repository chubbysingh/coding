package com.whitespace.raghav.BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 8/30/15.
 */
public class Diameter {

    //O(n)
    private static int diameterRecursive(Tree node) {
        Map<Tree, Integer> heightMap = new HashMap<Tree, Integer>();
        if (node == null)
            return 0;
        int lHeight = getHeight(node.left, heightMap);
        int rHeight = getHeight(node.right, heightMap);

        return Math.max(Math.max(diameterRecursive(node.left), diameterRecursive(node.right)), lHeight+rHeight+1);
    }

    //O(n)
    private static int getHeight(Tree node, Map<Tree, Integer> heightMap) {
        if (node == null)
            return 0;

        if (!heightMap.containsKey(node.left)) {
            heightMap.put(node.left, getHeight(node.left, heightMap));
        }
        int lHeight = heightMap.get(node.left);

        if (!heightMap.containsKey(node.right)) {
            heightMap.put(node.right, getHeight(node.right, heightMap));
        }
        int rHeight = heightMap.get(node.right);

        return Math.max(lHeight, rHeight) + 1;
    }

    //Method Two
    private static void diameterRecursive(Tree node, Data d) {
        if (node == null) {
            d.diameter = 0;
            d.height = 0;
            return;
        }

        diameterRecursive(node.left, d);
        int lDiameter = d.diameter;
        int lHeight = d.height;

        diameterRecursive(node.right, d);
        int rDiameter = d.diameter;
        int rHeight = d.height;

        d.height = Math.max(lHeight, rHeight) + 1;
        d.diameter = Math.max(Math.max(lDiameter, rDiameter), d.height);


    }

    public static void main(String[] args) {
        Tree node = TreeUtils.populateTree();
        int dia = diameterRecursive(node);
        System.out.println("Diameter : " + dia);

        //Recursive Call
        Data d = new Data();
        diameterRecursive(node, d);
        System.out.println("Diameter : " + d.diameter);
    }
}



class Data {
    int diameter;
    int height;
}
