import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class mattrix {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
//		
//		int mat1[][] = { { 2, 4 }, { 3, 5 } }; 
//	    int mat2[][] = { { 1, 2 ,3}, { 4, 5 ,6} }; 
//	    int m1 = 2, m2 = 2, n1 = 2, n2 = 3; 
//	    matrixMultiplication(m1,m2,mat1,n1,n2,mat2);
//	    
//	    int mat[][] = {{1,2},{3,4}};
//	    transposeOfMareix(mat);	
//		
//	    int r=in.nextInt();
//	    int c=in.nextInt();
//	    int[][] inputMatrix = new int[r][c];
//	    for(int i=0;i<r;i++){
//	      for(int j=0;j<c;j++)
//	      {
//	        inputMatrix[i][j]=in.nextInt();
//	      }   
//	    }
//	    spiralCopy(inputMatrix);
//
		int[][] m= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		rotateMatrixAntiClockWise90(m);
//		System.out.println();
//		rotateMatrixClockWise90(m);
//		System.out.println();
//		rotateMatrixClockWise180(m);
//
//		int mat[][] = {{0, 1, 0, 0, 1}, {1, 0, 1, 1, 0}, {0, 1, 0, 0, 1}, {1, 1, 1, 0, 0}}; 
//		uniqueRows(mat);
//		
//		int[][] matrixForRectangle = { { 1, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1 }, { 0, 0, 0, 1, 0 }, { 1, 0, 1, 0, 1 } };
//		findRectangleInMatrix(matrixForRectangle);
		

//		int[][] matrixForMaxOnes = { { 0, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 0 }, { 0, 1, 1, 1 } };
//		maxOneInEachRow(matrixForMaxOnes);
//		
//		  int mat[][] = { { 10, 20, 30, 40 }, 
//                  { 15, 25, 35, 45 }, 
//                  { 27, 29, 37, 48 }, 
//                  { 32, 33, 39, 50 } }; 
//		  findElementInRowAndColumnSortedMatrix(mat,29);

	}
	
    public static void matrixMultiplication(int m1,int m2,int[][] mat1,int n1,int n2,int[][] mat2) {
    	int[][] res=new int[m1][n2];
    	for(int i=0;i<m1;i++) {
    		for(int j=0;j<n2;j++) {
    			res[i][j]=0;
    			for(int k=0;k<m2;k++) {
    				res[i][j]=res[i][j]+mat1[i][k]*mat2[k][j];
    			}
    		}
    	}
    	for(int i=0;i<m1;i++) {
    		for(int j=0;j<n2;j++) {
    			System.out.print(res[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
    
    public static void transposeOfMareix(int[][] mat) {
    	for(int i=0;i<mat.length;i++) {
    		for(int j=0;j<=i;j++) {
    			int temp=mat[i][j];
    			mat[i][j]=mat[j][i];
    			mat[j][i]=temp;
    		}
    	}
    	for(int i=0;i<mat.length;i++) {
    		for(int j=0;j<mat.length;j++) {
    			System.out.print(mat[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
    
    public static void uniqueRows(int[][] mat) {
    	HashSet<String> set=new HashSet<String>();
    	StringBuilder temp=new StringBuilder();
    	for(int i=0;i<mat.length;i++) {
    		temp=new StringBuilder();
    		for(int j=0;j<mat[0].length;j++) {
    			temp.append(mat[i][j]);
    		}
    		if(!set.contains(temp)) {
    			set.add(temp.toString());
    		}else {
    			set.remove(temp.toString());
    		}
    	}
    	for(String key:set) {
    		System.out.println(key);
    	}
    } 
    
    /***********************  https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/   *********************/
    
	   static int[] spiralCopy(int[][] inputMatrix) {
		   int m=inputMatrix.length;
		   int n=inputMatrix[0].length;
		   int k=0,l=0,i=0;
		   int[] spiral=new int[m*n];
		   int j=0;
		   while(k<m && l<n) {
			   for(i=l;i<n;i++) {
				   spiral[j++]=inputMatrix[k][i];
			   }
			   k++;
			   for(i=k;i<m;i++) {
				   spiral[j++]=inputMatrix[i][n-1]; 
			   }
			   n--;
			   if(k<m) {
				   for(i=n-1;i>=l;i--) {
					   spiral[j++]=inputMatrix[m-1][i]; 
				   }
				   m--;
			   }
			   if(l<n) {
				   for(i=m-1;i>=k;i--) {
					   spiral[j++]=inputMatrix[i][l];
				   }
				   l++;
			   }
		   }
		   for(i=0;i<j;i++) {
		    	System.out.print(spiral[i]+" ");
		    }
		   return spiral;
	   }
	   
	    /************** https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/     ***************/
	    public static void rotateMatrixAntiClockWise90(int[][] m) {
	    	int n=m.length;
	    	for(int x=0;x<n/2;x++) {
	    		for(int y=x;y<n-1-x;y++) {
	    			int temp=m[x][y];
	    			m[x][y]=m[y][n-1-x];
	    			m[y][n-1-x]=m[n-1-x][n-1-y];
	    			m[n-1-x][n-1-y]=m[n-1-y][x];
	    			m[n-1-y][x]=temp;
	    		}
	    	}
	    	for(int i=0;i<n;i++) {
	    		for(int j=0;j<n;j++) {
	    			System.out.print(m[i][j]+" ");
	    		}
	    		System.out.println();
	    	}
	    }
	    
	    public static void rotateMatrixClockWise90(int[][] m) {
	    	int n=m.length;
	    	for(int x=0;x<n/2;x++) {
	    		for(int y=x;y<n-1-x;y++) {
	    			int temp=m[x][y];
	    			m[x][y]=m[n-1-y][x];
	    			m[n-1-y][x]=m[n-1-x][n-1-y];
	    			m[n-1-x][n-1-y]=m[y][n-1-x];
	    			m[y][n-1-x]=temp;
	    		}
	    	}
	    	for(int i=0;i<n;i++) {
	    		for(int j=0;j<n;j++) {
	    			System.out.print(m[i][j]+" ");
	    		}
	    		System.out.println();
	    	}
	    }
	    
	    public static void rotateMatrixClockWise180(int[][] m) {
	    	int n=m.length;
	    	int temp=0;
	    	for(int x=0;x<n/2;x++) {
	    		for(int y=x;y<n-1-x;y++) {
	    			temp=m[x][y];
	    			m[x][y]=m[n-1-x][n-1-y];
	    			m[n-1-x][n-1-y]=temp;
	    			temp=m[y][n-1-x];
	    			m[y][n-1-x]=m[n-1-y][x];
	    			m[n-1-y][x]=temp;
	    		}
	    	}
	    	for(int i=0;i<n;i++) {
	    		for(int j=0;j<n;j++) {
	    			System.out.print(m[i][j]+" ");
	    		}
	    		System.out.println();
	    	}
	    }
	    
	    /****************************    https://www.geeksforgeeks.org/find-rectangle-binary-matrix-corners-1/   ***************/
	    public static void findRectangleInMatrix(int[][] mat) {
	    	int r = mat.length;
	    	int c=mat[0].length;
	    	HashMap<Integer, Set<Integer>> map=new HashMap<Integer,Set<Integer>>();
	    	for(int i=0;i<r;i++) {
	    		for(int j=0;j<c-1;j++) {
	    			for(int k=j+1;k<c;k++) {
	    				if(mat[i][j]==1 && mat[i][k]==1) {
	    					if(map.containsKey(j) && map.get(j).contains(k)) {
	    						System.out.println("Rectangle Exist");
	    						return;
	    					}
	    					if(map.containsKey(k) && map.get(k).contains(j)) {
	    						System.out.println("Rectangle Exist");
	    						return;
	    					}
	    					if(!map.containsKey(j)) {
	    						Set s = new HashSet();
	    						s.add(k);
	    						map.put(j, s);
	    					}else {
	    						Set<Integer> list = map.get(j);
	    						list.add(k);
	    						map.put(j, list);
	    					}
	    					if(!map.containsKey(k)) {
	    						Set s = new HashSet();
	    						s.add(j);
	    						map.put(k, s);
	    					}else {
	    						Set<Integer> list = map.get(k);
	    						list.add(j);
	    						map.put(k, list);
	    					}
	    				}
	    			}
	    		}
	    	}
	    	System.out.println("Rectangle does not  Exist");
	    }
	    
	    /***************************   https://www.geeksforgeeks.org/find-row-number-binary-matrix-maximum-number-1s/        ************/
	    public static void maxOneInEachRow(int[][] mat) {
	    	int row=0;
	    	int j=mat[0].length-1;
	    	for(int i=0;i<mat.length;i++) {
	    		while(mat[i][j]==1 && j>=0) {
	    			row=i;
	    			j--;
	    		}
	    	}
	    	System.out.println("Row with max 1's is "+row);
	    	System.out.println("Number of 1's are "+(mat[0].length-j-1));
	    }
	    
	    
	    /*****************************   https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/       *******************/
	    public static void findElementInRowAndColumnSortedMatrix(int[][] mat,int x) {
	    	int n=mat.length;
	    	int i=0,j=n-1;
	    	while(i<n&&j>=0) {
	    		if(mat[i][j]==x) {
	    			System.out.println("Element found at position ["+i+","+j+"]");
	    			return;
	    		}else if(x>mat[i][j]) {
	    			i++;
	    		}else {
	    			j--;
	    		}
	    	}
	    	System.out.println("Element not present in given matrix");
	    }
    

}
