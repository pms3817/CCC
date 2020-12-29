import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

public class S1 {

	public int location;
	public int time;

	public S1(int location, int time) {

		this.location = location;
		this.time = time;
	}

	//method that will initialize array
	public static S1[] initializeArray() {

		//create new scanner
		Scanner s = new Scanner(System.in);

		//ask the user to enter number of integers - that will be the size of array
		System.out.print("How many numbers would you like to enter? ");

		//receive user input and assign it to intNum
		String strNum = s.nextLine();

		int intNum = Integer.parseInt(strNum);

		//declare array of integers called numbers, with length intNum
		S1[] numbers = new S1 [intNum];

		//ask the user for numbers
		System.out.println("Please enter the numbers:");

		//loop until it reaches array length
		for (int i=0; i < intNum && s.hasNextLine(); i++) {
	
			
			String TAndL = s.nextLine();
			String parts[] = TAndL.split(" ");
			int time = Integer.parseInt(parts[0]);
			int location = Integer.parseInt(parts[1]);
			S1 m = new S1(location, time);
			numbers[i] = m;

		}

		//close scanner
		s.close();

		//return numbers
		return numbers;

	}

	public static void calculateSpeed(S1[] array) {

		Arrays.sort(array, Comparator.comparing(Main -> Main.time));

		double maxSpeed = 0;

		for(int k=0; k<array.length - 1; k++) {

			double timeDiff = array[k+1].time - array[k].time;
			double distanceDiff = array[k+1].location - array[k].location;
			double speed = (Math.abs(distanceDiff)) / timeDiff;

			if (speed > maxSpeed) {

				maxSpeed = speed;

			}

		}

		NumberFormat formatter = new DecimalFormat("#0.0");
		System.out.println(formatter.format(maxSpeed));


	}

	public static void main(String[] args) {

		S1[] array = initializeArray();
		calculateSpeed(array);

	}


}
