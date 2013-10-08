package com.shlapak.yaroslav.pathsearch;

public class Main {
	int height, width;

	
	public static void main(String[] args) {
		int matrix[][] = 
			{	{1, 1, 1, 1, 1, 1, 1, 1},
				{0, 0, 0, 0, 0, 1, 1, 1},
				{1, 0, 0, 0, 0, 1, 1, 0},
				{1, 0, 1, 0, 0, 0, 1, 0},
				{1, 1, 1, 1, 1, 1, 1, 0},
				{1, 0, 0, 1, 0, 1, 1, 1},
				{1, 1, 0, 0, 0, 0, 0, 0},
				{1, 1, 1, 1, 1, 1, 1, 1},
			};
		int startElem[] = {0, 0};
		int finishElem[] = {7, 7};
		
		WavePathFind wpf = new WavePathFind(matrix, startElem, finishElem);
		wpf.sendWave();
		

	}
}
