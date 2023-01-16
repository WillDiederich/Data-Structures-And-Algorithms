package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort_DFS {
    public static Stack<Integer> topologicalSort(int[][] graph, int v){
        List<List<Integer>> adjacencyList = buildGraph(graph, v);
        boolean[] visited = new boolean[v];
        Stack<Integer> result = new Stack<>();
        for(int currentVertex = 0; currentVertex < v; currentVertex++){
            if(!visited[currentVertex]){
                result = visit(adjacencyList, visited, result, currentVertex);
            }
        }
        return result;
    }

    public static Stack<Integer> visit(List<List<Integer>> adjacencyList, boolean[] visited, Stack<Integer> result, int currentVertex){
        if(visited[currentVertex]){
            return result;
        }
        for(int nextVertex : adjacencyList.get(currentVertex)){
            result = visit(adjacencyList, visited, result, nextVertex);
        }
        visited[currentVertex] = true;
        result.push(currentVertex);
        return result;
    }

    // Detect Cycles in a graph:
    public static boolean topologicalSortDetectCycles(int[][] graph, int v){
        List<List<Integer>> adjacencyList = buildGraph(graph, v);
        boolean[] visited = new boolean[v];
        for(int currentVertex = 0; currentVertex < v; currentVertex++){
            if(!visited[currentVertex]){
                if(!visit(adjacencyList, visited, new boolean[v], currentVertex)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean visit(List<List<Integer>> adjacencyList, boolean[] visited, boolean[] checkCycle, int currentVertex){
        if(!visited[currentVertex]){
            if(checkCycle[currentVertex]){
                return false;
            }
            checkCycle[currentVertex] = true;
            for(int nextNode : adjacencyList.get(currentVertex)){
                if(!visit(adjacencyList, visited, checkCycle, nextNode)){
                    return false;
                }
            }
        }
        checkCycle[currentVertex] = false;
        visited[currentVertex] = true;
        return true;
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
        int[][] graph = new int[][]{ {5, 2}, {5, 0}, {4,0}, {4, 1}, {2, 3}, {3, 1} };
        Stack<Integer> temp = topologicalSort(graph, 6);
        while(!temp.isEmpty()){
            System.out.println(temp.pop());
        }
        int[][] graph2 = new int[][]{ {5, 2}, {5, 0}, {4,0}, {4, 1}, {2, 3}, {3, 1} };
        boolean tf = topologicalSortDetectCycles(graph2, 6);
        if(!tf){
            System.out.println("Cycle detected");
        }
        else{
            System.out.println("No cycle detected");
        }

    }
}
