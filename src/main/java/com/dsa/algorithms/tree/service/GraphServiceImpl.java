package com.dsa.algorithms.tree.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.dsa.algorithms.tree.dto.AdjacencyMatrix;
import com.dsa.algorithms.tree.dto.Graph;
import com.dsa.algorithms.tree.dto.Graph2;
import com.dsa.algorithms.tree.dto.Result;

@Service
public class GraphServiceImpl implements GraphService {

	@Override
	public void printVertices(AdjacencyMatrix adjacencyMatrix) {
		// TODO Auto-generated method stub
		System.out.println("Vertices: "+ Arrays.toString(adjacencyMatrix.getVertexData()));		
	}
	
	@Override
	public void printAdjacencyMatrix(AdjacencyMatrix adjacencyMatrix) {
		// TODO Auto-generated method stub
		System.out.println("Adjacency Matrix:");
		for (int[] row : adjacencyMatrix.getAdjacencyMatrix()) {
			for (int value : row) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}

	@Override
	public void printConnections(AdjacencyMatrix adjacencyMatrix) {
		// TODO Auto-generated method stub
		System.out.println("\nConnections for each vertex:");
        for (int i = 0; i < adjacencyMatrix.getVertexData().length; i++) {
            System.out.print(adjacencyMatrix.getVertexData()[i] + ": ");
            for (int j = 0; j < adjacencyMatrix.getVertexData().length; j++) {
                if (adjacencyMatrix.getAdjacencyMatrix()[i][j] == 1) { // if there is a connection
                    System.out.print(adjacencyMatrix.getVertexData()[j] + " ");
                }
            }
            System.out.println();
        }
	}

	@Override
	public void addUndirectedAdjacencyMatrixEdge(int u, int v, Graph graph) {
        if (u >= 0 && u < graph.getSize() && v >= 0 && v < graph.getSize()) {
            graph.getAdjacencyMatrix()[u][v] = 1;
            graph.getAdjacencyMatrix()[v][u] = 1;
        }
    }
	
	@Override
	public void addUndirectedAdjacencyMatrixEdge(int u, int v, Graph2 graph) {
		if (u >= 0 && u < graph.getSize() && v >= 0 && v < graph.getSize()) {
			graph.getAdjacencyMatrix()[u][v] = 1;
			graph.getAdjacencyMatrix()[v][u] = 1;
		}
	}
	
	@Override
	public void addUndirectedAdjacencyMatrixEdgeWithWeight(int u, int v, int weight, Graph graph) {
		if (u >= 0 && u < graph.getSize() && v >= 0 && v < graph.getSize()) {
			graph.getAdjacencyMatrix()[u][v] = weight;
			graph.getAdjacencyMatrix()[v][u] = weight;
		}
	}
	
	@Override
	public void addDirectedAdjacencyMatrixEdgeWithWeight(int u, int v, int weight, Graph graph) {
		if (u >= 0 && u < graph.getSize() && v >= 0 && v < graph.getSize()) {
			graph.getAdjacencyMatrix()[u][v] = weight;
		}
	}
	
	@Override
	public void addDirectedAdjacencyMatrixEdge(int u, int v, Graph graph) {
		if (u >= 0 && u < graph.getSize() && v >= 0 && v < graph.getSize()) {
			graph.getAdjacencyMatrix()[u][v] = 1;
		}
	}
	
	@Override
    public void addVertexData(int vertex, char data, Graph graph) {
        if (vertex >= 0 && vertex < graph.getSize()) {
        	graph.getVertexData()[vertex] = data;
        }
    }
	
	@Override
	public void addVertexData(int vertex, char data, Graph2 graph) {
		if (vertex >= 0 && vertex < graph.getSize()) {
			graph.getVertexData()[vertex] = data;
		}
	}

	@Override
	public int find(int i, Graph2 graph) {
		if (graph.getParent()[i] == i) {
            return i;
        }
        return find(graph.getParent()[i], graph);
	}
		
	@Override
	public void union(int x, int y, Graph2 graph) {
        int xRoot = find(x, graph);
        int yRoot = find(y, graph);
        System.out.println("Union: " + graph.getVertexData()[x] + " + " + graph.getVertexData()[y]);
        graph.getParent()[xRoot] = yRoot;
        System.out.println(java.util.Arrays.toString(graph.getParent()) + "\n");
    }
	
	@Override
	public void printAdjacencyMatrixGraph(Graph graph) {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < graph.getSize(); i++) {
            for (int j = 0; j < graph.getSize(); j++) {
                System.out.print(graph.getAdjacencyMatrix()[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nVertex Data:");
        for (int i = 0; i < graph.getSize(); i++) {
            System.out.println("Vertex " + i + ": " + graph.getVertexData()[i]);
        }
    }
	
	@Override
	public void printAdjacencyMatrixGraph(Graph2 graph) {
		System.out.println("Adjacency Matrix:");
		for (int i = 0; i < graph.getSize(); i++) {
			for (int j = 0; j < graph.getSize(); j++) {
				System.out.print(graph.getAdjacencyMatrix()[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("\nVertex Data:");
		for (int i = 0; i < graph.getSize(); i++) {
			System.out.println("Vertex " + i + ": " + graph.getVertexData()[i]);
		}
	}
	
	@Override
	public void dfsUtil(int v, boolean[] visited, Graph graph) {
        visited[v] = true;
        System.out.print(graph.getVertexData()[v] + " ");

        for (int i = 0; i < graph.getSize(); i++) {
            if (graph.getAdjacencyMatrix()[v][i] == 1 && !visited[i]) {
                dfsUtil(i, visited, graph);
            }
        }
    }
	
	@Override
	public boolean dfsUtil(int v, boolean[] visited, int parent, Graph graph) {
		visited[v] = true;
		
		for (int i = 0; i < graph.getSize(); i++) {
			if (graph.getAdjacencyMatrix()[v][i] == 1) {
				if (!visited[i]) {
					if (dfsUtil(i, visited, v, graph)) {
						return true;
					}
				} else if (i != parent) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean dfsUtil(int v, boolean[] visited, boolean[] recStack, Graph graph) {
		visited[v] = true;
        recStack[v] = true;
        System.out.println("Current vertex: " + graph.getVertexData()[v]);

        for (int i = 0; i < graph.getSize(); i++) {
            if (graph.getAdjacencyMatrix()[v][i] == 1) {
                if (!visited[i]) {
                    if (dfsUtil(i, visited, recStack, graph)) {
                        return true;
                    }
                } else if (recStack[i]) {
                    return true;
                }
            }
        }

        recStack[v] = false;
        return false;
    }
	
	@Override
	public void dfs(char startVertexData, Graph graph) {
        boolean[] visited = new boolean[graph.getSize()];
        int startVertex = new String(graph.getVertexData()).indexOf(startVertexData);
        dfsUtil(startVertex, visited, graph);
    }

	
	@Override
	public boolean isCyclicForUndirectedGraphs(Graph graph) {
        boolean[] visited = new boolean[graph.getSize()]; 
        for (int i = 0; i < graph.getSize(); i++) {
            if (!visited[i]) {
                if (dfsUtil(i, visited, -1, graph)) {
                    return true;
                }
            }
        }
        return false;
    }
	
	@Override
	public boolean isCyclicForDirectedGraphs(Graph graph) {
		boolean[] visited = new boolean[graph.getSize()];
        boolean[] recStack = new boolean[graph.getSize()];

        for (int i = 0; i < graph.getSize(); i++) {
            if (!visited[i]) {
                System.out.println(); //new line
                if (dfsUtil(i, visited, recStack, graph)) {
                    return true;
                }
            }
        }
        return false;
	}
	
	@Override
	public boolean isCyclicForUndirectedGraphsUsingFindUnion(Graph2 graph) {
        for (int i = 0; i < graph.getSize(); i++) {
            for (int j = i + 1; j < graph.getSize(); j++) {
                if (graph.getAdjacencyMatrix()[i][j] == 1) {
                    int x = find(i, graph);
                    int y = find(j, graph);
                    if (x == y) {
                        return true;
                    }
                    union(x, y, graph);
                }
            }
        }
        return false;
    }

	@Override
	public void bfs(char startVertexData, Graph graphWithUndirectedAdjacencyMatrix2) {
		// TODO Auto-generated method stub
		boolean[] visited = new boolean[graphWithUndirectedAdjacencyMatrix2.getSize()];
        int[] queue = new int[graphWithUndirectedAdjacencyMatrix2.getSize()];
        int queueStart = 0;
        int queueEnd = 0;

        int startVertex = new String(graphWithUndirectedAdjacencyMatrix2.getVertexData()).indexOf(startVertexData);
        queue[queueEnd++] = startVertex;
        visited[startVertex] = true;

        while (queueStart < queueEnd) {
            int currentVertex = queue[queueStart++];
            System.out.print(graphWithUndirectedAdjacencyMatrix2.getVertexData()[currentVertex] + " ");

            for (int i = 0; i < graphWithUndirectedAdjacencyMatrix2.getSize(); i++) {
                if (graphWithUndirectedAdjacencyMatrix2.getAdjacencyMatrix()[currentVertex][i] == 1 && !visited[i]) {
                    queue[queueEnd++] = i;
                    visited[i] = true;
                }
            }
        }
	}
		
	@Override
	public int[] dijkstra(char startVertexData, Graph graph) {
        int startVertex = findIndex(startVertexData, graph);
        int[] distances = new int[graph.getSize()];
        boolean[] visited = new boolean[graph.getSize()];

        for (int i = 0; i < graph.getSize(); i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[startVertex] = 0;

        for (int i = 0; i < graph.getSize(); i++) {
            int u = minDistance(distances, visited, graph);
            if (u == -1) break;

            visited[u] = true;
            for (int v = 0; v < graph.getSize(); v++) {
                if (!visited[v] && graph.getAdjacencyMatrix()[u][v] != 0 && distances[u] != Integer.MAX_VALUE) {
                    int newDist = distances[u] + graph.getAdjacencyMatrix()[u][v];
                    if (newDist < distances[v]) {
                        distances[v] = newDist;
                    }
                }
            }
        }
        return distances;
    }
	
	@Override
	public int[] bellmanFord(Character startVertexData, Graph graph) {
        int startVertex = -1;
        for (int i = 0; i < graph.getSize(); i++) {
            if (startVertexData.equals(graph.getVertexData()[i])) {
                startVertex = i;
                break;
            }
        }
        if (startVertex == -1) {
            throw new IllegalArgumentException("Start vertex not found");
        }

        int[] distances = new int[graph.getSize()];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        for (int i = 0; i < graph.getSize() - 1; i++) {
            for (int u = 0; u < graph.getSize(); u++) {
                for (int v = 0; v < graph.getSize(); v++) {
                    if (graph.getAdjacencyMatrix()[u][v] != 0 && distances[u] != Integer.MAX_VALUE &&
                        distances[u] + graph.getAdjacencyMatrix()[u][v] < distances[v]) {
                        distances[v] = distances[u] + graph.getAdjacencyMatrix()[u][v];
                        System.out.println("Relaxing edge " + graph.getVertexData()[u] + "->" + graph.getVertexData()[v] + ", Updated distance to " + 
                        		graph.getVertexData()[v] + ": " + distances[v]);
                    }
                }
            }
        }

        return distances;
    }

	@Override
	public String getPath(Integer[] predecessors, char startVertex, char endVertex, Graph graph) {
        if (predecessors == null) {
            return "Path not available";
        }
    
        StringBuilder path = new StringBuilder();
        int current = findIndex(endVertex, graph);
    
        // Handle cases where endVertex is not found or has no path
        if (current == -1 || predecessors[current] == null) {
            return "No path from " + startVertex + " to " + endVertex;
        }
    
        while (current != -1) {
            path.insert(0, graph.getVertexData()[current]);
            Integer pred = predecessors[current];
            if (pred != null && pred != findIndex(startVertex, graph)) {
                path.insert(0, "->");
                current = pred;
            } else {
                if (pred != null) {
                    path.insert(0, startVertex + "->");
                }
                break;
            }
        }
        return path.toString();
    }
	
	@Override
	public Result bellmanFordReturningResult(Character startVertexData, Graph graph) {
		int startVertex = findIndex(startVertexData, graph);
        int[] distances = new int[graph.getSize()];
        Integer[] predecessors = new Integer[graph.getSize()];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(predecessors, null);
        distances[startVertex] = 0;

        for (int i = 0; i < graph.getSize() - 1; i++) {
            for (int u = 0; u < graph.getSize(); u++) {
                for (int v = 0; v < graph.getSize(); v++) {
                    if (graph.getAdjacencyMatrix()[u][v] != 0 && distances[u] != Integer.MAX_VALUE &&
                        distances[u] + graph.getAdjacencyMatrix()[u][v] < distances[v]) {
                        distances[v] = distances[u] + graph.getAdjacencyMatrix()[u][v];
                        predecessors[v] = u;
                        System.out.printf("Relaxing edge %s->%s, Updated distance to %s: %d%n",
                        		graph.getVertexData()[u], graph.getVertexData()[v], graph.getVertexData()[v], distances[v]);
                    }
                }
            }
        }

        for (int u = 0; u < graph.getSize(); u++) {
            for (int v = 0; v < graph.getSize(); v++) {
                if (graph.getAdjacencyMatrix()[u][v] != 0 && distances[u] != Integer.MAX_VALUE &&
                    distances[u] + graph.getAdjacencyMatrix()[u][v] < distances[v]) {
                    return new Result(true, null, null);
                }
            }
        }

        return new Result(false, distances, predecessors);
	}
	
	@Override
	public String dijkstra(char startVertexData, char endVertexData, Graph graph) {
        int[] predecessors = new int[graph.getSize()];
        Arrays.fill(predecessors, -1);
        Arrays.sort(graph.getVertexData());
        int startVertex = Arrays.binarySearch(graph.getVertexData(), startVertexData);
        int endVertex = Arrays.binarySearch(graph.getVertexData(), endVertexData);
        int[] distances = new int[graph.getSize()];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;
        boolean[] visited = new boolean[graph.getSize()];

        for (int count = 0; count < graph.getSize() - 1; count++) {
            int u = minDistance(distances, visited, graph);
    
            if (u == -1) {
                break;
            }

            if (u == endVertex) {
                System.out.println("Breaking out of loop. Current vertex: " + graph.getVertexData()[u]);
                System.out.println("Distances: " + Arrays.toString(distances));
                break;
            }
    
            visited[u] = true;
            System.out.println("Visited vertex: " + graph.getVertexData()[u]);
    
            for (int v = 0; v < graph.getSize(); v++) {
                if (!visited[v] && graph.getAdjacencyMatrix()[u][v] != 0 && distances[u] != Integer.MAX_VALUE && distances[u] + graph.getAdjacencyMatrix()[u][v] < distances[v]) {
                    distances[v] = distances[u] + graph.getAdjacencyMatrix()[u][v];
                    predecessors[v] = u;
                }
            }
        }

        String shortestPath = getPath(distances, predecessors, startVertex, endVertex, graph);
        return "Path: " + shortestPath + ", Distance: " + distances[endVertex];
    }
	
	@Override
	public String getShortestPath(int startVertex, int endVertex, Graph graph) {
        int[] distances = new int[graph.getSize()];
        int[] predecessors = new int[graph.getSize()];
        boolean[] visited = new boolean[graph.getSize()];
        for (int i = 0; i < graph.getSize(); i++) {
            distances[i] = Integer.MAX_VALUE;
            predecessors[i] = -1;
        }
        distances[startVertex] = 0;

        for (int i = 0; i < graph.getSize(); i++) {
            int u = -1;
            for (int j = 0; j < graph.getSize(); j++) {
                if (!visited[j] && (u == -1 || distances[j] < distances[u])) {
                    u = j;
                }
            }

            visited[u] = true;

            for (int v = 0; v < graph.getSize(); v++) {
                if (graph.getAdjacencyMatrix()[u][v] != 0 && !visited[v]) {
                    int alt = distances[u] + graph.getAdjacencyMatrix()[u][v];
                    if (alt < distances[v]) {
                        distances[v] = alt;
                        predecessors[v] = u;
                    }
                }
            }
        }

        StringBuilder path = new StringBuilder();
        for (int at = endVertex; at != -1; at = predecessors[at]) {
            path.insert(0, graph.getVertexData()[at] + (path.length() > 0 ? "->" : ""));
        }

        return path.toString() + ", Distance: " + distances[endVertex];
    }
	
    private int findIndex(Character data, Graph graph) {
        for (int i = 0; i < graph.getSize(); i++) {
            if (data.equals(graph.getVertexData()[i])) {
                return i;
            }
        }
        return -1;
    }

    private int minDistance(int[] distances, boolean[] visited, Graph graph) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < graph.getSize(); v++) {
            if (!visited[v] && distances[v] <= min) {
                min = distances[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
    
    public String getPath(int[] distances, int[] predecessors, int startVertex, int endVertex, Graph graph) {
        if (endVertex == -1 || distances[endVertex] == Integer.MAX_VALUE) {
            return "No path";
        }
    
        StringBuilder path = new StringBuilder();
        for(int vertex = endVertex; vertex != -1; vertex = predecessors[vertex]) {
            path.insert(0, graph.getVertexData()[vertex]);
            if(vertex != startVertex) {
                path.insert(0, "->");
            }
        }
        return path.toString();
    }
}
