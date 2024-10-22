package com.dsa.algorithms.tree.dto;

public class Graph {
	private int[][] adjacencyMatrix;
    private char[] vertexData;
    private int size;
    
    public Graph(int size) {
        this.size = size;
        this.adjacencyMatrix = new int[size][size];
        this.vertexData = new char[size];
    }

	public int[][] getAdjacencyMatrix() {
		return adjacencyMatrix;
	}

	public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}

	public char[] getVertexData() {
		return vertexData;
	}

	public void setVertexData(char[] vertexData) {
		this.vertexData = vertexData;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
    
    
}
