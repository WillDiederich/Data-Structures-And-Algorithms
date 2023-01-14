package Graphs;

import java.util.*;

public class TopologicalSort_Kahn {
    public List<Integer> topologicalSort(int[][] graph, int v){
        // Build an adjacency list.
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int[] inDegree = new int[v];
        for(int x = 0; x < v; x++){
            adjacencyList.add(new ArrayList<>());
        }
        // Add every edge to the adjacency list.
        // Count the number of incoming edges that each vertex has.
        for(int[] edge : graph){
            adjacencyList.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        // Add every vertex that has no incoming edges to a queue.
        Queue<Integer> queue = new LinkedList<>();
        for(int x = 0; x < v; x++) {
            if (inDegree[x] == 0) {
                queue.add(x);
            }
        }
        List<Integer> result = new ArrayList<>();
        int count = 0;
        // Process the vertices
        while(!queue.isEmpty()){
            // Remove a vertex from the queue and add it to the result
            int currentVertex = queue.poll();
            result.add(currentVertex);
            count++;
            // Insert any of the current vertices neighbors that have no incoming edges into the queue
            for(int nextVertex : adjacencyList.get(currentVertex)){
                inDegree[nextVertex]--;
                if(inDegree[nextVertex] == 0){
                    queue.add(nextVertex);
                }
            }
        }
        // If the count is equal to the number of vertices, there are no cycles in the graph.
        if(count == v){
            return result;
        }
        else{
            return null;
        }
    }
}
