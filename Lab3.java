
/**
 * @author Hiro
 *
 *         (C) Handling different types of files as well as input and output
 *         management methods: 7) Write a file handling program in Java with
 *         reader/writer.
 *         
 *          
 *         8) Write a Java program that read from a file and
 *         write to file by handling all file related exceptions. ** 9) Write a
 *         Java program that reads a line of integers, and then displays each
 *         integer, and the sum of all the integers (Use String Tokenizer class
 *         of java.util). **
 *
 */
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Lab3 {

	static void readFile(String filename, String contentDataType) {
		File file = new File(filename);
		Scanner f1;
		try {
			f1 = new Scanner(file);
			if (contentDataType == "String") {
				while (f1.hasNextLine()) {
					String data = f1.nextLine();
					System.out.println(data);
				}
			} else {
				while (f1.hasNextInt()) {
					int data = f1.nextInt();
					System.out.println(data);
				}
			}
			f1.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}

	}

	static void writeFile(String filename, String data) {
		FileWriter f1;
		try {
			f1 = new FileWriter(filename);
			f1.write(data);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	static boolean handleExceptions(String filename, char op) {
		File test = new File(filename);
		if (test.exists()) {
			if (test.canRead() & op == 'r' || test.canWrite() & op == 'w') {
				return true;
			}
			return false;
		}
		return false;
	}

	class FileHandler {

		FileHandler(String fileName, char operation) {
			System.out.print("begins");
			boolean flag = handleExceptions(fileName, operation);
			if (flag == false)
				System.out.print("Not enough influenze");
			System.exit(0);
			try {
				if (operation == 'r') {
					readFile(fileName, "String");
				} else {
					System.out.println("Input the data to write");
					String input = System.console().readLine();
					writeFile(fileName, input);
				}
			} catch (Exception e) {
				System.out.print(e);
			}
		}

	}

	static void sum() {
		File f1 = new File("numbers.txt");
		Scanner nos;
		try {
			nos = new Scanner(f1);
			String numbers = "";
			while (nos.hasNextLine()) {
				numbers += nos.nextLine();
				numbers += " ";
			}
			System.out.println(numbers);
			StringTokenizer ns = new StringTokenizer(numbers, " ");
			int sum = 0;
			while (ns.hasMoreTokens()) {
				sum += Integer.parseInt(ns.nextToken());
			}
			System.out.println(sum);
			nos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Lab3 lab = new Lab3();
//		String filename = "stress.log";
//		writeFile(filename,"Hello sdsssss");
//		readFile(filename,"String");
//		FileHandler fH = lab.new FileHandler(filename,'r');		
//		System.out.print("SDs");
		sum();
	}

}
