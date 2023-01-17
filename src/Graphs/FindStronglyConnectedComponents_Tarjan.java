package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FindStronglyConnectedComponents_Tarjan {
    public static List<List<Integer>> findStronglyConnectedComponents(int[][] graph, int v) {
        List<List<Integer>> adjacencyList = buildGraph(graph, v);
        List<List<Integer>> components = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] onStack = new boolean[v];
        int[] indices = new int[v];
        int[] low = new int[v];
        int index = 0;

        Arrays.fill(indices, -1);
        for(int x = 0; x < v; x++) {
            if(indices[x] == -1) {
                dfs(adjacencyList, components, stack, onStack, indices, low, x, index);
            }
        }
        return components;
    }

    public static void dfs(List<List<Integer>> adjacencyList, List<List<Integer>> components, Stack<Integer> stack,
                           boolean[] onStack, int[] indices, int[] low, int currentVertex, int index) {
        indices[currentVertex] = low[currentVertex] = index++;
        stack.push(currentVertex);
        onStack[currentVertex] = true;
        for(int nextVertex : adjacencyList.get(currentVertex)) {
            if(indices[nextVertex] == -1) {
                dfs(adjacencyList, components, stack, onStack, indices, low, nextVertex, index);
            }
            if(onStack[nextVertex]) {
                low[currentVertex] = Math.min(low[currentVertex], low[nextVertex]);
            }
        }

        if(indices[currentVertex] == low[currentVertex]) {
            List<Integer> temp = new ArrayList<>();
            while(!stack.isEmpty()) {
                int x = stack.pop();
                temp.add(x);
                onStack[x] = false;
                low[x] = indices[currentVertex];
                if(x == currentVertex) {
                    break;
                }
            }
            components.add(temp);
        }
    }

    public static List<List<Integer>> buildGraph(int[][] graph, int v) {
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
        List<List<Integer>> components = findStronglyConnectedComponents(graph, 7);
        System.out.println("Number of components: " + components.size());
        int count = 1;
        for(List<Integer> temp : components) {
            System.out.print("Component " + count++ + ": ");
            for(int x : temp) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
