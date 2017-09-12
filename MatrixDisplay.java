package com.test;

import java.util.Scanner;

public class MatrixDisplay {
	static int row=0,col=0;  
	static int rowLen=0;
	static int colLen=0;
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int array[][];
		do{
			System.out.println("Enter row and col: ");		
			rowLen=scan.nextInt();
			colLen=scan.nextInt();
		}while(rowLen!=colLen);
		System.out.println("Enter array elements: \n");
		array=new int[rowLen][colLen];
		rowLen--;
		colLen--;
		for(int i=0;i<=rowLen;i++){
			for(int j=0;j<=colLen;j++){
				System.out.println("array["+(i+1)+"]["+(j+1)+"]: ");
				array[i][j]=scan.nextInt();
			}
		}
		scan.close();
		printMatrix(array);
		array=null;
	}

	public static void printMatrix(int array[][]){
		System.out.println("Matrix Zig-Zag display");
		row=0;
		col=colLen;
		do{
			if(row==0 && col==colLen){
				System.out.print("\t"+array[row][col]);
			}
			row++;
			if(row<=rowLen &&col<=colLen &&(row>=0 && col>=0))
				System.out.print("\t"+array[row][col]);
			upPrint(array);
			col--;
			if((row>=0 && col>=0) && (row<=rowLen && col<=colLen)){
				System.out.print("\t"+array[row][col]);
			}
			downPrint(array);
		}while(array[rowLen][0]!=array[row][col]);
	}

//Moving downward
	public static void downPrint(int array[][]){
		do{
			System.out.print("\t"+array[++row][++col]);			
		}while(col<array.length-1 && row<array[0].length-1);		
	}
//Moving Upward
	public static void upPrint(int array[][]){
		do{
			System.out.print("\t"+array[--row][--col]);
		}while(col!=0 && row!=0);		
	}

}
