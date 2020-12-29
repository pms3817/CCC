import java.util.Scanner;
import java.util.Arrays;

public class S2 {
	
	public static int rowNum = 0;
	public static int colNum = 0;

	public static int[][] initializeArray() {

		Scanner s = new Scanner(System.in);

		String strRowNum = s.nextLine();
		rowNum = Integer.parseInt(strRowNum);
		String strColNum = s.nextLine();
		colNum = Integer.parseInt(strColNum);

		int[][] array = new int[rowNum][colNum];

		for(int row = 0; row < rowNum; row++) {
		
			String rowCell = s.nextLine();

			for(int column = 0; column < colNum; column++) {
				
				String parts[] = rowCell.split(" ");
				int cell = Integer.parseInt(parts[column]);
				array[row][column] = cell;

			}

		}
		
		//format string with 3 characters, left-justified
		String format = "%-3s";
		
		//for every row in the array
		for(int row = 0; row < array.length; row++) {
			
			//for every column in the array
			for(int column = 0; column < array[row].length; column++) {
				
				//print array row and column using format
				System.out.format(format, array[row][column]);
				
			}//for
			
			//print new line after each row
			System.out.println();
			
		}//for
		
		s.close();

		return array;

	}
	
	public static void findFactorPairs(int num) {
		
		int count = 0;
		
		for(int i = 1; i < num + 1; i++) {
			
			//System.out.println(i <= rowNum);
			//System.out.println(num/i <= colNum);
			//System.out.println(num%i == 0);
			//System.out.println(i);
			
			if(num%i==0 && i <= rowNum && num/i <= colNum) {
				count++;
				System.out.println("test");
			}
			
		}
		
		String[] factorPairs = new String[count];
		
		int j = 0;
		
		for(int i = 1; i < num+1; i++) {
			
			if(num%i==0 && i <= rowNum && num/i <= colNum) {
				factorPairs[j] = "(" + i + ", " + (num/i) + ")";
				j +=1;
			}
			
		}
		
		String test = Arrays.toString(factorPairs);
		System.out.println(test);
		
	}
	
	public static String Escape(int[][] array) {
		int firstNum = array[0][0];
		System.out.println(firstNum);
		findFactorPairs(firstNum);
		return null;
		
	}

	public static void main(String[] args) {

		int[][] array = initializeArray();
		Escape(array);


	}

}
