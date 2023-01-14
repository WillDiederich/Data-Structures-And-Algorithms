package Graphs;

import java.util.*;

public class SingleSourceShortestPath_Dijkstra {
    public static int[] dijkstra(int[][] graph, int source, int v){
        // Create an adjacency list.
        Map<Integer, Map<Integer, Integer>> adjacencyList = new HashMap<>();
        for(int[] edge : graph){
            adjacencyList.putIfAbsent(edge[0], new HashMap<>());
            adjacencyList.get(edge[0]).put(edge[1], edge[2]);
        }

        // Create an integer array to hold each distance.
        int[] distance = new int[v];
        for(int x = 0; x < v; x++){
            distance[x] = Integer.MAX_VALUE;
        }
        distance[source] = 0;

        // Create a priority queue, sort the distances from smallest to largest.
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        priorityQueue.add(new int[]{source, 0});

        // Create a boolean array to ensure we don't reprocess vertices we have already visited.
        boolean[] visited = new boolean[v];
        while(!priorityQueue.isEmpty()){
            // Remove the first vertex in the queue.
            int[] current = priorityQueue.remove();
            int currentVertex = current[0];

            // Set the vertices visited flag to true.
            visited[currentVertex] = true;
            // Calculate the distance for each of the vertices neighbors.
            for(int next : adjacencyList.get(currentVertex).keySet()){
                int tempDistance = distance[currentVertex] + adjacencyList.get(currentVertex).get(next);
                if(tempDistance < distance[next]){
                    distance[next] = tempDistance;
                }
                // Add the neighbor to the queue if it hasn't been processed.
                if(!visited[next]) {
                    priorityQueue.add(new int[]{next, adjacencyList.get(currentVertex).get(next)});
                }
            }
        }
        return distance;
    }
//    public static void dijkstra(int[][] graph, int source, int v){
//        boolean[] visited = new boolean[v];
//        int[] distance = new int[v];
//        int[] previous = new int[v];
//
//        for(int x = 0; x < v; x++){
//            distance[x] = Integer.MAX_VALUE;
//            previous[x] = 0;
//            visited[x] = false;
//        }
//
//        distance[source] = 0;
//        for(int x = 0; x < v - 1; x++){
//            int minVertex = -1;
//            int minDistance = Integer.MAX_VALUE;
//            for(int y = 0; y < v; y++){
//                if(!visited[y] && distance[y] <= minDistance){
//                    minDistance = distance[y];
//                    minVertex = y;
//                }
//            }
//
//            visited[minVertex] = true;
//            for(int y = 0; y < v; y++){
//                if(!visited[y] && graph[minVertex][y] != 0 && distance[minVertex] != Integer.MAX_VALUE && distance[minVertex] + graph[minVertex][y] < distance[y]) {
//                    distance[y] = distance[minVertex] + graph[minVertex][y];
//                    previous[y] = minVertex;
//               }
//            }
//        }
//    }

    public static void main(String[] args) {
        int graph[][] = new int[][] {
                                    {0,1,4}, {0,7,8},
                                    {1,0,4}, {1,2,8}, {1,7,11},
                                    {2,1,8}, {2,8,2}, {2,5,4}, {2,3,7},
                                    {3,2,7}, {3,4,9}, {3,5,14},
                                    {4,3,9}, {4,5,10},
                                    {5,4,10}, {5,3,14}, {5,2,4}, {5,6,2},
                                    {6,5,2}, {6,8,6}, {6,7,1},
                                    {7,0,8}, {7,1,11}, {7,8,7}, {7,6,1},
                                    {8,7,7}, {8,6,6},
                                    };
        for(int x : dijkstra(graph, 0, 9)){
            System.out.println(x);
        }
    }
}
