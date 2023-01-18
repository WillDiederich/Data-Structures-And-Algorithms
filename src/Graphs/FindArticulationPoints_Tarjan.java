package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindArticulationPoints_Tarjan {
    static int time = 0;
    public static List<Integer> findBridges(int[][] graph, int v){
        List<List<Integer>> adjacencyList = buildGraph(graph, v);
        List<Integer> articulationPoints = new ArrayList<>();
        // Discovered contains the time that each vertex was discovered.
        int[] discovered = new int[v];
        // The low-link value of a vertex is the lowest node that can be reached from that node during a depth-first search
        int[] lowLink = new int[v];

        Arrays.fill(discovered, -1);
        // Perform dfs on all unvisited nodes.
        for(int x = 0; x < v; x++){
            if(discovered[x] == -1){
                dfs(adjacencyList, articulationPoints, discovered, lowLink, x, x);
            }
        }
        return articulationPoints;
    }

    public static void dfs(List<List<Integer>> adjacencyList, List<Integer> articulationPoints,
                           int[] discovered, int[] lowLink, int currentVertex, int parent){
        int children = 0;
        time++;
        discovered[currentVertex] = time;
        lowLink[currentVertex] = time;
        // Visit every neighbor of the current vertex
        for(int nextVertex : adjacencyList.get(currentVertex)){
            if(nextVertex != parent && discovered[nextVertex] == -1){
                dfs(adjacencyList, articulationPoints, discovered, lowLink, nextVertex, currentVertex);
                lowLink[currentVertex] = Math.min(lowLink[currentVertex], lowLink[nextVertex]);
                children++;
                if(lowLink[nextVertex] >= discovered[currentVertex] && parent != currentVertex){
                    articulationPoints.add(currentVertex);
                }
                else if(nextVertex != parent){
                    lowLink[currentVertex] = Math.min(lowLink[currentVertex], discovered[nextVertex]);
                }
            }
        }
        if(parent == currentVertex && children > 1){
            articulationPoints.add(currentVertex);
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