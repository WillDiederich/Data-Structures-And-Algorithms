package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleSourceShortestPath_BellmanFord {
    public static void bellmanFord(int[][] graph, int source, int v){
        int[] distance = new int[v];
        int[] predecessor = new int[v];
        for(int x = 0; x < v; x++){
            distance[x] = Integer.MAX_VALUE;
            predecessor[x] = -1;
        }
        distance[source] = 0;
        for(int x = 0; x < v - 1; x++){
            for(int[] edge : graph){
                int start = edge[0];
                int destination = edge[1];
                int weight = edge[2];
                if(distance[start] + weight < distance[destination]){
                    distance[destination] = distance[start] + weight;
                }
            }
        }

        for(int[] edge : graph){
            int start = edge[0];
            int destination = edge[1];
            int weight = edge[2];
            if(distance[start] + weight < distance[destination]){
                System.out.println("Negative weight cycle detected");
            }
        }
    }

    public static List<List<Integer>> buildGraph(int[][] graph, int v){
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int x = 0; x < v; x++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : graph) {
            adjacencyList.get(edge[0]).add(edge[1]);
        }
        return adjacencyList;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][] {
//                {0,1,4}, {0,7,8},
//                {1,0,4}, {1,2,8}, {1,7,11},
//                {2,1,8}, {2,8,2}, {2,5,4}, {2,3,7},
//                {3,2,7}, {3,4,9}, {3,5,14},
//                {4,3,9}, {4,5,10},
//                {5,4,10}, {5,3,14}, {5,2,4}, {5,6,2},
//                {6,5,2}, {6,8,6}, {6,7,1},
//                {7,0,8}, {7,1,11}, {7,8,7}, {7,6,1},
//                {8,7,7}, {8,6,6},
                        {0,1,-5},
                        {1,2,1},
                        {2,0,1}
        };

        bellmanFord(graph, 0, 9);
    }
}
