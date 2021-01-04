import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Helper class for grades program
 * 
 * @author Javier Garcia
 *
 */

public class GradesHelper {
	/**
	 * prints the programs intro
	 */
	public static void printIntroduction() {
		System.out.println("     Welcome to the Grading Program!");// prints description
		System.out.println("=========================================");
		System.out.println("You will be prompted to enter the number");
		System.out.println("of students that you have to grade. Next,");
		System.out.println("you need to enter the scores. The results");
		System.out.println("will print in a table with the weighted");
		System.out.println("grades.");
		System.out.println();
		System.out.println();

	}
/**
 * creates an array that stores each of the students
 * @param numstud
 * @param s
 * @return
 */
	public static int[] createArray(int numstud, Scanner s) {
		int[] grades = new int[numstud];// puts the spaces in the grades array equal to numstud

		for (int i = 0; i < grades.length; i++) {// gives the prompts for each individual score
			grades[i] = getVaildInt(s, String.format("Score %d: ", i + 1));
		}

		return grades;
	}
	/**
	 * goes through all the scores and find the top score
	 * @param scores
	 * @return
	 */
	public static int findMaxGrade(int[] scores) {// finds best grade
		int best = 0;
		for (int i = 0; i < scores.length; i++) {
			if (best < scores[i]) {
				best = scores[i];
			}
		}
		return best;
	}
	/**
	 * determines the letter grade for all of the students scores
	 * @param numstud
	 * @param grade
	 * @param best
	 */
	public static void getLetterGrade(int numstud, int[] grade, int best) {
		System.out.println("Here are your results:");// prints result
		System.out.println("   Student     Score     Grade");

		for (int i = 0; i < numstud; i++) {
			
				System.out.print("         " + (i + 1) + "        " + grade[i] + "         ");
			
			if (grade[i] >= best - 10) {// finds letter grade
				System.out.print("A");
			} else if (grade[i] >= best - 20) {// finds letter grade
				System.out.print("B");
			} else if (grade[i] >= best - 30) {// finds letter grade
				System.out.print("C");
			} else if (grade[i] >= best - 40) {// finds letter grade
				System.out.print("D");

			} else if (grade[i] < best - 40) {// finds letter grade
				System.out.print("F");
			}

			System.out.println();
		}
	}
	/**
	 * assures that and int is entered for the amount of students
	 * @param s
	 * @param prompt
	 * @return
	 */
	public static int getVaildInt(Scanner s, String prompt) {
		System.out.print(prompt);

		while (!s.hasNextInt()) {// make sure user enters an integer
			s.nextLine();
			System.out.print(prompt);

		}

		int result = s.nextInt();

		s.nextLine();

		return result;
	}
	/**
	 * assures an int is added for the scores
	 * @param s
	 * @param prompt
	 * @param prompt2
	 * @return
	 */
	public static int getVaildInt2(Scanner s, String prompt, String prompt2) {
		int result = 0;
		int check = 0;
		do {

			if (check != 0) {
				System.out.print(prompt2);
			}

			System.out.print(prompt);

			while (!s.hasNextInt()) {// make sure user enters an integer
				s.nextLine();
				System.out.print(prompt2);
				System.out.print(prompt);

			}

			result = s.nextInt();
			check++;
		} while (result != 1 && result != 2);
		s.nextLine();

		return result;
	}
	/** 
	 * makes sure the file the user enters exists
	 * @param s
	 * @param prompt
	 * @return
	 */
	public static File getFile(Scanner s, String prompt) {
		int k = 0;

		System.out.print(prompt);
		File f = new File(s.nextLine());
		k++;

		while (!f.exists() || !f.canRead()) {
			System.err.println("Error, cannot read from file, please try again.");

			System.out.print(prompt);
			f = new File(s.nextLine());
		}
		return f;

	}
/**
 * gets the scores from a text file
 * @param f
 * @return
 */
	public static int nums(File f) {
		int num = 0;
		try {
			Scanner fileReader = new Scanner(f);

			while (fileReader.hasNextInt()) {
				fileReader.nextInt();
				num++;
			}

			fileReader.close();

		} catch (FileNotFoundException e) {
			System.err.println("Error: Cannot read");
		}

		return num;

	}
	/**
	 * creates another array for grades
	 * @param numstud
	 * @param f
	 * @return
	 */
	public static int[] createArray2(int numstud, File f) {
		int[] grades = new int[numstud];// puts the spaces in the grades array equal to numstud
		try {
			Scanner fileReader = new Scanner(f);
			for (int i = 0; i < numstud; i++) {// gives the prompts for each individual score
				grades[i] = fileReader.nextInt();
			}
			fileReader.close();

		} catch (FileNotFoundException e) {
			System.err.println("Error: Cannot read");
		}

		return grades;
	}
}
