package com.shlapak.yaroslav.pathsearch;

public class Main {
	int height, width;

	
	public static void main(String[] args) {
		int height = 10;
		int width = 10;
		int[][] matrix = new int[height][width];
		MatrixHelper.generateMarix(matrix, height, width);
		int[] startElem = MatrixHelper.getElement(matrix);
		int[] finishElem = MatrixHelper.getElement(matrix);
		System.out.println("startElem " + startElem[0] + " " + startElem[1]);
		System.out.println("finishElem " + finishElem[0] + " " + finishElem[1]);
		
		WavePathFind wpf = new WavePathFind(matrix, startElem, finishElem);
		wpf.getShortestPath();
		

	}
	
}
