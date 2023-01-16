package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort_DFS {
    public static Stack<Integer> topologicalSort(int[][] graph, int v) {
        List<List<Integer>> adjacencyList = buildGraph(graph, v);
        boolean[] visited = new boolean[v];
        Stack<Integer> result = new Stack<>();
        for(int currentVertex = 0; currentVertex < v; currentVertex++) {
            if(!visited[currentVertex]){
                if(dfs(adjacencyList, visited, new boolean[v], currentVertex, result)) {
                    System.out.println("Cycle detected.");
                    return null;
                }
            }
        }
        return result;
    }

    // Returns true if a cycle has been detected
    public static boolean dfs(List<List<Integer>> adjacencyList, boolean[] visited, boolean[] checkCycle, int currentVertex, Stack<Integer> result) {
        if(visited[currentVertex]) {
            return false;
        }
        if(checkCycle[currentVertex]) {
            return true;
        }
        checkCycle[currentVertex] = true;
        for(int nextNode : adjacencyList.get(currentVertex)){
            if(dfs(adjacencyList, visited, checkCycle, nextNode, result)) {
                return true;
            }
        }
        checkCycle[currentVertex] = false;
        visited[currentVertex] = true;
        result.push(currentVertex);
        return false;
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
        int[][] graphWithCycle = new int[][]{ {5, 2}, {5, 0}, {4,0}, {4, 1}, {2, 3}, {3, 1}, {2, 5} };
        int[][] graphWithoutCycle = new int[][]{ {5, 2}, {5, 0}, {4,0}, {4, 1}, {2, 3}, {3, 1} };
        Stack<Integer> temp = topologicalSort(graphWithoutCycle, 6);
        Stack<Integer> temp2 = topologicalSort(graphWithCycle, 6);
    }
}
