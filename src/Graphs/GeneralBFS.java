package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GeneralBFS {
    public static void bfs(int[][] graph, int v, int source){
        List<List<Integer>> adjacencyList = buildGraph(graph, v);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];
        queue.add(source);
        while(!queue.isEmpty()){
            int current = queue.poll();
            visited[current] = true;
            System.out.println(current);
            for(int x : adjacencyList.get(current)){
                if(!visited[x]){
                    queue.add(x);
                }
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
        int[][] graph = { {0,1}, {0,2}, {1,3} };
        bfs(graph, 4, 1);
    }
}