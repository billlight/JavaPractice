import java.util.*;

public class ArrayCode{
	static void menu() {
	    System.out.println( "\n\n\t+-------- General List Help Menu  -------+\n");
	    System.out.println( "\t|    G/g£º Ask for a N, and generate N X N array of integers and fill the array with random integers 3 digits or say between 100 and 999|\n");
		System.out.println( "\t|    S/s: Display the array in N columns and N rows. ascending order.                                                                  |\n");
		System.out.println( "\t|    V/v: Rotate each of rechtagles circle one position.                                                                               |\n");
	    System.out.println( "\t+----------------------------------------+\n");
	    System.out.println( "\t|    ?/H/h: DisPlay this menu            |\n");
	    System.out.println( "\t|    Q/q: Exit                           |\n");
	    System.out.println( "\t+----------------------------------------+\n");
	}
	
	public static void sort2DArray(int[][] arr) {
	    int[] simpleArray = new int[(arr[0].length)*(arr.length)];
	    for(int r = 0; r < arr.length; r++) {
	        for(int c = 0; c < arr[0].length; c++) {
	        	simpleArray[arr[0].length*r+c] = arr[r][c]; 
	        }
	    }
	    Arrays.sort(simpleArray); 
	    for(int r = 0; r < arr.length; r++) {
	        for(int c = 0; c < arr[0].length; c++) {
	            arr[r][c] = ( simpleArray[(r * arr[0].length) + c ] ); 
	        }
	    }
	}
	
	public static void rotate2DArray(int[][] arr) {
		int N = arr.length;
		int[][] ret = new int[N][N];
		int start, end, i, j;
		for(start = 0, end = N-1; start<= end; start++, end--) {
			for(j = start; j+1 <= end; j++) ret[start][j] = arr[start][j+1];
			for(i = start; i+1 <= end; i++) ret[i][end]   = arr[i+1][end];
			for(j = start; j+1 <= end; j++) ret[end][j+1] = arr[end][j];
			for(i = start; i+1 <= end; i++) ret[i+1][start]   = arr[i][start];
		}
		for(start = 0, end = N-1; start < N; start++, end--) {
			if(start == end) ret[start][start]   = arr[start][start];
		}
	    for (int r = 0; r < N; r++) {
	        for (int c = 0; c < N; c++) {
	            arr[r][c] = ret[r][c];
	        }
	    }
	}
	
	public static void main(String[] args) {		
		int N = 0, i , j;
	    Scanner s = new Scanner(System.in);  // Create a Scanner object
	    Random r = new Random();
	    int [][] iArr = new int[0][0];
	    char c = ' ';
	    while ( c != 'Q' && c != 'q' ) {
	    	System.out.println( "\nType ? for help, Q, q to quit or G/S/V command: ");
	    	c = s.next().charAt(0);
	    	switch(c) {
	        	case '?': case 'H': case 'h':
	        		menu();
	        		break;
	        	case 'g': case 'G':
	        		System.out.println( "\n Ask for N, and generate N X N array of integers");
	        		N = s.nextInt();
	        		iArr = new int[N][N];
	        		for(i = 0; i < N; i++) {
	        			System.out.println();
	        			for(j = 0; j < N; j++) {
	        				iArr[i][j] = r.nextInt(999-100)+100;
	        				System.out.printf("[%d][%d] %d ",i ,j, iArr[i][j]);
	        			}
	        		}
	        		System.out.println();
	        		break;
	        	case 's': case 'S':
	        		sort2DArray(iArr);
	        		for(i = 0; i < N; i++) {
	        			System.out.println();
	        			for(j = 0; j < N; j++) {
	        				System.out.printf("[%d][%d] %d ",i ,j, iArr[i][j]);
	        			}
	        		}
	        		break;
	        	case 'v': case 'V':
	        		rotate2DArray(iArr);
	        		for(i = 0; i < N; i++) {
	        			System.out.println();
	        			for(j = 0; j < N; j++) {
	        				System.out.printf("[%d][%d] %d ",i ,j, iArr[i][j]);
	        			}
	        		}
	        		break;
	        	case 'q': case 'Q':
	        		return;
	    	} // end of switch
	    } // end of while
	    s.close();
	}
}
