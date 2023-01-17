package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindBridges_Tarjan {
    static int time = 0;
    public static List<List<Integer>> findBridges(int[][] graph, int v){
        List<List<Integer>> adjacencyList = buildGraph(graph, v);
        List<List<Integer>> bridges = new ArrayList<>();
        // Discovered contains the time that each vertex was discovered.
        int[] discovered = new int[v];
        // Low contains the lowest vertex that each vertex can reach.
        // Good explanation: https://youtu.be/wUgWX0nc4NY?t=70
        int[] low = new int[v];
        for(int x = 0; x < v; x++){
            discovered[x] = -1;
        }
        for(int x = 0; x < v; x++){
            if(discovered[x] == -1){
                dfs(adjacencyList, bridges, discovered, low, x, x);
            }
        }
        return bridges;
    }

    public static void dfs(List<List<Integer>> adjacencyList, List<List<Integer>> bridges, int[] discovered, int[] low, int current, int parent){
        time++;
        discovered[current] = time;
        low[current] = time;
        for(int nextVertex : adjacencyList.get(current)){
            if(nextVertex != parent){
                if(discovered[nextVertex] == -1){
                    dfs(adjacencyList, bridges, discovered, low, nextVertex, current);
                    low[current] = Math.min(low[current], low[nextVertex]);
                    if(low[nextVertex] > discovered[current]){
                        bridges.add(Arrays.asList(current, nextVertex));
                    }
                }
                else{
                    low[current] = Math.min(low[current], discovered[nextVertex]);
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
            // Include the below line when creating an undirected graph
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        return adjacencyList;
    }

    public static void main(String[] args) {
        int[][] graph = { {0,1}, {1,2}, {2,0}, {1,3} };
        List<List<Integer>> result = findBridges(graph, 4);
        for(List<Integer>  temp : result){
            for(int x : temp){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
