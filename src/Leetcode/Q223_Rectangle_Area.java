package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q223_Rectangle_Area {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (D-B)*(C-A),
                area2 = (H-F)*(G-E);

        int leftX = Math.max(A, E);
        int rightX = Math.min(G, C);
        int topY = Math.min(D, H);
        int bottomY = Math.max(B, F);

        //if overlap
        int overlap = 0;
        if (rightX > leftX && topY > bottomY) {
            overlap = (rightX - leftX)*(topY - bottomY);
        }
        return area1 + area2 - overlap;
    }
}
