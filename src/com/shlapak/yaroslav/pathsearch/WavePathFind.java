package com.shlapak.yaroslav.pathsearch;

import java.util.ArrayDeque;
import java.util.Deque;

public class WavePathFind {
	private int height, width;
	private int matrix[][];
	private int startElem[];
	private int finishElem[];
	private int currentElem[];
	private int waveMat[][];
	private int tempElem[];
	private int generation = 1;
	private static final int[] VAL = { 1, -1, 0 };

	public WavePathFind(int matrix[][], int startElem[], int finishElem[]) {
		this.matrix = matrix;
		height = matrix.length;
		width = matrix[0].length;
		this.startElem = startElem;
		this.finishElem = finishElem;
		tempElem = new int[2];
		currentElem = new int[2];
	}

	public int[][] sendWave() {
		waveMat = new int[height][width];
		Deque<int[]> queue = new ArrayDeque<int[]>();
		printMatrix(matrix);
		queue.add(new int[] { startElem[0], startElem[0] });
		waveMat[startElem[0]][startElem[1]] = generation;
		while (!queue.isEmpty()) {
			currentElem = queue.poll();
			if (currentElem[0] == finishElem[0]
					&& currentElem[1] == finishElem[1]) {
				waveMat[currentElem[0]][currentElem[1]] =  + 1;
				break;
			}
			setNearCurrent(queue);
			printMatrix(waveMat);
		}
		queue.add(new int[] { finishElem[0], finishElem[0] });
		while (!queue.isEmpty()) {
			currentElem = queue.poll();
			if (currentElem[0] == startElem[0]
					&& currentElem[1] == startElem[1]) {
				
				break;
			}
			getMinNearCurrent(queue);
			printMatrix(waveMat);
		}
		int[][] ans = new int[height][width];
		copyMatrix(ans, matrix);
		writeAnswer(ans, queue);
		printMatrix(ans);
		return waveMat;
	}

	public int[][] getShortestPath() {
		int wayShortest[][] = new int[height][width];
		copyMatrix(wayShortest, matrix);

		return wayShortest;
	}

	private void setNearCurrent(Deque<int[]> queue) {
		for (int i : VAL) {
			for (int j : VAL) {
				try {
					tempElem[0] = currentElem[0] + i;
					tempElem[1] = currentElem[1] + j;
				} catch (Exception e) {
					System.err.println(e.toString());
				}

				if (tempElem[0] >= 0 && tempElem[0] < width && tempElem[1] >= 0
						&& tempElem[1] < height) {

					if (matrix[tempElem[0]][tempElem[1]] == 1
							&& waveMat[tempElem[0]][tempElem[1]] == 0
							&& !(tempElem[0] == currentElem[0] && tempElem[1] == currentElem[1])) {
						queue.add(new int[] { tempElem[0], tempElem[1] });
						waveMat[tempElem[0]][tempElem[1]] = 
								waveMat[currentElem[0]][currentElem[1]] + 1;
					}
				}
			}
		}

	}

	private void getMinNearCurrent(Deque<int[]> queue) {
		for (int i : VAL) {
			for (int j : VAL) {
				tempElem[0] = currentElem[0] + i;
				tempElem[1] = currentElem[1] + j;
				if((waveMat[tempElem[0]][tempElem[1]] - 1) == 
						waveMat[currentElem[0]][currentElem[1]]) {
					queue.add(new int[] { tempElem[0], tempElem[1] });
					return;
				}	
			}
		}

	}

	public void printMatrix(int matrix[][]) {
		for (int row[] : matrix) {
			for (int e : row) {
				System.out.print(e);
				if (e < 10)
					System.out.print("  ");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}
	
	private void writeAnswer(int[][] ans, Deque<int[]> queue) {
		int[] temp = new int[2];
		while(!queue.isEmpty()) {
			temp = queue.poll();
			ans[temp[0]][temp[0]] = 2;
		}
	}

	private void copyMatrix(int matrixTo[][], int matrixFrom[][]) {
		if (matrixTo.length == matrixFrom.length)
			return;
		if (matrixTo[0].length == matrixFrom[0].length)
			return;
		for (int i = 0; i < matrixFrom.length; i++) {
			for (int j = 0; j < matrixFrom[0].length; j++) {
				matrixTo[i][j] = matrixFrom[i][j];
			}
		}
	}

}
