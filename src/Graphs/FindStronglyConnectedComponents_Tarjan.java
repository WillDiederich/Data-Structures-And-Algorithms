package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindStronglyConnectedComponents_Tarjan {
    static int count = 0;
    public static int findStronglyConnectedComponents(int[][] graph, int v){
        List<List<Integer>> adjacencyList = buildGraph(graph, v);
        Stack<Integer> stack = new Stack<>();
        boolean[] onStack = new boolean[v];
        int[] ids = new int[v];
        int[] low = new int[v];
        int id = 0;

        for(int x = 0; x < v; x++){
            ids[x] = -1;
        }
        for(int x = 0; x < v; x++){
            if(ids[x] == -1){
                dfs(adjacencyList, stack, onStack, ids, low, x, id);
            }
        }
        return count;
    }

    public static void dfs(List<List<Integer>> adjacencyList, Stack<Integer> stack, boolean[] onStack, int[] ids, int[] low, int currentVertex, int id){
        stack.push(currentVertex);
        onStack[currentVertex] = true;
        ids[currentVertex] = id;
        low[currentVertex] = id;
        id++;
        for(int nextVertex : adjacencyList.get(currentVertex)){
            if(ids[nextVertex] == -1){
                dfs(adjacencyList, stack, onStack, ids, low, nextVertex, id);
            }
            if(onStack[nextVertex]){
                low[currentVertex] = Math.min(low[currentVertex], low[nextVertex]);
            }
        }
        if(ids[currentVertex] == low[currentVertex]){
            while(!stack.isEmpty()){
                int x = stack.pop();
                onStack[x] = false;
                low[x] = ids[currentVertex];
                if(x == currentVertex){
                    break;
                }
            }
            count++;
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
        int[][] graph = { {0,1}, {1,2}, {1,4}, {1,6}, {2,3}, {3,2}, {3,5}, {3,4}, {4,5}, {5,4}, {6,0}, {6,2} };
        System.out.println(findStronglyConnectedComponents(graph, 7));
    }
}
