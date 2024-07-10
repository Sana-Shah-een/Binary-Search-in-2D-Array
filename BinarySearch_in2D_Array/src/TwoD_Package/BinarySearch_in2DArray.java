package TwoD_Package;

import java.util.Arrays;

// Matrix is sorted Row-Wise and Column-Wise

/*
 * *************Time Complexity*******************
 * 
 * 		If we using for loop then time complexity will be --> O(N'2)  OR O(NxM)
 * 
 * 		If using Binary Search Then  --> O(N)
 * 		
 */

public class BinarySearch_in2DArray {

	public static void main(String[] args) {
		int[][] arr= {
				{10,20,30,40},
				{15,25,35,45},
				{28,29,37,50},
				{33,34,38,55}
		};
		
		System.out.print(Arrays.toString(search_in_2D(arr,40)));
	}
	
	static int[] search_in_2D(int[][] matrix,int target) {
		int row=0;
		int col=matrix.length-1;
		
		while(row<matrix.length && col>=0) {
			if(matrix[row][col]==target) {
				return new int[] {row,col};
			}
			if(matrix[row][col]<target) {
				row++;
			}else {
				col--;
			}
			
		}
		return new int[] {-1,-1};
	}
		
}

