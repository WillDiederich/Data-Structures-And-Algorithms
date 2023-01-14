package Graphs;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyList {
    public List<List<Integer>> buildDirectedAdjacencyList1(int[][] graph, int v){
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int x = 0; x < v; x++){
            adjacencyList.add(new ArrayList<Integer>());
        }
        for(int[] edge : graph){
            adjacencyList.get(edge[0]).add(edge[1]);
            // Include the below line if the graph is undirected.
            // adjacencyList.get(edge[1]).add(edge[0]);
        }
        return adjacencyList;
    }

    public List<Integer>[] buildAdjacencyList2(int[][] graph, int v){
        List<Integer>[] adjacencyList = new ArrayList[v];
        for(int x = 0; x < v; x++){
            adjacencyList[x] = new ArrayList<Integer>();
        }
        for(int[] edge : graph){
            adjacencyList[edge[0]].add(edge[1]);
            // Include the below line if the graph is undirected.
            // adjacencyList[edge[1]].add(edge[0]);
        }
        return adjacencyList;
    }

    public Map<Integer, List<Integer>> buildAdjacencyList3(int[][] graph, int v){
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for(int x = 0; x < v; x++){
            adjacencyList.put(x, new ArrayList<>());
        }
        for(int[] edge : graph){
            adjacencyList.get(edge[0]).add(edge[1]);
            // Include the below line if the graph is undirected.
            // adjacencyList.get(edge[1]).add(edge[0]);
        }
        return adjacencyList;
    }
}
