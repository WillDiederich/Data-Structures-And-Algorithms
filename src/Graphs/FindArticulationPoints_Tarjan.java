package Graphs;

import java.util.ArrayList;
import java.util.List;

public class FindArticulationPoints_Tarjan {
    static int time = 0;
    public static List<Integer> findBridges(int[][] graph, int v){
        List<List<Integer>> adjacencyList = buildGraph(graph, v);
        List<Integer> articulationPoints = new ArrayList<>();
        // Discovered contains the time that each vertex was discovered.
        int[] discovered = new int[v];
        // Low contains the lowest vertex that each vertex can reach.
        int[] low = new int[v];
        // -1 denotes that a node hasn't been visited.
        for(int x = 0; x < v; x++){
            discovered[x] = -1;
        }
        // Perform dfs on all unvisited nodes.
        for(int x = 0; x < v; x++){
            if(discovered[x] == -1){
                dfs(adjacencyList, articulationPoints, discovered, low, x, x);
            }
        }
        return articulationPoints;
    }

    public static void dfs(List<List<Integer>> adjacencyList, List<Integer> articulationPoints, int[] discovered, int[] low, int current, int parent){
        int children = 0;
        time++;
        discovered[current] = time;
        low[current] = time;
        for(int nextVertex : adjacencyList.get(current)){
            if(nextVertex != parent){
                if(discovered[nextVertex] == -1) {
                    dfs(adjacencyList, articulationPoints, discovered, low, nextVertex, current);
                    low[current] = Math.min(low[current], low[nextVertex]);
                    children++;
                    if(low[nextVertex] >= discovered[current] && parent != current){
                        articulationPoints.add(current);
                    }
                }
                else if(nextVertex != parent){
                    low[current] = Math.min(low[current], discovered[nextVertex]);
                }
            }
        }
        if(parent == current && children > 1){
            articulationPoints.add(current);
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
        List<Integer> result = findBridges(graph, 4);
        for(int x : result){
            System.out.println(x);
        }
    }
}