package com.whitespace.raghav.BinaryTree;

/**
 * Created by rbhatnagar2 on 4/7/17.
 */
public class TournamentTree {
    public static int secondMin(BTN root) {
        if(root.left == null && root.right == null) {
            return Integer.MAX_VALUE;
        }
        BTN node;
        int min;
        if(root.left.val == root.val) {
            node = root.left;
            min = root.right.val;
        } else {
            node = root.right;
            min = root.left.val;
        }
        return Math.min(min, secondMin(node));
    }

    public static void main(String[] args) {
        BTN N16 = new BTN(16, null, null);
        BTN N15 = new BTN(15, null, null);
        BTN N14 = new BTN(14, null, null);
        BTN N13 = new BTN(13, null, null);
        BTN N12 = new BTN(12, null, null);
        BTN N11 = new BTN(11, null, null);
        BTN N10 = new BTN(10, null, null);
        BTN N9 = new BTN(9, null, null);
        BTN N8 = new BTN(8, null, null);
        BTN N7 = new BTN(7, null, null);
        BTN N6 = new BTN(6, null, null);
        BTN N5 = new BTN(5, null, null);
        BTN N4 = new BTN(4, null, null);
        BTN N3 = new BTN(3, null, null);
        BTN N2 = new BTN(2, null, null);
        BTN N1 = new BTN(1, null, null);

        BTN N17 = new BTN(1, N1, N2);
        BTN N18 = new BTN(3, N3, N4);
        BTN N19 = new BTN(5, N5, N6);
        BTN N20 = new BTN(7, N7, N8);
        BTN N21 = new BTN(9, N9, N10);
        BTN N22 = new BTN(11, N11, N12);
        BTN N23 = new BTN(13, N13, N14);
        BTN N24 = new BTN(15, N15, N16);

        BTN N25 = new BTN(1, N17, N18);
        BTN N26 = new BTN(5, N19, N20);
        BTN N27 = new BTN(9, N21, N22);
        BTN N28 = new BTN(13, N23, N24);

        BTN N29 = new BTN(1, N25, N26);
        BTN N30 = new BTN(9, N27, N28);

        BTN N31 = new BTN(1, N29, N30);

        int secondMin = secondMin(N31);
        System.out.println(secondMin);

    }
}

class BTN{
    int val;
    BTN left;
    BTN right;
    public BTN(int val, BTN left, BTN right) {
        super();
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
