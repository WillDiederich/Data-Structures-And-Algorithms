package Graphs;

public class UnionFind {
    public static void UF(int[][] graph, int v){
        int[] parent = new int[v];
        int[] size = new int[v];
        int[] rank = new int[v];
        for(int x = 0; x < v; x++){
            parent[x] = x;
            size[x] = 1;
            rank[x] = 0;
        }
        for(int[] edge : graph){
            union(parent, edge[0], edge[1]);
        }
        for(int x = 0; x < v; x++){
            System.out.println("Node " + x + ": " + parent[x] + ", " + size[x] + ", " + rank[x]);
        }
    }

    public static void union(int[] parent, int x, int y){
        x = find(parent, x);
        y = find(parent, y);
        if(x == y){
            return;
        }
        parent[y] = x;
    }

    public static void unionBySize(int[] parent, int[] size, int x, int y){
        x = find(parent, x);
        y = find(parent, y);
        if(x == y){
            return;
        }

        if(size[x] > size[y]){
            parent[y] = x;
            size[x] += size[y];
        }
        else{
            parent[x] = y;
            size[y] += size[x];
        }
    }

    public static void unionByRank(int[] parent, int[] rank, int x, int y){
        x = find(parent, x);
        y = find(parent, y);
        if(x == y){
            return;
        }
        if(rank[x] < rank[y]){
            parent[x] = y;
        }
        parent[y] = x;
        if(rank[x] == rank[y]){
            rank[x] += 1;
        }
    }

    public static int find(int[] parent, int x){
        if(parent[x] == x) {
            return x;
        }
        return find(parent, parent[x]);
    }

    public static int findWithCompression(int[] parent, int x){
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent, parent[x]);
    }
}
