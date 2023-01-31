package Graphs;

import java.util.Arrays;

public class SingleSourceShortestPath_FloydWarshall {
    public static void floydWarshall(int[][] graph, int v){
        int[][] distances = new int[v][v];
        // Set every weight in the graph to 999999, signifying infinity
        for(int[] row : distances){
            Arrays.fill(row, 999999);
        }
        // Set the weight for every edge in the distances graph
        for(int[] edge : graph){
            int source = edge[0];
            int destination = edge[1];
            int weight = edge[2];
            distances[source][destination] = weight;
        }
        // For every vertex, set the weight of the edge that points to itself to zero
        // Example: The weight of the edges (0 -> 0), ..., (n -> n) will be zero.
        for(int x = 0; x < v; x++){
            distances[x][x] = 0;
        }
        for(int x = 0; x < v; x++){
            for(int y = 0; y < v; y++){
                for(int z = 0; z < v; z++){
                    if(distances[y][z] > distances[y][x] + distances[x][z]){
                        distances[y][z] = distances[y][x] + distances[x][z];
                    }
                }
            }
        }

        for(int x = 0; x < v; x++){
            if(distances[x][x] < 0){
                System.out.println("Negative cycle detected");
                return;
            }
        }

        for(int x = 0; x < v; x++){
            System.out.println("Distance between " + x + " and every other vertex in ths graph: ");
            for(int y = 0; y < v; y++){
                System.out.print(distances[x][y] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][] {
                {0,1,4}, {0,7,8},
                {1,2,8}, {1,7,11},
                {2,8,2}, {2,5,4}, {2,3,7},
                {3,4,9}, {3,5,14},
                {4,5,10},
                {5,6,2},
                {6,8,6}, {6,7,1},
                {7,8,7},
//                {0,1,-5},
//                {1,2,1},
//                {2,0,1}
        };
        int numVertices = 9;

        floydWarshall(graph, numVertices);
    }
}
