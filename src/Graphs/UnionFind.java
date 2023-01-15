package Graphs;

public class UnionFind {
    public int UnionFind(int[][] graph, int v){
        int[] parent = new int[v];
        for(int x = 0; x < v; x++){
            parent[x] =  -1;
        }
        for(int x = 0; x < graph.length; x++){
            int y = find(parent, graph[x][0]);
            int z = find(parent, graph[x][1]);
            if(y == z){
                return 1;
            }
            parent[x] = y;
        }
        return 0;
    }
    public int find(int[] parent, int x){
        if(parent[x] == -1) {
            return x;
        }
        return find(parent, parent[x]);
    }
}
