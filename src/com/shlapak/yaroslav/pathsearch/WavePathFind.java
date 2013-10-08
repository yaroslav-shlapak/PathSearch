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
		queue.add(startElem);
		waveMat[startElem[0]][startElem[1]] = generation;
		while (!queue.isEmpty()) {
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
		System.out.println("currentElem = " + currentElem[0] + " " + currentElem[1]);
		for (int i : VAL) {
			for (int j : VAL) {

				try {
					tempElem[0] = currentElem[0] + i;
					tempElem[1] = currentElem[1] + j;
					//System.out.println("tempElem = " + tempElem[0] + " " + tempElem[1]);
				} catch (Exception e) {
					System.err.println(e.toString());
				}
				
				if (tempElem[0] >= 0 && tempElem[0] < (width - 1)
						&& tempElem[1] >= 0 && tempElem[1] < (height - 1)) {

					//System.out.println("tempElem = " + tempElem[0] + " " + tempElem[1]);
					//System.out.println("----------");

					if (matrix[tempElem[0]][tempElem[1]] == 1
							&& waveMat[tempElem[0]][tempElem[1]] == 0
							&& !(tempElem[0] == currentElem[0] && tempElem[1] == currentElem[1])) {
						
						System.out.println("2 tempElem = " + tempElem[0] + " " + tempElem[1]);
						
						queue.add(tempElem);
						waveMat[tempElem[0]][tempElem[1]] = generation + 1;
					}
				}
			}
		}
		generation++;

	}

	public void printMatrix(int matrix[][]) {
		for (int row[] : matrix) {
			for (int e : row) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}

}
