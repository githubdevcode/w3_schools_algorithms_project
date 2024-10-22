package com.dsa.algorithms.tree.dto;

public class Graph2 {
	private int[][] adjacencyMatrix;
    private char[] vertexData;
    private int[] parent;
    private int size;
    
    public Graph2(int size) {
        this.size = size;
        this.adjacencyMatrix = new int[size][size];
        this.vertexData = new char[size];
        this.parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
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

	public int[] getParent() {
		return parent;
	}

	public void setParent(int[] parent) {
		this.parent = parent;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
    
    
}
