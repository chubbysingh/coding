package com.whitespace.raghav.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 7/30/15.
 */
public class RootToLeaf {
    public static void printRootToLeaf(Tree root) {
        if (root == null)
            return;

        List<String> path = new ArrayList<String>();
        printPath(root, path, 0);

    }

    private static void printPath(Tree root, List<String> path, int i) {
        if (root == null)
            return;

        path.add(i, root.data);
        i++;

        if (root.left == null && root.right == null) {
            for (int count = 0; count < i; count++) {
                System.out.print(path.get(count) + " ");

            }
            System.out.println("");
        }
        printPath(root.left, path, i);
        printPath(root.right, path, i);
    }

    public static void main(String[] args) {
        Tree root = TreeUtils.populateTree();
        printRootToLeaf(root);
    }
}
