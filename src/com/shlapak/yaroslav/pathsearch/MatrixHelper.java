package com.shlapak.yaroslav.pathsearch;

public final class MatrixHelper {
	public static  void copyMatrix(int matrixTo[][], int matrixFrom[][]) {
		if (matrixTo.length != matrixFrom.length)
			return;
		if (matrixTo[0].length != matrixFrom[0].length)
			return;
		for (int i = 0; i < matrixFrom.length; i++) {
			for (int j = 0; j < matrixFrom[0].length; j++) {
				matrixTo[i][j] = matrixFrom[i][j];
			}
		}
	}
	
	public static void printMatrix(int matrix[][]) {
		for (int row[] : matrix) {
			for (int e : row) {
				if(e == -1)
					System.out.print("X");
				else
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
	
	public static void generateMarix(int matrix[][], int height, int width) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (Math.random() > 0.6)
					matrix[i][j] = 0;
				else
					matrix[i][j] = 1;
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}
	
	public static int[] getElement(int[][] matrix) {
		int[] elem = new int[2];
		do {
		elem[0] =  (int) (matrix.length * Math.random());
		elem[1] =  (int) (matrix[0].length * Math.random());
		} 
		while(!checkElement(matrix, elem));
		
		return elem;
		
	}
	
	public static boolean checkElement(int[][] matrix, int[] elem){
		return matrix[elem[0]][elem[1]] != 0;
	}
}
