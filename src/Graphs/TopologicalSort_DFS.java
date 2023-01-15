package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort_DFS {
    public static void topologicalSort(int[][] graph, int v) throws Exception {
        List<List<Integer>> adjacencyList = buildGraph(graph, v);
        Stack<Integer> result = new Stack<>();
        boolean[] visited = new boolean[v];
        for (int currentNode = 0; currentNode < v; currentNode++) {
            if (!visited[currentNode]) {
                result = visit(adjacencyList, result, visited, new boolean[v], currentNode);
            }
        }
        while(!result.isEmpty()){
            System.out.println(result.pop());
        }
    }

    public static Stack<Integer> visit(List<List<Integer>> adjacencyList, Stack<Integer> result, boolean[] visited, boolean[] temp, int currentNode) throws Exception {
        if(visited[currentNode]){
            return result;
        }
        if(temp[currentNode]){
            throw new Exception("Error: Cycle detected - Topological sort only works on Directed Acyclic Graphs.");
        }
        temp[currentNode] = true;
        for(int nextNode : adjacencyList.get(currentNode)){
            result = visit(adjacencyList, result, visited, temp, nextNode);
        }
        temp[currentNode] = false;
        visited[currentNode] = true;
        result.push(currentNode);
        return result;
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

    public static void main(String[] args) throws Exception {
        int[][] graph = new int[][]{ {5, 2}, {5, 0}, {4,0}, {4, 1}, {2, 3}, {3, 1}, {2,5} };
        topologicalSort(graph, 6);
    }
}
