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
	private static final int[] VAL = { -1, 0, 1 };

	public WavePathFind(int matrix[][], int startElem[], int finishElem[]) {
		this.matrix = matrix;
		height = matrix.length;
		width = matrix[0].length;
		this.startElem = startElem;
		this.finishElem = finishElem;
		tempElem = new int[2];
		currentElem = new int[2];
	}

	public int[][] getShortestPath() {
		waveMat = new int[height][width];
		Deque<int[]> queue = new ArrayDeque<int[]>();
		MatrixHelper.printMatrix(matrix);
		
		queue.add(new int[] { startElem[0], startElem[1] });
		waveMat[startElem[0]][startElem[1]] = generation;

		sendWave(queue);
		MatrixHelper.printMatrix(waveMat);

		queue.clear();
		queue.add(new int[] { finishElem[0], finishElem[1] });

		findShortestPath(queue);

		int[][] ans = new int[height][width];
		//copyMatrix(ans, matrix);
		writeAnswer(ans, queue);
		MatrixHelper.printMatrix(ans);
		return ans; 
	}

	private void sendWave(Deque<int[]> queue) {
		while (!queue.isEmpty()) {
			currentElem = queue.poll();
			generation = waveMat[currentElem[0]][currentElem[1]] + 1;
			for (int i : VAL) {
				for (int j : VAL) {
					try {
						tempElem[0] = currentElem[0] + i;
						tempElem[1] = currentElem[1] + j;
					} catch (Exception e) {
						System.err.println(e.toString());
					}

					if (isInBounds(tempElem)
							&& matrix[tempElem[0]][tempElem[1]] == 1
							&& waveMat[tempElem[0]][tempElem[1]] == 0
							&& !(tempElem[0] == currentElem[0] && tempElem[1] == currentElem[1])) {

						queue.add(new int[] { tempElem[0], tempElem[1] });
						waveMat[tempElem[0]][tempElem[1]] = generation;
						if (tempElem[0] == finishElem[0]
								&& tempElem[1] == finishElem[1]) {
							return;
						}
					}
				}
			}
		}
		System.out.println("The finish element is unreachable from start element");
	}

	private void findShortestPath(Deque<int[]> queue) {

		while (!(currentElem[0] == startElem[0] && currentElem[1] == startElem[1])) {
			boolean stop = false;
			currentElem = queue.getLast();
			for (int i : VAL) {
				for (int j : VAL) {
					tempElem[0] = currentElem[0] + i;
					tempElem[1] = currentElem[1] + j;
					if (isInBounds(tempElem)
							&& (waveMat[tempElem[0]][tempElem[1]] + 1) == waveMat[currentElem[0]][currentElem[1]]) {
						System.out.println(waveMat[tempElem[0]][tempElem[1]]);
						queue.add(new int[] { tempElem[0], tempElem[1] });
						stop = true;
						if (tempElem[0] == startElem[0]
								&& tempElem[1] == startElem[1]) {
							return;
						}
						break;
					}
				}
				if (stop)
					break;
			}
		}
	}



	private void writeAnswer(int[][] ans, Deque<int[]> queue) {
		int[] temp = new int[2];
		while (!queue.isEmpty()) {
			temp = queue.poll();
			ans[temp[0]][temp[1]] = -1;
		}
	}

	public boolean isInBounds(int[] elem) {
		return elem[0] >= 0 && elem[0] < height 
				&& elem[1] >= 0	&& elem[1] < width;
	}

}
