# Graphs

## Types

#### Undirected
#### Directed
#### Acyclic
#### Cyclic

## Graph Algorithms

#### General Breadth-First Search
#### General Depth-First Search

#### Strongly Connected Components - Kosaraju's Algorithm
#### Strongly Connected Components - Tarjan's Algorithm

#### Minimum Spanning Tree - Kruskal's Algorithm 
#### Minimum Spanning Tree - Prim's Algorithm

#### All-Pairs Shortest Path - Floyd-Warshall Algorithm
   - Floyd-Warshall's All-Pairs Shortest Path Algorithm finds the shortest path between every possible vertex pair in a graph.
   - Works on both directed and undirected graphs.
   - Can handle negative weight edges but not negative weight cycles, meaning undirected graphs cannot contain any negative weight edges.
   - O(V<sup>3</sup>)
#### All-Pairs Shortest Path - Johnson's Algorithm

#### Single-Source Shortest Path - Bellman–Ford
   - Bellman-Ford's Single Source Shortest Path algorithm finds the shortest path from a single source vertex to every other vertex in a graph.
   - Works on both directed and undirected graphs.
   - Can handle negative weight edges but not negative weight cycles, meaning undirected graphs cannot contain any negative weight edges.
   - O(V·E)
#### Single Source Shortest Path - Dijkstra's Algorithm
   - Dijkstra's Single Source Shortest Path algorithm finds the shortest path from a single source vertex to every other vertex in a graph.
   - Works on both directed and undirected graphs.
   - Cannot handle negative weight edges. 
   - O(E·Log·V)

#### Topological Sort - Kahn's Algorithm
#### Topolobical Sort - General BFS

#### Find Bridges - Tarjan's Algorithm
#### Find Articulation Points - Tarjan's Algorithm
