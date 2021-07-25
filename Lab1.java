
/**
 1) Write a Java program that checks whether a given string is a palindrome or not. Ex: MALAYALAM is palindrome. 
 
 * Take the new Scanner(System.in) as String length = new Scanner(System.in).length() flag = True; for (int i = 0;
 * i<length//2;i++){ compare(new Scanner(System.in).charAt(i),new Scanner(System.in)[length-i-1]; if different : flag =
 * False break }
 * 
 2) Write a Java Program to find the frequency of a given character in a string. **
	Take new Scanner(System.in) both word and char
	iterate and when the char is found - increment count.
	Display count
	
 3) Write a Java program to multiply two given matrices. **
 
 	One row element of first matrix is multiplied by all columns of second matrix.
 */

import java.util.Arrays;
import java.util.Scanner;


public class Lab1 {
	static boolean isPalindrome() {
		System.out.println("Type a word");
		String str = new Scanner(System.in).nextLine();
		int length = str.length();
		for (int i = 0; i < length / 2; i++) {
			if (str.charAt(i) != str.charAt(length - i - 1)) {
				System.out.println("Not a Palindrome");
				return false;
			}
		}
		System.out.println("Is a Palindrome");
		return true;
	}

	static void frequency() {
		System.out.println("Type a word");
		Scanner input = new Scanner(System.in)
		String str = input.nextLine();
		System.out.println("Type a char");
		char chari = input.nextLine().charAt(0);
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (chari == str.charAt(i))
				count++;
		}
		System.out.println(count);

	}

	
	static int[][] take_input(Scanner input) {		
		int[][] mat = new int[0][0];
		String rows[];
		int i=0;
		while(input.hasNextLine()) {
			i++;
			rows = input.nextLine().split(" ");
			int[] row = {};
			for(String no:rows) {
				try {
					int num = Integer.parseInt(no);
					row = Arrays.copyOf(row, row.length+1);
					row[row.length-1] = num;
				}
				catch(Exception e) {
					break;
				}
			}
			mat = Arrays.copyOf(mat, mat.length+1);
			mat[mat.length-1] = row;
//			System.out.println(Arrays.toString(row));
		}
		System.out.println(Arrays.deepToString(mat));		
		return mat;			
	}
	static void mulmatrix() {
		Scanner input = new Scanner(System.in);
		int a[][]; // { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } };
		int b[][];//{ { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } };
		
		System.out.println("Type the 1st mat");
	    a = take_input(input);
//	    input.nextLine();
	    System.out.println("Type the 2nd mat");
	    b = take_input(input);
		
		try { 
			int c[][] = new int[a.length][b[0].length];
			for (int i = 0; i < 3; i++) {// rows of 1st mat
				for (int j = 0; j < 3; j++) { //clns of corresponding row-1st mat
					c[i][j] = 0;
					for (int k = 0; k < 3; k++) //rows of correspoding column of 2nd mat
						c[i][j] += a[i][k] * b[k][j];
					System.out.print(c[i][j] + " ");
				}
				System.out.println();
			}
		}
		catch (Exception e){
			System.out.print("Incompatible matrixes");
			System.exit(0);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isPalindrome();
		frequency();	
		// mulmatrix();
//		while (true) {
//			isPalindrome();
//			frequency();
		}

	}


