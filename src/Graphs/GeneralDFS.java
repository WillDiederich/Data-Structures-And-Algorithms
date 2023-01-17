package Graphs;

import java.util.ArrayList;
import java.util.List;

public class GeneralDFS {
    public static void dfs(int[][] graph, int v, int source) {
        List<List<Integer>> adjacencyList = buildGraph(graph, v);
        boolean[] visited = new boolean[v];
        dfs(adjacencyList, visited, source);
    }

    public static void dfs(List<List<Integer>> adjacencyList, boolean[] visited, int current) {
        if(visited[current]){
            return;
        }
        visited[current] = true;
        System.out.println(current);
        for(int nextVertex : adjacencyList.get(current)) {
            if(!visited[nextVertex]){
                dfs(adjacencyList, visited, nextVertex);
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
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        return adjacencyList;
    }
    public static void main(String[] args) {
        int[][] graphWithoutCycle = new int[][]{ {5, 2}, {5, 0}, {4,0}, {4, 1}, {2, 3} };
        dfs(graphWithoutCycle, 6, 5);
    }
}
