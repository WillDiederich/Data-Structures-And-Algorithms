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
        // The incides array serves to track the index value of a node, as well as if a node has been visited
        int[] indices = new int[v];
        // The low-link value of a vertex is the lowest node that can be reached from that node during a depth-first search
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
        // Visit every neighbor of the current vertex.
        for(int nextVertex : adjacencyList.get(currentVertex)) {
            // If the next vertex has not been visited, perform dfs on it.
            if(indices[nextVertex] == -1) {
                dfs(adjacencyList, components, stack, onStack, indices, low, nextVertex, index);
            }
            // If the next vertex is on the stack, set the low link value of the current vertex to the min low link between
            // the current vertex and the next vertex
            if(onStack[nextVertex]) {
                low[currentVertex] = Math.min(low[currentVertex], low[nextVertex]);
            }
        }

        // Check if we're at the start of a strongly connected component
        // The start of a strongly connected component is indicated by the index of the current vertex equaling its low link value
        if(indices[currentVertex] == low[currentVertex]) {
            List<Integer> temp = new ArrayList<>();
            // Pop every node contained within the strongly connected component from the stack
            while(!stack.isEmpty()) {
                int x = stack.pop();
                temp.add(x);
                // Set the onStack value to false
                onStack[x] = false;
                // Make every low link value for all nodes in the scc the same.
                low[x] = indices[currentVertex];
                // break when we've found the start of the scc.
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
        System.out.println("Number of strongly connected components: " + components.size());
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
