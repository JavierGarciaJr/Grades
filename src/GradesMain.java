import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Main driver for grades program
 * outputs the students order, score and grade
 * grade is on a curve, so the top score is 100%
 * and every 10 down is the next letter grade
 * in the text file, the score is an int on an individual line
 * @author Javier Garcia
 *
 */

public class GradesMain {
	/**
	 * main method of the program
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		runProgram(s);
	}
	/**
	 * this method runs outputs all the prompts for the user and calls all the methods in the helper class
	 * @param s
	 */
	public static void runProgram(Scanner s) {
		String answer = "";// initializes answer
		do {
			int start = GradesHelper.getVaildInt2(s,
					"Data Input Method Menu\n----------------------\n1. Input scores.\n2. Read scores from a file.\nEnter your selection: ",
					"Error, you must enter a selection from the menu");

			if (start == 1) {
				GradesHelper.printIntroduction();// prints the description
				int numstud = GradesHelper.getVaildInt(s, "Enter the number of students: ");// gets the number of
																							// students
				int[] scores = GradesHelper.createArray(numstud, s);// gets test scores
				int best = GradesHelper.findMaxGrade(scores);// finds the best test score
				GradesHelper.getLetterGrade(numstud, scores, best); // outputs final results
				System.out.println();
			} else {
				File f = GradesHelper.getFile(s, "Please input the name of the file: ");
				int nums = GradesHelper.nums(f);
				int[] scores = GradesHelper.createArray2(nums, f);
				int best = GradesHelper.findMaxGrade(scores);
				GradesHelper.getLetterGrade(nums, scores, best);
				System.out.println();
			}
			System.out.print("Do you have another test to score?");// asks user if they want to run again
			answer = s.nextLine();
			while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {// repeats if user entered an
																						// invalid input
				System.out.println("Please enter yes or no.");
				System.out.println("Do you have another test to score? ");
				answer = s.nextLine();
			}
		} while (answer.equalsIgnoreCase("yes"));// runs program again if user entered yes
	}

}
