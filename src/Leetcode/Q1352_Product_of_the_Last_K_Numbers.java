package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Design an algorithm that accepts a stream of integers and retrieves the product of the last k integers of the stream.
 */
public class Q1352_Product_of_the_Last_K_Numbers {

    // Complexity: O(1)
    private final List<Integer> prefixProducts;  // List to store the prefix products.

    // Constructor initializes the data structure with a single '1'.
    public Q1352_Product_of_the_Last_K_Numbers() {
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            prefixProducts.clear();
            prefixProducts.add(1);
        } else {
            int lastProduct = prefixProducts.get(prefixProducts.size() - 1);
            prefixProducts.add(lastProduct * num);
        }
    }

    public int getProduct(int k) {
        int n = prefixProducts.size();
        return k >= n ? 0 :
                prefixProducts.get(n - 1) / prefixProducts.get(n - k - 1);
    }

    public static void main(String[] args) {
        Q1352_Product_of_the_Last_K_Numbers sol = new Q1352_Product_of_the_Last_K_Numbers();

        // { 1,2,2,6,6,6,6,7,10 };
        sol.add(1);
        sol.add(2);
        sol.add(2);
        sol.add(6);
        sol.add(6);
        sol.add(6);
        sol.add(6);
        sol.add(7);
        sol.add(10);

        int result = sol.getProduct(4);
        System.out.println(result);
    }
}
