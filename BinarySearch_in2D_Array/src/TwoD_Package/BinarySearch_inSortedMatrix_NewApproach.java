package TwoD_Package;

import java.util.Arrays;

//  The whole matrix is in Sorted Format

//Time Complexity   -->      O( log(N) + log(M) ) 

public class BinarySearch_inSortedMatrix_NewApproach {

	public static void main(String[] args) {
		int[][] arr= {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		System.out.print(Arrays.toString(search(arr,9)));
	}
	
/*
 * *****************Binary Search in Sorted Array**************************
 * 			
 * Approach: Take middle column and then apply Binary Search on it
 * 
 * Three Cases:
 * 
 *  1) if element == target   ->   answer found
 *  2) if element > target    ->   ignore rows after it
 *  3) if element < target    ->   ignore above rows
 * 
 *   In the end , when two rows are remaining ,then  check those cases.......
 *   
 *   Case 1:  -> Check whether the mid column you are at contains the answer??
 *   
 *   Case 2:  -> Consider the four parts  --> Apply simple Binary Search on it
 *     
 */
	
	
//	Search in the row provided between the cols provided
	static int[] BinarySearch(int[][] matrix,int row,int cStart,int cEnd,int target) {
		while(cStart<=cEnd) {
			int mid=cStart+(cEnd-cStart)/2;
			
			if(matrix[row][mid]==target) {
				return new int[] {row,mid};
			}

			if(matrix[row][mid]>target) {
				cEnd=mid-1;
			}else {
				cStart=mid+1;
			}
		}
		return new int[] {-1,-1};
	}
	
	static int[] search(int[][] matrix ,int target) {
		int rows=matrix.length;
		int cols=matrix[0].length; // be cautious, matrix maybe empty
		
		if(rows==1) {
			return BinarySearch(matrix,0,0,cols-1,target);
		}
		
		int rStart=0;
		int rEnd=rows-1;
		int cMid=cols/2;
		
//		run the loop till the two rows are remaining
		
		while(rStart<(rEnd-1)) {  //while this is true it will have more than two rows
			
			int mid=rStart+(rEnd-rStart)/2;
			
			if(matrix[mid][cMid] == target) {
				return new int[] {mid,cMid};
			}
			if(matrix[mid][cMid] < target) {
				rStart=mid;
			}else {
				rEnd=mid;
			}
			
		}
		
		//now we have two rows
		//check whether the target is in the col of 2 rows
		if(matrix[rStart][cMid] == target) {
			return new int[] {rStart,cMid};
		}
		if(matrix[rStart+1][cMid] == target) {
			return new int[] {rStart+1,cMid};
		}
		
		//search in first half
		if(target<=matrix[rStart][cMid-1]) {
			return BinarySearch(matrix,rStart,0,cMid-1,target);
		}
		//search in 2nd half
		if(target>=matrix[rStart][cMid+1] && target<=matrix[rStart][cols-1]) {
			return BinarySearch(matrix,rStart,cMid+1,cols-1,target);
		}
		//search in 3rd half
		if(target<=matrix[rStart+1][cMid-1]) {
			return BinarySearch(matrix,rStart+1,0,cMid-1,target);
		}
		//search in 4rth half
		else {
			return BinarySearch(matrix,rStart+1,cMid+1,cols-1,target);

		}
	}
	
	

}
