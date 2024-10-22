package com.dsa.algorithms.tree.service;

import com.dsa.algorithms.tree.dto.AdjacencyMatrix;
import com.dsa.algorithms.tree.dto.Graph;
import com.dsa.algorithms.tree.dto.Graph2;
import com.dsa.algorithms.tree.dto.Result;

public interface GraphService {

	void printVertices(AdjacencyMatrix adjacencyMatrix);
	
	void printAdjacencyMatrix(AdjacencyMatrix adjacencyMatrix);

	void printConnections(AdjacencyMatrix adjacencyMatrix);

	void addUndirectedAdjacencyMatrixEdge(int u, int v, Graph graph);

	void addUndirectedAdjacencyMatrixEdge(int u, int v, Graph2 graph);
	
	void addUndirectedAdjacencyMatrixEdgeWithWeight(int u, int v, int weight, Graph graph);
	
	void addDirectedAdjacencyMatrixEdge(int u, int v, Graph graph);
	
	void addDirectedAdjacencyMatrixEdgeWithWeight(int u, int v, int weight, Graph graph);
	
	void addVertexData(int vertex, char data, Graph graph);
	
	void addVertexData(int vertex, char data, Graph2 graph);
	
	int find(int i, Graph2 graph);

	void union(int x, int y, Graph2 graph);
	
	void printAdjacencyMatrixGraph(Graph graph);
	
	void printAdjacencyMatrixGraph(Graph2 graph);
	
	void dfsUtil(int v, boolean[] visited, Graph graph);

	boolean dfsUtil(int v, boolean[] visited, int parent, Graph graph);
	
	boolean dfsUtil(int v, boolean[] visited, boolean[] recStack, Graph graph);
	
	void dfs(char startVertexData, Graph graph);

	void bfs(char startVertexData, Graph graphWithUndirectedAdjacencyMatrix2);

	boolean isCyclicForUndirectedGraphs(Graph graph);

	boolean isCyclicForDirectedGraphs(Graph graph);

	boolean isCyclicForUndirectedGraphsUsingFindUnion(Graph2 graph);

	int[] dijkstra(char startVertexData, Graph graph);
	
	int[] bellmanFord(Character startVertexData, Graph graph);
	
	Result bellmanFordReturningResult(Character startVertexData, Graph graph);

	String dijkstra(char startVertexData, char endVertexData, Graph graph);
	
	String getShortestPath(int startVertex, int endVertex, Graph graph);

	String getPath(Integer[] predecessors, char startVertex, char endVertex, Graph graph);

	

}
