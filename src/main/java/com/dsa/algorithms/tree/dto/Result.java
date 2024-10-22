package com.dsa.algorithms.tree.dto;

public class Result {
	boolean hasNegativeCycle;
    int[] distances;
    Integer[] predecessors;

    public Result(boolean hasNegativeCycle, int[] distances, Integer[] predecessors) {
        this.hasNegativeCycle = hasNegativeCycle;
        this.distances = distances;
        this.predecessors = predecessors;
    }

	public boolean isHasNegativeCycle() {
		return hasNegativeCycle;
	}

	public void setHasNegativeCycle(boolean hasNegativeCycle) {
		this.hasNegativeCycle = hasNegativeCycle;
	}

	public int[] getDistances() {
		return distances;
	}

	public void setDistances(int[] distances) {
		this.distances = distances;
	}

	public Integer[] getPredecessors() {
		return predecessors;
	}

	public void setPredecessors(Integer[] predecessors) {
		this.predecessors = predecessors;
	}
}
