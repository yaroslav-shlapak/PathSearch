package com.shlapak.yaroslav.pathsearch;

import java.util.ArrayDeque;
import java.util.Deque;

public class WavePathFind{
	private int height, width;
	private int matrix[][];
	private int startElem[];
	private int finishElem[];
	private int currentElem[];
	private int waveMat[][];
	private int tempElem[];
	private int generation = 1;
	private static final int[][] VAL = {{1, 1, 1, -1, -1, -1, 0, 0, 0},
										{1, -1, 0, 1, -1, 0, 1, -1, 0}};
	
	public WavePathFind(int matrix[][], int startElem[], int finishElem[]) {
		this.matrix = matrix;
		height = matrix.length;
		width = matrix[0].length;
		this.startElem = startElem;
		this.finishElem = finishElem;
		tempElem = new int[VAL[0].length];
	}
	
	public int[][] sendWave() {
		waveMat = new int[height][width];
		Deque<int[]> queue = new ArrayDeque<int[]>();
		printMatrix(matrix);
		queue.add(startElem);
		waveMat[startElem[0]][startElem[1]] = generation;
		while(!queue.isEmpty()) {
			setNear(queue);
			printMatrix(waveMat);
		}
		
		printMatrix(waveMat);
		return waveMat;
	}
	
	public int[][] getShortestPath() {
		int wayShortest[][] = new int[height][width];
		
		return wayShortest;
	}
	
	private void setNear(Deque<int[]> queue) {
		currentElem = queue.poll();
		for(int i = 0; i < ((VAL[0]).length); i++){
			for(int j = 0; j < ((VAL[1]).length); j++) {
				try{
				tempElem[0] = currentElem[0] + VAL[0][i];
				tempElem[1] = currentElem[1] + VAL[1][j];
				//System.out.println(VAL[0][j] + " " + VAL[1][i]);
				} catch(Exception e) {
					System.err.println(e.toString());
				}
				if(tempElem[0] >= 0 && tempElem[0] < (width - 1) &&
						tempElem[1] >= 0 && tempElem[1] < (height - 1)) {
					System.out.println(tempElem[0] + " " + tempElem[1]);
					if(matrix[tempElem[0]][tempElem[1]] == 1 &&
							waveMat[tempElem[0]][tempElem[1]] == 0 &&
							!(tempElem[0] == currentElem[0] && tempElem[1] == currentElem[1])) {
						System.out.println(tempElem[0] + " " + tempElem[1]);
						queue.add(tempElem);
						waveMat[tempElem[0]][tempElem[1]] = generation + 1;
					}
				}	
			}
		}
		generation++;
		
	}
	
	public void printMatrix(int matrix[][]) {
		for(int row[] : matrix) {
			for(int e : row) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}
	

}
