# Graphs

## Types

#### Undirected
#### Directed
#### Acyclic
#### Cyclic

## Definitions
#### Vertex
#### Edge
#### Bridge
   - A Bridge is an edge which, when removed, will make the graph disconnected.
   - Bridges can be found by using Tarjan's algorithm for finding articulation points and bridges. 
#### Articulation Point
   - An Articulation Point is a vertex which, when removed, will make the graph disconnected.
   - Articulation Points can be found by using Tarjan's algorithm for finding articulation points and bridges. 
#### Strongly Connected Graph/Component
   - A graph is considered strongly connected if every vertex is r eachable from every other vertex.
   - A strongly connected component is a portion of a graph where every vertex is reachable from every other vertex.
   - Strongly connected components can be found by using Tarjan's algorithm for finding strongly connected components. 
   
## Graph Algorithms

#### General Breadth-First Search
#### General Depth-First Search

#### Strongly Connected Components - Kosaraju's Algorithm
#### Strongly Connected Components - Tarjan's Algorithm

#### Minimum Spanning Tree - Kruskal's Algorithm 
   - Kruskal's Minimum Spanning Tree algorithm builds a minimum spanning tree by sorting the edges by weight, and then by selecting the minimum cost edges that do not form a cycle.
#### Minimum Spanning Tree - Prim's Algorithm
   - Prim's Minimum Spanning Tree algorithm builds a minimum spanning tree by starting from a random verted, and then by selecting the minimum cost vertex connected to that vertex.
   - Can handle negative weight.
   - Only works on undirected graphs.

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
