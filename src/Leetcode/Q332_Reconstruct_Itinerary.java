package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q332_Reconstruct_Itinerary {
    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<>();
        if (tickets == null || tickets.length == 0) {
            return result;
        }

        // step 1: build the ajdList
        Map<String, List<String>> adjList = new HashMap<>();
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];

            if (!adjList.containsKey(from)) {
                List<String> neighbors = new ArrayList<>();
                adjList.put(from, neighbors);
            }
            adjList.get(from).add(to);
        }

        // step 2: sort the adjlist according to lex order
        for (String from : adjList.keySet()) {
            List<String> neighbors = adjList.get(from);
            Collections.sort(neighbors);
        }

        // step 3: start the dfs
        findItineraryHelper("JFK", adjList, result);

        return result;
    }

    private void findItineraryHelper(String curr, Map<String, List<String>> adjList, List<String> result) {

        List<String> neighbors = adjList.get(curr);

        if (neighbors != null) {
            while (neighbors.size() > 0) {
                String neighbor = neighbors.get(0);
                neighbors.remove(0);
                findItineraryHelper(neighbor, adjList, result);
            }
        }

        result.add(0, curr);
    }
}
