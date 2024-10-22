package com.dsa.algorithms.tree.dto;

public class AdjacencyMatrix {
	String[] vertexData;
	int[][] adjacencyMatrix;
	public AdjacencyMatrix(String[] vertexData, int[][] adjacencyMatrix) {
		super();
		this.vertexData = vertexData;
		this.adjacencyMatrix = adjacencyMatrix;
	}
	public String[] getVertexData() {
		return vertexData;
	}
	public void setVertexData(String[] vertexData) {
		this.vertexData = vertexData;
	}
	public int[][] getAdjacencyMatrix() {
		return adjacencyMatrix;
	}
	public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}
}
